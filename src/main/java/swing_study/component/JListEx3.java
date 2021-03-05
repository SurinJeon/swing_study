package swing_study.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;
import javax.swing.BoxLayout;
import javax.swing.ListSelectionModel;

public class JListEx3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAdd;
	private DeptPanel pLeftCenter;
	private JList<Department> deptList;
	private DefaultListModel<Department> model;
	private JPanel pBtns;
	private JButton btnConfirm;
	private JButton btnUpdate;
	private JButton btnDelete;
	private int idx;

	public JListEx3() {
		initialize();
		
		model.addElement(new Department(1, "기획", 8));
		model.addElement(new Department(2, "영업", 10));
		model.addElement(new Department(3, "개발", 22));
		
	}
	private void initialize() {
		setTitle("JList 응용");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 619, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 0));
		
		JPanel pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		pLeftCenter = new DeptPanel();
		pLeft.add(pLeftCenter, BorderLayout.CENTER);
		
		JPanel pLeftSouth = new JPanel();
		pLeft.add(pLeftSouth, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pLeftSouth.add(btnAdd);
		
		JPanel pRight = new JPanel();
		pRight.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "\uBD80\uC11C\uBAA9\uB85D", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pRight);
		pRight.setLayout(new BorderLayout(0, 0));
		
		deptList = new JList<Department>();
		deptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		deptList.setModel(getDeptModel());
		pRight.add(deptList);
		
		pBtns = new JPanel();
		pRight.add(pBtns, BorderLayout.SOUTH);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		pBtns.add(btnConfirm);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		pBtns.add(btnDelete);
	}

	private ListModel<Department> getDeptModel() {
		model = new DefaultListModel<Department>();
		return model;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelete) {
			actionPerformedBtnDelete(e);
		}
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnUpdate(e);
		}
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnConfirm(e);
		}
		if (e.getSource() == btnAdd) { // btnAdd에 "추가"인지 "수정"인지 나누어야됨
			if (btnAdd.getText().equals("추가")) {
				actionPerformedBtnAdd(e);
			}else {
				actionPerformedUpdate(e);
			}
			
		}
	}
	
	private void actionPerformedUpdate(ActionEvent e) {
		Department upDept = pLeftCenter.getDepartment();
		model.set(idx, upDept);
		JOptionPane.showMessageDialog(null, "수정되었습니다.");
		
		pLeftCenter.clearTf();
		if (btnAdd.getText().equals("수정")) {
			btnAdd.setText("추가");
		}
	}
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Department dept = pLeftCenter.getDepartment();
		JOptionPane.showMessageDialog(null, dept); // 확인용 JOptionPane
		
		DefaultListModel<Department> model = (DefaultListModel<Department>) deptList.getModel();
		model.addElement(dept);
		JOptionPane.showMessageDialog(null, "추가되었습니다.");
		pLeftCenter.clearTf();
		
		
	}
	protected void actionPerformedBtnConfirm(ActionEvent e) {
		Department dept = deptList.getSelectedValue();
		String message = String.format("%s부서 (%d) %d층", dept.getDeptname(), dept.getDeptno(), dept.getFloor());
		JOptionPane.showMessageDialog(null, message);
		
		// 혹은 인덱스로 찾기 (근데 더 번거로움)
		/*
		int idx = deptList.getSelectedIndex(); // 선택된 인덱스를 가져옴
		Department selDept = model.get(idx);
		String message1 = String.format("%s부서 (%d) %d층", selDept.getDeptname(), selDept.getDeptno(), selDept.getFloor());
		JOptionPane.showMessageDialog(null, message1);
		*/
	}
	protected void actionPerformedBtnUpdate(ActionEvent e) {

		Department dept = deptList.getSelectedValue();
		idx = deptList.getSelectedIndex();
		pLeftCenter.setDepartment(dept);
		
//		model.removeElement(dept);

//		Department upDept = new Department();

		btnAdd.setText("수정");

//		if (btnAdd.isSelected()) {
//
//			model.setElementAt(upDept, idx);
//			JOptionPane.showMessageDialog(null, "수정되었습니다.");
//
//		}
	}
	protected void actionPerformedBtnDelete(ActionEvent e) {
		
		Department dept = deptList.getSelectedValue();
		model.removeElement(dept);
		JOptionPane.showMessageDialog(null, "삭제되었습니다.");
	}
}
