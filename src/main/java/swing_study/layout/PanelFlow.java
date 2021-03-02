package swing_study.layout;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PanelFlow extends JPanel {

	public PanelFlow() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		p1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "align(Leading)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(p1);
		
		JButton btnLeading1 = new JButton("1");
		p1.add(btnLeading1);
		
		JButton btnLeading2 = new JButton("2");
		p1.add(btnLeading2);
		
		JPanel p2 = new JPanel();
		p2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "align(Center)", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, new Color(0, 0, 0)));
		add(p2);
		
		JButton btnCenter1 = new JButton("1");
		p2.add(btnCenter1);
		
		JButton btnCenter2 = new JButton("2");
		p2.add(btnCenter2);
		
		JPanel p3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) p3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.TRAILING);
		p3.setBorder(new TitledBorder(null, "align(Trailing)", TitledBorder.TRAILING, TitledBorder.TOP, null, null));
		add(p3);
		
		JButton btnTrailing1 = new JButton("1");
		p3.add(btnTrailing1);
		
		JButton btnTrailing2 = new JButton("2");
		p3.add(btnTrailing2);
	}

}
