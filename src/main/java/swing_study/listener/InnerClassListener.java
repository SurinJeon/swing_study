package swing_study.listener;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class InnerClassListener extends JFrame {

	private JPanel contentPane;

	public InnerClassListener() {
		initialize();
	}

	private void initialize() {
		setTitle("Inner ClassListener");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener()); // 여기서 이벤트 발생하면 아래 클래스 안의 method로!
		contentPane.add(btn, BorderLayout.CENTER);
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e);
			JButton btn = (JButton) e.getSource();
			if (e.getActionCommand().equals("Action")) {
				btn.setText("Go");
			} else {
				btn.setText("Action");
			}

		}

	}
}
