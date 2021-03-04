package swing_study.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class JTextFieldAreaEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfName;
	private JPasswordField pfPass1;
	private JPasswordField pfPass2;
	private JTextArea ta;
	private JLabel lblConfirm;
	private JDateChooser dateChooser;
	private JButton btnAdd;
	private Date d;
	private JButton btnCancel;

	public JTextFieldAreaEx() {
		initialize();
	}

	private void initialize() {
		setPreferredSize(new Dimension(450, 300));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pCenter.add(scrollPane, BorderLayout.CENTER);

		ta = new JTextArea();
		ta.setEditable(false);
		scrollPane.setViewportView(ta);

		JPanel pNorth = new JPanel();
		pNorth.setPreferredSize(new Dimension(450, 300));
		pNorth.setBorder(new EmptyBorder(10, 20, 10, 20));
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		pNorth.add(lblName);

		tfName = new JTextField();
		tfName.addActionListener(this);
		pNorth.add(tfName);
		tfName.setColumns(10);

		JLabel lblpass1 = new JLabel("비밀번호");
		lblpass1.setHorizontalAlignment(SwingConstants.TRAILING);
		pNorth.add(lblpass1);

		pfPass1 = new JPasswordField();
		pfPass1.getDocument().addDocumentListener(listener);
		pNorth.add(pfPass1);

		JLabel lblPass2 = new JLabel("비밀번호 확인");
		lblPass2.setHorizontalAlignment(SwingConstants.TRAILING);
		pNorth.add(lblPass2);

		pfPass2 = new JPasswordField();
		pfPass2.getDocument().addDocumentListener(listener);
		pNorth.add(pfPass2);

		JPanel panel = new JPanel();
		pNorth.add(panel);

		lblConfirm = new JLabel("");
		lblConfirm.setFont(new Font("굴림", Font.BOLD, 12));
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.RED);
		pNorth.add(lblConfirm);

		JLabel lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalAlignment(SwingConstants.TRAILING);
		pNorth.add(lblBirth);

		dateChooser = new JDateChooser(new Date());
		dateChooser.setDateFormatString("yyyy. MM. dd");
		pNorth.add(dateChooser);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pNorth.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pNorth.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
//		if (e.getSource() == tfName) {
//			actionPerformedTfName(e);
//		}
	}

//	protected void actionPerformedTfName(ActionEvent e) {
//		// 0이 아니라면 글자가 하나라도 입력되었다는 뜻
//		if (tfName.getText().length() != 0) {
//			d = dateChooser.getDate();
//			String msg = String.format("%s - %tF%n", tfName.getText(), d);
//			ta.append(msg);
//			tfName.setText("");
//		}
//	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
//		String pass1 = new String(pfPass1.getPassword());
//		String pass2 = new String(pfPass2.getPassword());
//		if (pass1.equals(pass2) && tfName.getText().length() != 0) {

		// 혹은
		if (lblConfirm.getText().equals("일치")) {
			d = dateChooser.getDate();
			String msg = String.format("%s - %tF%n", tfName.getText(), d);
			ta.append(msg);
			clearTf();
		} else {
			pfPass2.setText("");
			pfPass1.requestFocus(); // << pfPass1으로 다시 커서가 가도록
			pfPass1.selectAll(); // 쉽게 새로 입력할 수 있도록 전체가 블럭지정된 상태가 됨
			JOptionPane.showMessageDialog(null, "다시 시도해주세요.");
		}

	}

	public void clearTf() {
		tfName.setText("");
		pfPass1.setText("");
		pfPass2.setText("");
		dateChooser.setDate(new Date()); // datechooser 도 새 객체 넣어서 초기화시켜버림
		JOptionPane.showMessageDialog(null, "추가되었습니다.");
		lblConfirm.setText("");
		tfName.requestFocus(); // 다음 사항 다시 넣을 수 있도록 포커스를 성명 testField로 옮김
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		clearTf();
	}

	DocumentListener listener = new DocumentListener() {
		@Override
		public void removeUpdate(DocumentEvent e) {
			// 삭제될 때 호출
			getMessage();
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// 삽입할 때 호출
			getMessage();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// 바꼈을 때 호출
			getMessage();
		}

		private void getMessage() {
			String pw1 = new String(pfPass1.getPassword()); // char[]을 가지고 String 객체 생성 가능(생성자 있음)
			String pw2 = String.valueOf(pfPass2.getPassword()); // 이건 method로 생성

			if (pw1.equals(pw2)) {
				lblConfirm.setText("일치");
			} else {
				lblConfirm.setText("불일치");
			}

		}
	};

}
