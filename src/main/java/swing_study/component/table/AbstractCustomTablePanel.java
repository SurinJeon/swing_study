package swing_study.component.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 * @author surin
 * Parent Class (나머지는 이 class를 상속받을 것)
 */
@SuppressWarnings("serial")
public abstract class AbstractCustomTablePanel<T> extends JPanel {
	private JTable table;

	public AbstractCustomTablePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(getModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		scrollPane.setViewportView(table);
	}

	protected JTable getTable() {
		return table;
	}
	
	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}
	
	public Object[][] getData() {
		return new Object[][] { {null, null, null}, };
	}
	
	public void setList(List<T> list) {
		// setList는 다른 타입이 오는 toArray만 추상으로 해서 setList의 바디로 가져옴
		Object[][] data = new Object[list.size()][];

		for (int i = 0; i < data.length; i++) {
			data[i] = toArray(list.get(i));
		}
		
		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);
		
		// 정렬 되게 하는 부분
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
		/* 이 밑부분은 굴러가는 부분은 같으나 호출은 각자 해야함*/
		// 굴러가는 부분은 setTableCellAlign과 setTableCellWidth
		// 호출은 알아서 아래 추상method 구현 후 호출하도록 
		
		/*
		 * // 컬럼내용정렬
		 * setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
	 	 * // 컬럼별 너비 조정
		 * setTableCellWidth(100, 250, 100); 
		 */
		
		setAlignAndWidth();
		
	}
	
	protected abstract void setAlignAndWidth();
	public void setTableCellAlign(int align, int...idx) {
		// 컬럼 내용 정렬
			TableColumnModel tcm = table.getColumnModel(); // table의 각 column을 갖고오기 위함
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(align);
			
			for (int i = 0; i < idx.length; i++) {
				tcm.getColumn(idx[i]).setCellRenderer(dtcr);;
			}
		}
	
	public void setTableCellWidth(int...width) {
		TableColumnModel tcm = table.getColumnModel();
		
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	public abstract Object[] toArray(T t);
	
	public abstract String[] getColumnNames(); // 각 부분마다 다르니까 하위에서 정의해라

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
