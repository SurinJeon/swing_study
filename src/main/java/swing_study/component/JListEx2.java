package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;

/**
 * @author surin
 * p113~114
 * 실시간으로 리스트에 데이터가 추가될 때 방법
 */
public class JListEx2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfValue;
	private JList<String> nameList; // 외부에서 데이터 추가하는 활동 할 것이기 때문에 필드로 뺌!
	private ArrayList<String> stdList = new ArrayList<String>();
	private JList<String> nameList2; // 벡터 말고 모델을 사용해서 할 것

	public JListEx2() {
		stdList.add("김바둑");
		stdList.add("김고영");
		stdList.add("짱수린");
		stdList.add("고등어");
		initialize();
	}
	private void initialize() {
		setTitle("실시간 추가");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("click <enter> after input");
		pNorth.add(lblTitle);
		
		tfValue = new JTextField();
		tfValue.addActionListener(this);
		pNorth.add(tfValue);
		tfValue.setColumns(10);
		
		JPanel pList = new JPanel();
		pList.setBorder(new EmptyBorder(0, 100, 0, 100));
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new GridLayout(1, 1, 10, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pList.add(scrollPane);
		
		nameList = new JList<>();
		nameList.setListData(new Vector<String>(stdList));
		
		nameList.setFixedCellWidth(100);
		nameList.setVisibleRowCount(5);
		scrollPane.setViewportView(nameList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pList.add(scrollPane_1);
		
		nameList2 = new JList<String>();
		nameList2.setModel(getModel(stdList)); // 우리가 getModel() method 만들어서 가져올 것 
		scrollPane_1.setViewportView(nameList2);
	}

	private ListModel<String> getModel(List<String> stdList) {
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(String e : stdList){
			model.addElement(e); // 추가하는 것 (반복문 돌려서 추가할 것)
		}
		return model;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfValue) {
			actionPerformedTfValue(e);
		}
	}
	protected void actionPerformedTfValue(ActionEvent e) {
		String value = tfValue.getText().trim();
		JOptionPane.showMessageDialog(null, value); // 디버깅용 팝업창
		
		// scrollPane
		// 해당 글자를 데이터에 추가해줘야함
		stdList.add(value); // 근데 여기까지하면 보이지 않음(보이는 부분엔 반영 안 되었기 때문...)
		
		nameList.setListData(new Vector<String>(stdList));
		tfValue.setText(""); // 다시 입력창은 다 지워줘서 또 쓸 수 있도록
		tfValue.requestFocus();
		
		// scrollPane_1
		// 벡터방식처럼 새로 덮어쓰는게 아니라 그대로 model 가져와서 씀
		DefaultListModel<String> model = (DefaultListModel<String>) nameList2.getModel();
		model.addElement(value);
		
	}
}
