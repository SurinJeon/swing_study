package swing_study.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class TitlePanel extends JPanel {
	private JTextField tfTitleNo;
	private JTextField tfTitleName;

	public TitlePanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "직책정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblTitleNo = new JLabel("직책번호");
		lblTitleNo.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblTitleNo);
		
		tfTitleNo = new JTextField();
		add(tfTitleNo);
		tfTitleNo.setColumns(10);
		
		JLabel lblTitleName = new JLabel("직책명");
		lblTitleName.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblTitleName);
		
		tfTitleName = new JTextField();
		tfTitleName.setColumns(10);
		add(tfTitleName);
	}

	public void setTitle(Title title) {
		tfTitleNo.setText(title.gettNo() + "");
		tfTitleName.setText(title.gettName());
		
	}
	
	public Title getTitle() {
		int tNo = Integer.parseInt(tfTitleNo.getText().trim());
		String tName = tfTitleName.getText().trim();
		return new Title(tNo, tName);
	}
	
	public void clearTf() {
		tfTitleNo.setText("");
		tfTitleName.setText("");
	}
	
}
