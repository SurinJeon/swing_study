package swing_study.component;

import java.awt.GridLayout;
import java.awt.JobAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JComboBoxEx1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	// 우리는 모두 String으로 실습할 것
	private JComboBox<String> cmb1;
	private JComboBox<String> cmb2;
	private JComboBox<String> cmb3;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;

	public JComboBoxEx1() {
		initialize();
		addDataCmb1();
		addDataCmb2();
		addDataCmb3();
	}
	
	// 배열을 이용한 추가
	private void addDataCmb1() {
		String[] fruits = new String[] {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
		
		for (String f : fruits) {
			cmb1.addItem(f);
		}
	}

	// 모델을 이용한 추가
	private void addDataCmb2() {
		String[] fruits = new String[] { "apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry",
				"blackberry" };

		DefaultComboBoxModel<String> cbm = (DefaultComboBoxModel<String>) cmb2.getModel();
		
		for (String f : fruits) {
			cbm.addElement(f);
		}

	}
	
	// 모델에 반복문 쓰지않고도 넣기 가넝함
	// 배열말고 arraylist로 해보기
	private void addDataCmb3() {
		List<String> fruits = Arrays.asList("apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry",
		"blackberry");
		
		// list로 만들면 vector로도 집어넣기 가넝함
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(new Vector<>(fruits));
		cmb3.setModel(model);
		
	}

	private void initialize() {
		setTitle("JComboBox Simple Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));
		
		JPanel pCmb1 = new JPanel();
		contentPane.add(pCmb1);
		
		cmb1 = new JComboBox<String>();
		pCmb1.add(cmb1);
		
		tf1 = new JTextField();
		tf1.addActionListener(this);
		pCmb1.add(tf1);
		tf1.setColumns(10);
		
		JPanel pCmb2 = new JPanel();
		contentPane.add(pCmb2);
		
		cmb2 = new JComboBox<String>();
		pCmb2.add(cmb2);
		
		tf2 = new JTextField();
		tf2.addActionListener(this);
		pCmb2.add(tf2);
		tf2.setColumns(10);
		
		JPanel pCmb3 = new JPanel();
		contentPane.add(pCmb3);
		
		cmb3 = new JComboBox<String>();
		pCmb3.add(cmb3);
		
		tf3 = new JTextField();
		tf3.addActionListener(this);
		pCmb3.add(tf3);
		tf3.setColumns(10);
	}

	// tf에 enter 쳤을때 해당 단어가 combobox에 추가되도록 해야함
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf1) {
			actionPerformedTf1(e);
		}
		if (e.getSource() == tf3) {
			actionPerformedTf3(e);
		}
		if (e.getSource() == tf2) {
			actionPerformedTf2(e);
		}
	}
	
	protected void actionPerformedTf1(ActionEvent e) {
		String item = tf1.getText().trim();
		JOptionPane.showMessageDialog(null, item); // 확인 출력용 팝업창
		cmb1.addItem(item);
		tf1.setText("");
	}
	protected void actionPerformedTf2(ActionEvent e) {
		String item = tf2.getText().trim();
		JOptionPane.showMessageDialog(null, item);
		cmb2.addItem(item);
		tf2.setText("");
	}
	protected void actionPerformedTf3(ActionEvent e) {
		String item = tf3.getText().trim();
		JOptionPane.showMessageDialog(null, item);
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmb3.getModel();
		model.addElement(item);
		tf3.setText("");
	}
	
}












