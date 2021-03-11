package swing_study.dlg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class JOptionPaneInputEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn1;
	private JLabel lblRes;
	private JLabel lbl2;
	private JButton btn2;
	private JLabel lblRes2;
	private JLabel lbl3;
	private JButton btn3;
	private JLabel lblRes3;
	private JLabel lbl4;
	private JButton btn4;
	private JLabel lblRes4;

	public JOptionPaneInputEx() {
		initialize();
	}
	private void initialize() {
		setTitle("JOptionPaneInput Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lbl1 = new JLabel("Object message");
		lbl1.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbl1);
		
		btn1 = new JButton("InputDlg");
		btn1.setFont(new Font("굴림", Font.BOLD, 20));
		btn1.addActionListener(this);
		contentPane.add(btn1);
		
		lblRes = new JLabel("New label");
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblRes);
		
		lbl2 = new JLabel("Object message, ObalSelectionValue");
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbl2);
		
		btn2 = new JButton("InputDlg");
		btn2.addActionListener(this);
		btn2.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(btn2);
		
		lblRes2 = new JLabel("New label");
		lblRes2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes2.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblRes2);
		
		lbl3 = new JLabel("parentComponent, message, title, messageType");
		lbl3.setFont(new Font("굴림", Font.BOLD, 12));
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbl3);
		
		btn3 = new JButton("InputDlg");
		btn3.addActionListener(this);
		btn3.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(btn3);
		
		lblRes3 = new JLabel("New label");
		lblRes3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes3.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblRes3);
		
		lbl4 = new JLabel("parentComponent, message, title, messageType, icon, selectionValues, initialSelectionValue");
		lbl4.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbl4);
		
		btn4 = new JButton("InputDlg");
		btn4.addActionListener(this);
		btn4.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(btn4);
		
		lblRes4 = new JLabel("New label");
		lblRes4.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes4.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblRes4);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn4) {
			actionPerformedBtn4(e);
		}
		if (e.getSource() == btn3) {
			actionPerformedBtn3(e);
		}
		if (e.getSource() == btn2) {
			actionPerformedBtn2(e);
		}
		if (e.getSource() == btn1) {
			actionPerformedBtn1(e);
		}
	}
	protected void actionPerformedBtn1(ActionEvent e) {
		try {
			String res = JOptionPane.showInputDialog("이름을 입력");
			// JOptionPane은 Input으로 받아온 안의 내용물을 모두 String으로 받음!
			System.out.println(res);

			if (res.length() == 0) {
				lblRes.setText("입력값이 없습니다.");
			} else {
				lblRes.setText("입력값은 " + res + "입니다.");
			}
		} catch (NullPointerException ne) {
			System.err.println(ne.getMessage());
//			ne.printStackTrace();
		}
	}
	
	protected void actionPerformedBtn2(ActionEvent e) {
		String res = JOptionPane.showInputDialog("이름을 입력", "짱수린");
		// 아무것도 쓰지 않아도 미리 값이 들어가있음
		lblRes2.setText(res);
	}
	
	protected void actionPerformedBtn3(ActionEvent e) {
		/*
		 * // 마지막은 아이콘이 달라지는 것
		 * <error message>
		 * ERROR_MESSAGE
		 * INFORMATION_MESSAGE
		 * WARNING_MESSAGE
		 * QUESTION_MESSAGE
		 * PLAIN_MESSAGE
		 */

		String res = JOptionPane.showInputDialog(null, "이름을 입력", "제목", JOptionPane.ERROR_MESSAGE); 
		JOptionPane.showInputDialog(null, "이름을 입력", "제목", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showInputDialog(null, "이름을 입력", "제목", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showInputDialog(null, "이름을 입력", "제목", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showInputDialog(null, "이름을 입력", "제목", JOptionPane.PLAIN_MESSAGE);
		
		lblRes3.setText(res);
	}
	
	protected void actionPerformedBtn4(ActionEvent e) {
		String imgPath = System.getProperty("user.dir") + File.separator + "img" + File.separator;
		ImageIcon icon = new ImageIcon(imgPath + "home.png");
		
		String[] selectionValues = {"짱수린", "짱짱수린", "짱짱짱수린", "전수린", "짱전수린"};
		String initialSelectionValue = "전수린";
		
		Object res = JOptionPane.showInputDialog(
				null,
				"이름을 선택하세요.",
				"이름선택", 
				JOptionPane.QUESTION_MESSAGE,
				icon,
				selectionValues,
				initialSelectionValue);
		
		lblRes4.setText("선택한 입력은 " + res);
	}
	
}










