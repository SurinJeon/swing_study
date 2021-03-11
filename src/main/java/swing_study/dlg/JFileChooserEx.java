package swing_study.dlg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JFileChooserEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn1;

	public JFileChooserEx() {
		initialize();
	}
	private void initialize() {
		setTitle("JFileChooser Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 429, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl1 = new JLabel("New label");
		contentPane.add(lbl1, BorderLayout.CENTER);
		
		btn1 = new JButton("클릭");
		btn1.addActionListener(this);
		contentPane.add(btn1, BorderLayout.EAST);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
//			actionPerformedBtn1(e);
		}
	}
//	protected void actionPerformedBtn1(ActionEvent e) {
//	 JOptionPane.showmessage
//	}
}












