package swing_study.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;

public class JPanelEx extends JFrame implements ActionListener {
	public JPanelEx() {
		initialize();
	}

	private DeptPanel contentPane;
	private JButton btnGetDept;
	private JButton btnSetDept;
	private JButton btnClear;
	private DeptPanel pDept;

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 100, 450, 300);
		contentPane = new DeptPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);

		btnSetDept = new JButton("부서 설정하기");
		btnSetDept.addActionListener(this);
		pBtn.add(btnSetDept);

		btnClear = new JButton("초기화");
		btnClear.addActionListener(this);

		btnGetDept = new JButton("부서 가져오기");
		btnGetDept.addActionListener(this);
		pBtn.add(btnGetDept);
		pBtn.add(btnClear);
		
		pDept = new DeptPanel();
		contentPane.add(pDept, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnSetDept) {
			actionPerformedSetDept(e);
		}
		if (e.getSource() == btnGetDept) {
			actionPerformedGetDept(e);
		}
	}

	protected void actionPerformedGetDept(ActionEvent e) {
		Department dept = pDept.getDepartment();
		JOptionPane.showMessageDialog(null, dept);

	}

	protected void actionPerformedSetDept(ActionEvent e) {

		Department dept = new Department(1, "기획", 9);
		pDept.setDepartment(dept);

	}

	protected void actionPerformedBtnClear(ActionEvent e) {

		pDept.clearTf();
	}
}
