package swing_study.component.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import swing_study.panel.Department;

@SuppressWarnings("serial")
public class DeptTablePanel extends JPanel {
	private JTable table;


	public DeptTablePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(getModel());
		scrollPane.setViewportView(table);
	}
	
	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}
	
	public Object[][] getData() {
		return new Object[][] {
			{null, null, null},
		};
	}
	
	public String[] getColumnNames() {
		return new String[] {"부서번호", "부서명", "위치"};
	}

	public void setList(List<Department> deptList) {
		Object[][] data = new Object[deptList.size()][];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = toArray(deptList.get(i));
			// deptList에서 하나씩 가져와서 그걸 배열형태로 넣을 것 (그렇게 해야 2차원배열 됨)
		}
		
		// 쉽게 하기 위해 model로 가져옴
		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);
		
		// 컬럼내용정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		
		// 컬럼별 너비 조정
		setTableCellWidth(100, 250, 100); 
		
		// 조건에 맞는 셀 색조절 (필요하다면)
		
	}

	private void setTableCellWidth(int...width) {
		TableColumnModel tcm = table.getColumnModel();
		
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	private void setTableCellAlign(int align, int...idx) {
	// 컬럼 내용 정렬
		TableColumnModel tcm = table.getColumnModel(); // table의 각 column을 갖고오기 위함
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);;
		}
	}
	
	private Object[] toArray(Department department) {
		Object[] row = new Object[] {
				department.getDeptno(),
				department.getDeptname(),
				department.getFloor()
		};
		return row;
	}

	private class CustomTableModel extends DefaultTableModel{

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	}
	
}

