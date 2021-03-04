package swing_study.component;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JRadioButtonEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private String imgPath = System.getProperty("user.dir") + File.separator  + "img" + File.separator;
	// 아이콘을 미리 만들어놓음 << 여기에 imgPath 쓰려고 명시적으로 선언할때 같이 지정해버림
	private ImageIcon[] icons = {
			new ImageIcon(imgPath + "apple.jpg"),
			new ImageIcon(imgPath + "cherry.jpg"),
			new ImageIcon(imgPath + "pear.jpg")
	};
	
	private JLabel lblImg;
	
	
	public JRadioButtonEx() {
		initialize(); // component(보이는 부분)를 초기화하는 목표
	}
	private void initialize() {
		setTitle("RadioButton Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 10, 0));
		
		JPanel pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "Simple RadioButton", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new BoxLayout(pLeft, BoxLayout.X_AXIS));
		
		CustomRadioButton pRadio = new CustomRadioButton();
		pLeft.add(pRadio);
		
		JPanel pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "Complex RadioButton", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new BorderLayout(0, 0));
		
		CustomRadioButton panel = new CustomRadioButton();
		pRight.add(panel, BorderLayout.NORTH);
		
		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		pRight.add(lblImg, BorderLayout.CENTER);
		
		// 사과 배 체리 라디오버튼으로 구성된 arraylist의 내부 요소들을 for문으로 돌림
		for (JRadioButton r : panel.getRdBtns()) {
			r.addItemListener(this); // 이렇게 하면 세 개 다 itemListener가 달림
			// this의 의미..?
		}
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		// if문이 없다면 selected 와 deselected 둘다 이 문장이 작동됨
		// selected때만 팝업창 뜨게 하고싶음
		if (e.getStateChange() == ItemEvent.SELECTED) {
			JRadioButton rd = (JRadioButton)e.getSource();
//			JOptionPane.showMessageDialog(null, rd.getText());
			String text = rd.getText();
			switch (text) {
			case "사과":
				lblImg.setIcon(icons[0]);
				break;
			case "체리":
				lblImg.setIcon(icons[1]);
				break;
			default:
				lblImg.setIcon(icons[2]);
				break;
			} // end of switch
			
		} // end of if
		
	} // end of itemStateChanged()

}
