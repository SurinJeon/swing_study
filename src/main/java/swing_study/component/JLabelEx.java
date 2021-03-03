package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class JLabelEx extends JFrame implements MouseListener {

	private JPanel contentPane;
	private String path = System.getProperty("user.dir") + File.separator  + "img" + File.separator;
	private JLabel lblNorth;
	// 환경이 달라졌을 때에도 접근할 수 있도록 path 따로 설정한 다음 파일명으로 찾는 것이 좋음
	private JLabel lblCenter;
	private JLabel lblSouth;
	
	public JLabelEx() {
		System.out.println(path);
		initialize();
	}
	private void initialize() {
		setBackground(Color.ORANGE);
		setTitle("JLabel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 416, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblNorth = new JLabel("love you");
		lblNorth.addMouseListener(this);
		lblNorth.setBackground(Color.MAGENTA);
		lblNorth.setFont(new Font("굴림", Font.ITALIC, 19));
		lblNorth.setOpaque(true);
		lblNorth.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNorth, BorderLayout.NORTH);
		
		lblCenter = new JLabel("");
		lblCenter.setOpaque(true);
		lblCenter.setIcon(new ImageIcon(path + "웨옹.png"));
		lblCenter.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCenter, BorderLayout.CENTER);
		
		lblSouth = new JLabel("call me back");
		lblSouth.setHorizontalAlignment(SwingConstants.CENTER);
		lblSouth.setBackground(Color.ORANGE);
		lblSouth.setOpaque(true);
		lblSouth.setIcon(new ImageIcon(path + "애옹.png"));
		contentPane.add(lblSouth, BorderLayout.SOUTH);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNorth) {
			mouseClickedLblNorth(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLblNorth(MouseEvent e) {
		
		lblCenter.setIcon(new ImageIcon(path + "야옹.png"));
		lblSouth.setText("miss you");
		JOptionPane.showMessageDialog(null, "changed");
	}
}
