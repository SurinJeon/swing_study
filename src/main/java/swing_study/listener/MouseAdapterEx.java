package swing_study.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MouseAdapterEx extends JFrame {

	private JPanel contentPane;
	private JLabel la = new JLabel("Hi");

	public MouseAdapterEx() {
		initialize();
	}

	private void initialize() {
		setTitle("MouseAdapter Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
 
		contentPane = new JPanel();

		contentPane.addMouseListener(new MyMouseAdapter());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		la.setSize(50, 20);
		la.setLocation(30, 30);
		contentPane.add(la);
		setContentPane(contentPane);

		setSize(250, 250);
		setVisible(true);
	}

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}

	}

}
