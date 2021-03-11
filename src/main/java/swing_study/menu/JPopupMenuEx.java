package swing_study.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JPopupMenuEx extends JFrame {

	private JPanel contentPane;
	private String imgPath = System.getProperty("user.dir") + File.separator + "img" + File.separator;
	private ImageIcon icon = new ImageIcon(imgPath + "pear.jpg");
	private JLabel lblImg = new JLabel();

	public JPopupMenuEx() {
		initialize();
	}

	private void initialize() {
		setTitle("JPopupMenu Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.setComponentPopupMenu(createPopMenu());
		contentPane.add(lblImg, BorderLayout.SOUTH);
	}

	private JPopupMenu createPopMenu() {
		JPopupMenu popupMenu = new JPopupMenu();

		JMenuItem screen = new JMenuItem("Screen");
		screen.addActionListener(listener);
		popupMenu.add(screen);
		
		JSeparator separator_11 = new JSeparator();
		popupMenu.add(separator_11);
		
		JSeparator separator_12 = new JSeparator();
		popupMenu.add(separator_12);

		JMenuItem load = new JMenuItem("Load");
		load.addActionListener(listener);
		popupMenu.add(load);

		JSeparator separator = new JSeparator();
		popupMenu.add(separator);

		JMenuItem hide = new JMenuItem("Hide");
		hide.addActionListener(listener);
		popupMenu.add(hide);

		JSeparator separator_1 = new JSeparator();
		popupMenu.add(separator_1);

		JMenuItem reShow = new JMenuItem("ReShow");
		reShow.addActionListener(listener);
		popupMenu.add(reShow);

		JSeparator separator_2 = new JSeparator();
		popupMenu.add(separator_2);

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(listener);
		popupMenu.add(exit);

		return popupMenu;
	}

	ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			switch (cmd) {
			//			case "Screen":
			//				lblImg.setIcon(icon);
			//				JPopupMenuEx.this.invalidate();
			//				break;
			case "Load":
				lblImg.setIcon(icon);
				JPopupMenuEx.this.invalidate();
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
	};

}
