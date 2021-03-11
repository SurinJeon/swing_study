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
public class AnonymousClassListener extends JFrame {

	private JPanel contentPane;

	public AnonymousClassListener() {
		initialize();
	}

	private void initialize() {
		setTitle("Anonymous ClassListener");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btn = new JButton("Action");
		btn.addActionListener(new ActionListener() { // 여기서 바로 익명으로 클래스 만듦
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
		}); 
		contentPane.add(btn, BorderLayout.CENTER);
	}

}

