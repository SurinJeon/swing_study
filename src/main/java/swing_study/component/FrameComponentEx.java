package swing_study.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FrameComponentEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn2;
	private JButton btn3;
	private JButton btn1;
	private JButton btn;

	public FrameComponentEx() {
		initialize();
	}

	private void initialize() {
		setTitle("공통속성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		btn1 = createBtn();
		contentPane.add(btn1);

		btn2 = new JButton("Disable Button");
		btn2.addActionListener(this);
		btn2.setEnabled(false);
		contentPane.add(btn2);

		btn3 = new JButton("getX(), getY()");
		btn3.addActionListener(this);
		contentPane.add(btn3);
	}

	public JButton createBtn() {
		btn = new JButton("Magenta/Yellow Button");
		btn.addActionListener(this);
		btn.setForeground(Color.MAGENTA);
		btn.setBackground(Color.YELLOW);
		btn.setFont(new Font("Arial", Font.ITALIC, 20));
		return btn;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			actionPerformedBtn(e);
		}
		if (e.getSource() == btn2) {
			actionPerformedBtn2(e);
		}
		if (e.getSource() == btn3) {
			actionPerformedBtn3(e);
		}
	}

	protected void actionPerformedBtn3(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		FrameComponentEx parent = (FrameComponentEx) btn.getTopLevelAncestor(); // 최상위 부모 가져옴
		parent.setTitle(btn.getX() + ", " + btn.getY());

		// btn3를 누르면 btn2를 활성화 비활성화 하는 방법
		if (btn2.isEnabled()) {
			btn2.setEnabled(false); // 이미 true라면 false 만들어주고
		} else {
			btn2.setEnabled(true); // 아니라면 true로 바꿔주기
		}
	}

	// btn2를 눌렀을 때 btn1이 있으면 >> btn1을 삭제
	protected void actionPerformedBtn2(ActionEvent e) {
		if (btn1 != null) {
			contentPane.remove(btn1);
			btn1 = null;
			revalidate(); // 삭제 됐으므로 새로 그릴 수 있도록 만드는 것
			return;
		} else {
			JButton btn = createBtn();
			contentPane.add(btn, 0);
			revalidate();
		}

	}

	protected void actionPerformedBtn(ActionEvent e) {
		if (btn3.isVisible()) {
			btn3.setVisible(false);
		} else {
			btn3.setVisible(true);
		}
	}
}
