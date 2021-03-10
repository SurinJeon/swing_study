package swing_study.component.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class MyTablePanel extends JPanel {
	private JTable table;
	
	public MyTablePanel() {
		initialize();
	} // end of constructor
	
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(getModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // table에서 선택을 하나만 할 수 있도록 함 
		scrollPane.setViewportView(table);
	} // end of initialize()
	
	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	} // end of getModel()

	public Object[][] getData() {
		Object[][] datas = new Object[1][7];
		datas[0] = new Object[]{null, null, null, null, null, null, null};
		/*
		return new Object[][] {
			{null, null, null, null, null, null, null},
		};
		*/
		return datas;
	} // end of getData()

	public void setList(List<Student> stdList) {
	// 받아온 List는 Collection! 이걸 2차원배열로 바꾸어주어야함	
		Object[][] datas = new Object[stdList.size()][];
		for (int i = 0; i < datas.length; i++) {
			// 1차원 배열 완성걸 가져오는 method toArray() << 내가만듦
			// 그걸 가지고 와서 행들 늘리는 것
			datas[i] = toArray(stdList.get(i));
		}
		
		CustomTableModel model = new CustomTableModel(datas, getColumnNames());
		table.setModel(model);
		
		// 컬럼 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1); // 0번째, 1번째 컬럼 정렬은 center로!
		setTableCellAlign(SwingConstants.RIGHT, 2, 3, 4, 5, 6); // 숫자로 된 속성들은 right 정렬로!
		
		// 컬럼별 너비조정
		setTableCellWidth(50, 150, 100, 100, 100, 100, 100); //모든 속성에 다 접근하도록 짠 method
		
		// 조건(총점이 200 미만은 빨강) 에 맞는 cell에 color 부여
		setTableCellCondition(0, 1, 2, 3, 4, 5, 6);
		
	}

	public void setTableCellCondition(int...idx) {
		ConditionTableCellRender ctcr = new ConditionTableCellRender();
		TableColumnModel tcm = table.getColumnModel();
		for(int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(ctcr);
		}
	}

	public void setTableCellWidth(int...width) {
		TableColumnModel tcm = table.getColumnModel();
		
		for(int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]); 
		}
	}

	public void setTableCellAlign(int align, int...idx) { // int int...idx는 가변배열!
		TableColumnModel tcm = table.getColumnModel();
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		for(int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
	private Object[] toArray(Student std) {
		Object[] data = new Object[] {
				std.getStdNo(),
				std.getStdName(),
				std.getKor(),
				std.getEng(),
				std.getMath(),
				std.getTotal(),
				String.format("%.2f", std.getAvg())};
		return data;
		// 이렇게 던져주면 1차원 배열 완성
	}

	public String[] getColumnNames() {
		return new String[] {"학생번호", "학생명", "국어", "영어", "수학", "총점", "평균"};
	} // end of getColumnNames()

	
	private class CustomTableModel extends DefaultTableModel{

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		// 수정금지
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	} // end of CustomTableModel

	private class ConditionTableCellRender extends JLabel implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(
				JTable table,
				Object value,
				boolean isSelected,
				boolean hasFocus,
				int row,
				int column) {
			setText(value == null? "" : value.toString());
			setOpaque(true); // 원래 JLabel은 투명색이니까 true로 바꿔줘야함
			int total = (int) table.getValueAt(row, 5);
			if (total < 200){
				setBackground(Color.orange);
			} else {
				setBackground(Color.white);
			}
			// 이거하면 정렬 안되어있음(위에 순서가 색깔칠하기부터여서..)
			// 정렬 설정!
			setHorizontalAlignment(SwingConstants.RIGHT);
			return this; // 나 자신을 돌려줌
		}
	} // end of ConditionTableCellRender
	
} // end of MyTablePanel
