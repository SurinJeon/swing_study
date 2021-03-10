package swing_study.component.table;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class BookTablePanel extends AbstractCustomTablePanel<Book> {

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5);

		setTableCellWidth(100, 250, 100, 100, 100, 100); 
		
		setTableCellCondition(0, 1, 2, 3, 4, 5);
		
	}

	@Override
	public Object[] toArray(Book book) {
		return new Object[] {
				book.getBookNo(),
				book.getBookTitle(),
				book.getIsRented() == 1? "대여가능" : "대여불가능",
				String.format("%s(%d)", book.getBookCategory().getCategoryName(), book.getBookCategory().getBookCategory()),
				String.format("%d권", book.getCount()),
				String.format("%d일", book.getRentalRange())
		};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"도서명", "도서제목", "대여여부", "도서구분", "권수", "대여기간"};
	}
	
	public void setTableCellCondition(int...idx) {
		ConditionTableCellRender ctcr = new ConditionTableCellRender();
		TableColumnModel tcm = super.getTable().getColumnModel();
		for(int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(ctcr);
		}
	}
	
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
			String isRented = (String) table.getValueAt(row, 2);
			if (isRented.equals("대여불가능")){
				setBackground(Color.orange);
			} else {
				setBackground(Color.white);
			}
			// 이거하면 정렬 안되어있음(위에 순서가 색깔칠하기부터여서..)
			// 정렬 설정!
			setHorizontalAlignment(SwingConstants.CENTER);
			return this; // 나 자신을 돌려줌
		}
	} // end of ConditionTableCellRender
	

}
