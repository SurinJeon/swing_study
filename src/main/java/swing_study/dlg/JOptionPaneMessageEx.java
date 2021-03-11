package swing_study.dlg;

import java.awt.BorderLayout;
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

@SuppressWarnings("serial")
public class JOptionPaneMessageEx extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btn1;

	public JOptionPaneMessageEx() {
		initialize();
	}
	
	private void initialize() {
		setTitle("JOptionPaneMessage Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JLabel lbl1 = new JLabel("New label");
		contentPane.add(lbl1, BorderLayout.CENTER);
		
		btn1 = new JButton("클릭");
		btn1.addActionListener(this);
		contentPane.add(btn1, BorderLayout.EAST);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			actionPerformedBtn1(e);
		}
	}
	
	protected void actionPerformedBtn1(ActionEvent e) {
		String imgPath = System.getProperty("user.dir") + File.separator + "img" + File.separator;
		ImageIcon icon = new ImageIcon(imgPath + "home.png");
		JOptionPane.showMessageDialog(null, "조심하세요!", "warning", JOptionPane.WARNING_MESSAGE, icon);
	
	}

}
