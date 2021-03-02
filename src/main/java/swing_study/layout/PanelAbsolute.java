package swing_study.layout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAbsolute extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelAbsolute() {

		initialize();
	}
	private void initialize() {
		setLayout(null); // 절대 layout과 같음 (원하는 곳에 배치 가능)
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(347, 42, 57, 15);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(175, 130, 97, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(41, 197, 116, 21);
		add(textField);
		textField.setColumns(10);
	}
}
