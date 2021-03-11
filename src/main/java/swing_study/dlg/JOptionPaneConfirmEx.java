package swing_study.dlg;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class JOptionPaneConfirmEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn1;
	private JLabel lbl1;

	public JOptionPaneConfirmEx() {
		initialize();
	}

	private void initialize() {
		setTitle("OptionPaneConfirm Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 1, 0, 0));

		lbl1 = new JLabel("");
		lbl1.setFont(new Font("굴림", Font.BOLD, 20));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl1);

		btn1 = new JButton("New button");
		btn1.addActionListener(this);
		contentPane.add(btn1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			actionPerformedBtnNewButton(e);
		}
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		String imgPath = System.getProperty("user.dir") + File.separator + "img" + File.separator;
		ImageIcon icon = new ImageIcon(imgPath + "home.png");
		// JOptionPane.showConfirmDialog(parentComponent, message, title, optionType,
		// messageType, icon);

		/*
		 * <optionType> YES_NO_OPTION YES_NO_CANCEL_OPTION OK_CANCEL_OPTION
		 */
		int res = JOptionPane.showConfirmDialog(null, "계속 하시겠습니까?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, // 버튼을
				// 의미
				JOptionPane.WARNING_MESSAGE, icon);

		System.out.println(res); // 디버깅용 출력

		switch (res) {
		case JOptionPane.YES_OPTION:
			lbl1.setText("Yes");
			break;
		case JOptionPane.NO_OPTION:
			lbl1.setText("No");
			break;
		case JOptionPane.CANCEL_OPTION:
			lbl1.setText("Cancel");
			break;
		default:
			lbl1.setText("선택하지 않음");
		}

	}
}
