package swing_study.component;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class JCheckBoxCustomEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private ArrayList<Fruit> list;
	private int sum;
	private JLabel lblRes;

	public JCheckBoxCustomEx(ArrayList<Fruit> list) {
		this.list = list;
		initialize();
		list.forEach(s -> System.out.println(s)); // 람다식으로 반복문 돌리지 않고도 활용 가능
	}
	private void initialize() {
		setTitle("JCheckBoxCustom Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("");
		pNorth.add(lblTitle);
		
		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		lblRes = new JLabel("");
		pSouth.add(lblRes);
		
		// fruit을 반복문 돌려서 체크박스 형태로 집어넣을 것
		String title = "";
		
		for(Fruit f : list) {
			title += f.toString() + " ";
			JCheckBox ck = new JCheckBox(f.getName());
			pCenter.add(ck);
			ck.addItemListener(this); // 이 class가 addItemListner()를 수행
		}
		
		lblTitle.setText(title);
	}
	@Override
	public void itemStateChanged(ItemEvent e) { // e에는 event가 발생한 component가 담겨져있음
		JCheckBox cb = (JCheckBox) e.getSource();
		
		// 선택된 과일을 가져오는 방법
		Fruit selectFruit = list.get(list.indexOf(new Fruit(cb.getText())));
		if (e.getStateChange() == ItemEvent.SELECTED) {
			// 선택되었다면
			sum += selectFruit.getPrice();
		} else {
			// 선택 해제되었다면
			sum -= selectFruit.getPrice();
		}
		
		lblRes.setText(sum + " ");
	}

}
