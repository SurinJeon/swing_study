package swing_study.component;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;
import swing_study.panel.EmpPanel;
import swing_study.panel.Employee;
import swing_study.panel.Title;
import swing_study.panel.TitlePanel;

public class JTabbedPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCk;
	private JTabbedPane tabbedPane;
	private DeptPanel pDept;
	private TitlePanel pTitle;
	private EmpPanel pEmp;

	public JTabbedPaneEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		pDept = new DeptPanel();
		tabbedPane.addTab("Dept", null, pDept, "Dept Management");
		
		pTitle = new TitlePanel();
		tabbedPane.addTab("Title", null, pTitle, "Title Management");
		
		pEmp = new EmpPanel();
		tabbedPane.addTab("Emp", null, pEmp, "Emp Management");
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		
		btnCk = new JButton("확인");
		btnCk.addActionListener(this);
		pBtn.add(btnCk);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCk) {
			actionPerformedBtnCk(e);
		}
	}
	protected void actionPerformedBtnCk(ActionEvent e) {
		// 1. 현재 선택된 탭을 가져오기
		// 2. getXX호출하기
		Component comp = tabbedPane.getSelectedComponent();
		if(comp.equals(pDept)) {
			DeptPanel deptPanel = (DeptPanel) comp;
			Department department = deptPanel.getDepartment();
			JOptionPane.showMessageDialog(null, department);
			pDept.clearTf();
		}
		
		if(comp.equals(pTitle)) {
			TitlePanel titlePanel = (TitlePanel) comp;
			Title title = titlePanel.getTitle();
			JOptionPane.showMessageDialog(null, title);
			pTitle.clearTf();
		}
		
		if(comp.equals(pEmp)) {
			EmpPanel empPanel = (EmpPanel) comp;
			Employee employee = empPanel.getEmployee();
			JOptionPane.showMessageDialog(null, employee);
			pEmp.clearTf();
		}
	}
}
