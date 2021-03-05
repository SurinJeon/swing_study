package swing_study.component;

import java.awt.BorderLayout;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JListEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private String imgPath = System.getProperty("user.dir") + File.separator  + "img" + File.separator;
	// 아이콘을 미리 만들어놓음 << 여기에 imgPath 쓰려고 명시적으로 선언할때 같이 지정해버림
	private ImageIcon[] icons = {
			new ImageIcon(imgPath + "home.png"),
			new ImageIcon(imgPath + "scope.png"),
			new ImageIcon(imgPath + "wifi.png"),
			new ImageIcon(imgPath + "key.png")
	};

	private String[] fruits = new String[] {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
	private JButton btn01;
	private JList<String> strList;
	
	public JListEx() {
		initialize();
	}
	private void initialize() {
		setTitle("JList Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));
		
		strList = new JList<String>();
		strList.setListData(fruits);
		contentPane.add(strList);
		
		// 이미지 리스트
		// 어차피 icons를 안에 넣을걸 생성자에 넣으면 안되는가? << swing이 지원 안 함...
		// 그래서
		JList<ImageIcon> list = new JList<ImageIcon>();
		list.setListData(icons);
		contentPane.add(list);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns);
		
		btn01 = new JButton("First List Check");
		btn01.addActionListener(this);
		pBtns.add(btn01);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn01) {
			actionPerformedBtn01(e);
		}
	}
	protected void actionPerformedBtn01(ActionEvent e) {
		// 몇 번째인지 숫자로 받아오기
		int idx = strList.getSelectedIndex();
		
		// 그 값을 받아오기(여기서는 모두 String으로 되어있음)
		String selStr = strList.getSelectedValue();
		List<String> selectedList = strList.getSelectedValuesList();
		String message = String.format("index : %d%nselected Value : %s%nselectedList %s%n", idx, selStr, selectedList);
		
		JOptionPane.showMessageDialog(null, message);
		
		
	}
}













