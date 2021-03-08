package swing_study.panel;



/**
 * @author surin
 * 원래 dto package 따로 해서 넣어야하지만 일단 학습상의 이유로 같은 panel 패키지에 넣음!
 */
public class Department {
	
	private int deptNo;
	private String deptName;
	private int floor;
//	private List<Employee> empList;
	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Department(int deptNo) {
		this.deptNo = deptNo;
	}



	public Department(int deptno, String deptname, int floor) {
		this.deptNo = deptno;
		this.deptName = deptname;
		this.floor = floor;
	}
	
	public int getDeptno() {
		return deptNo;
	}

	public void setDeptno(int deptno) {
		this.deptNo = deptno;
	}

	public String getDeptname() {
		return deptName;
	}

	public void setDeptname(String deptname) {
		this.deptName = deptname;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %d", deptNo, deptName, floor); 
	}
	
}
