package swing_study.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class EmpPanel1 extends JPanel {

	private JTextField tfEmpNo;
	private JTextField tfEmpName;
	private JTextField tfEmpTitle;
	private JTextField tfEmpManager;
	private JTextField tfEmpSalary;
	private JTextField tfEmpDept;

	/*
	private int empNo;
	private String empName;
	private Title title; // 참조
	private Employee manager; // 내부참조
	private int salary;
	private Department dept;
	*/
	public EmpPanel1() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "사원정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblEmpNo = new JLabel("사원번호");
		lblEmpNo.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblEmpNo);
		
		tfEmpNo = new JTextField();
		add(tfEmpNo);
		tfEmpNo.setColumns(10);
		
		JLabel lblEmpName = new JLabel("사원명");
		lblEmpName.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblEmpName);
		
		tfEmpName = new JTextField();
		tfEmpName.setColumns(10);
		add(tfEmpName);
		
		JLabel lblEmpTitle = new JLabel("직책");
		lblEmpTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblEmpTitle);
		
		tfEmpTitle = new JTextField();
		tfEmpTitle.setColumns(10);
		add(tfEmpTitle);
		
		JLabel lblEmpManager = new JLabel("직속상사");
		lblEmpManager.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblEmpManager);
		
		tfEmpManager = new JTextField();
		tfEmpManager.setColumns(10);
		add(tfEmpManager);
		
		JLabel lblEmpSalary = new JLabel("급여");
		lblEmpSalary.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblEmpSalary);
		
		tfEmpSalary = new JTextField();
		tfEmpSalary.setColumns(10);
		add(tfEmpSalary);
		
		JLabel lblEmpDept = new JLabel("부서");
		lblEmpDept.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblEmpDept);
		
		tfEmpDept = new JTextField();
		tfEmpDept.setColumns(10);
		add(tfEmpDept);
	}

	public void setEmp(Employee emp) {
		tfEmpNo.setText(emp.getEmpNo() + "");
		tfEmpName.setText(emp.getEmpName());
		tfEmpTitle.setText(emp.getTitle().gettNo() + "");
		tfEmpManager.setText(emp.getManager().getEmpNo() + "");
		tfEmpSalary.setText(emp.getSalary() + "");
		tfEmpDept.setText(emp.getDept().getDeptno() + "");
	}
	
	public Employee getEmp() {
		int empNo = Integer.parseInt(tfEmpNo.getText().trim());
		String empName = tfEmpName.getText().trim();
		Title title = new Title(Integer.parseInt(tfEmpTitle.getText().trim()));
		Employee manager = new Employee(empNo);
		int salary = Integer.parseInt(tfEmpSalary.getText() + "");
		Department dept = new Department(Integer.parseInt(tfEmpDept.getText().trim()));
		
		return new Employee(empNo, empName, title, manager, salary, dept);
	}
	
	public void clearTf() {
		tfEmpNo.setText("");
		tfEmpName.setText("");
		tfEmpTitle.setText("");
		tfEmpManager.setText("");
		tfEmpSalary.setText("");
		tfEmpDept.setText("");
	}

}
