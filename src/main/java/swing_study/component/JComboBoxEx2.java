package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JComboBoxEx2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox<String> cmb;
	private JLabel lblImg;
	
	private String imgPath = System.getProperty("user.dir") + File.separator  + "img" + File.separator;
	
	private ImageIcon[] icons = {
			new ImageIcon(imgPath + "apple.jpg"),
			new ImageIcon(imgPath + "cherry.jpg"),
			new ImageIcon(imgPath + "pear.jpg")
	};
	private String[] fruits = new String[] {"apple", "cherry", "pear"};
	
	HashMap<String, ImageIcon> map = new HashMap<String, ImageIcon>();
	
	
	public JComboBoxEx2() {
		
		for (int i = 0; i < icons.length; i++) {
			map.put(fruits[i], icons[i]);
		}
		
		initialize();
	}
	
	private void initialize() {
		setTitle("JComboBox Event Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		cmb = new JComboBox<String>();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(fruits);
		cmb.setModel(model);
		cmb.setSelectedIndex(-1);
		cmb.addActionListener(this);
		contentPane.add(cmb, BorderLayout.NORTH);
		
		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblImg, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmb) {
			actionPerformedCmb(e);
		}
	}
	protected void actionPerformedCmb(ActionEvent e) {
		Object obj = cmb.getSelectedItem();
//		int idx = cb.getSelectedIndex();
		lblImg.setIcon(map.get(obj));
	}
}
