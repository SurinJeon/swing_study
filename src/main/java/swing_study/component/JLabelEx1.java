package swing_study.component;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JLabelEx1 extends JFrame {

	private JPanel contentPane;

	public JLabelEx1() {
		initialize();
	}
	private void initialize() {
		setTitle("Image");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		   						// 현재 실행하고 있는 홈 폴더경로
		String imgPath = System.getProperty("user.dir") + File.separator + "img" + File.separator;
		ImageIcon icon = new ImageIcon(imgPath + "blueflower.jpg");
		JLabel lblImg1 = new JLabel(icon);
		contentPane.add(lblImg1);
		// 근데 이렇게 하면 JLabel에 사진 전체가 들어오지 않음.... 크기에 맞춰서 넣는 방법은 아래
		
		// 레이블의 사이즈에 맞춰 이미지 변경
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		                                 // 이 처리를 해줘야 크기가 맞춰서 들어감
										 // 500 500은 픽셀 단위
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel lblImg2 = new JLabel(changeIcon);
		contentPane.add(lblImg2);
	}

}




























