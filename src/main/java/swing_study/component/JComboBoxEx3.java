package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import swing_study.panel.DeptPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JComboBoxEx3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private List<Department> deptList = new ArrayList<Department>();
	private JButton btnAdd;
	private JComboBox<Department> cmbDept;
	private DefaultComboBoxModel<Department> model;
	private DeptPanel pDept;
	private JButton btnCk;
	
	
	public JComboBoxEx3() {

		deptList.add(new Department(1, "기획", 8));
		deptList.add(new Department(2, "영업", 10));
		deptList.add(new Department(3, "개발", 22));
		initialize();
	}
	
	public void initialize() {
		setTitle("JComboBox Complex Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		pDept = new DeptPanel();
		pLeft.add(pDept, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		pLeft.add(pBtn, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		JPanel pRight = new JPanel();
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(2, 1, 0, 0));
		
		cmbDept = new JComboBox<Department>();
		model = new DefaultComboBoxModel<Department>(new Vector<>(deptList));
		
		cmbDept.setModel(model);
		pRight.add(cmbDept);
		
		btnCk = new JButton("확인");
		btnCk.addActionListener(this);
		pRight.add(btnCk);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCk) {
			actionPerformedBtnCk(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		model.addElement(pDept.getDepartment());
		JOptionPane.showMessageDialog(null, "추가되었습니다.");
		pDept.clearTf();
	}
	protected void actionPerformedBtnCk(ActionEvent e) {
		Object selDept = cmbDept.getSelectedItem();
		JOptionPane.showMessageDialog(null, selDept);
	}
}
