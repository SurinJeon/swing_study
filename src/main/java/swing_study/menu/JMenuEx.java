package swing_study.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JMenuEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblImg;
	private String imgPath = System.getProperty("user.dir") + File.separator + "img" + File.separator;
	ImageIcon icon = new ImageIcon(imgPath + "cherry.jpg");
	private JMenuItem mntmLoad;

	public JMenuEx() {
		initialize();
	}

	private void initialize() {
		setTitle("JMenu Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnScreen = new JMenu("Screen");
		menuBar.add(mnScreen);

		mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(this);
		mnScreen.add(mntmLoad);

		JSeparator separator = new JSeparator();
		mnScreen.add(separator);

		JMenuItem mntmHide = new JMenuItem("Hide");
		mntmHide.addActionListener(this);
		mnScreen.add(mntmHide);

		JSeparator separator_1 = new JSeparator();
		mnScreen.add(separator_1);

		JMenuItem mntmReShow = new JMenuItem("ReShow");
		mntmReShow.addActionListener(this);
		mnScreen.add(mntmReShow);

		JSeparator separator_2 = new JSeparator();
		mnScreen.add(separator_2);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(this);
		mnScreen.add(mntmExit);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblImg = new JLabel();
		contentPane.add(lblImg, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		
		switch (cmd) {
		case "Load":
			if (lblImg.getIcon() != null) {
				return;
			}
			lblImg.setIcon(icon);
			break;
		case "Hide":
			lblImg.setVisible(false);
			break;
		case "ReShow":
			lblImg.setVisible(true);
			break;
		case "Exit":
			System.exit(0);
			break;

		}

	}

}
