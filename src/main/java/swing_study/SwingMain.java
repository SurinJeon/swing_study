package swing_study;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.frame.JPanelEx;
import swing_study.frame.contentPaneEx;

public class SwingMain extends JFrame implements ActionListener {

	private JPanel contentPane; 
	private JButton btn01;
	private JButton btn02;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain frame = new SwingMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingMain() {
		initialize();
	}
	private void initialize() {
		setTitle("swing study");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10)); // 행 열 수평 수직
		
		btn01 = new JButton("JFrame Ex");
		btn01.addActionListener(this);
		contentPane.add(btn01);
		
		btn02 = new JButton("JPanel Ex");
		btn02.addActionListener(this);
		contentPane.add(btn02);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn02) {
			actionPerformedBtn02(e);
		}
		if (e.getSource() == btn01) {
			actionPerformedBtn01(e);
		}
	}
	protected void actionPerformedBtn01(ActionEvent e) {
		
		contentPaneEx frame = new contentPaneEx();
		frame.setVisible(true);
		
	}
	protected void actionPerformedBtn02(ActionEvent e) {
		
		JPanelEx frame = new JPanelEx();
		frame.setVisible(true);
		
	}
}
