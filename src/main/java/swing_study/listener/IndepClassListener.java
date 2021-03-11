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
public class IndepClassListener extends JFrame {

	private JPanel contentPane;

	public IndepClassListener() {
		initialize();
	}

	private void initialize() {
		setTitle("Indep ClassListener");
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

	// 독립 클래스로 하나 빼기 >> 근데 일단 한 파일에 클래스 두개로!!!

}

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		JButton btn = (JButton) e.getSource(); // 발생한 그 정보를 btn 형식으로 형변환해서 버튼으로 가져오기
		if (e.getActionCommand().equals("Action")) {
			btn.setText("Go");
		} else {
			btn.setText("Action");
		}

	}

}
