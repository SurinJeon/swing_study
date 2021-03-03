package swing_study.component;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JCheckBoxEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JCheckBox chckbxApple;
	private JLabel lblResult;
	private int sum;
	private String resStr = "현재 0원 입니다.";
	private JCheckBox chckbxPear;
	private JCheckBox chckbxCherry;
	
	public JCheckBoxEx() {
		initialize();
		chckbxCherry.setSelected(true); // 처음 초기값을 체리로 두려면 이 문장을 생성자에 넣으면 됨
	}
	private void initialize() {
		setTitle("JCheckBox Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 361, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth);
		pNorth.setLayout(new BoxLayout(pNorth, BoxLayout.Y_AXIS));
		
		JLabel lblTable = new JLabel("사과 100원, 배 500원, 체리 20000원");
		lblTable.setHorizontalAlignment(SwingConstants.CENTER);
		pNorth.add(lblTable);
		
		JPanel panel = new JPanel();
		pNorth.add(panel);
		
		chckbxApple = new JCheckBox("사과");
		chckbxApple.addItemListener(this);
		panel.add(chckbxApple);
		
		chckbxPear = new JCheckBox("배");
		chckbxPear.addItemListener(this);
		panel.add(chckbxPear);
		
		chckbxCherry = new JCheckBox("체리");
		chckbxCherry.addItemListener(this);
		panel.add(chckbxCherry);
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth);
		pSouth.setLayout(new BorderLayout(0, 0));
		
		lblResult = new JLabel(resStr);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		pSouth.add(lblResult);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == chckbxCherry) {
			itemStateChangedChckbxCherry(e);
		}
		if (e.getSource() == chckbxPear) {
			itemStateChangedChckbxPear(e);
		}
		if (e.getSource() == chckbxApple) {
			itemStateChangedChckbxApple(e);
		}
		resStr = String.format("현재 %d 원 입니다.", sum);
		lblResult.setText(resStr);
	}
	
	
	protected void itemStateChangedChckbxApple(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED){
			sum +=100; // 사과 선택함
		} else {
			sum -=100; // 사과 해제함
		}
	}
	protected void itemStateChangedChckbxPear(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED){
			sum +=500; 
		} else {
			sum -=500; 
		}
		
	}
	protected void itemStateChangedChckbxCherry(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			sum += 20000;
		} else {
			sum -=20000;
		}
	}
}
