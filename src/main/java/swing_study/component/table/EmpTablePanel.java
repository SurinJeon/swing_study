package swing_study.component.table;

import javax.swing.SwingConstants;

import swing_study.panel.Employee;

@SuppressWarnings("serial")
public class EmpTablePanel extends AbstractCustomTablePanel<Employee> {

	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 5);
		setTableCellAlign(SwingConstants.RIGHT, 4);

		// 컬럼별 너비 조정
		setTableCellWidth(100, 250, 100, 100, 100, 100);

	}

	@Override
	public Object[] toArray(Employee emp) {
		return new Object[] {
				emp.getEmpNo(),
				emp.getEmpName(),
				String.format("%s(%d)", emp.getTitle().gettName(), emp.getTitle().gettNo()),
				emp.getManager() == null ? "" : emp.getManager().getEmpName(),
				String.format("%,d", emp.getSalary()),
				String.format("%s(%d)", emp.getDept().getDeptname(), emp.getDept().getDeptno())
				};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {
			"사번", "사원명", "직책",
			"직속상사", "급여", "부서"
		};
	}

}
