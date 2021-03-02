package swing_study.layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FrameLayout extends JFrame {

	private JPanel contentPane;
	private LayoutGubun gubun;

	public FrameLayout(LayoutGubun gubun) {
		this.gubun = gubun;
		initialize();
	}
	
	private void initialize() {
		setTitle("Layout 종류");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// 조건에 따라서 flow border grid absolute가 되도록 만들 것
		JPanel pSwitch = null;
		
		switch(gubun) {
		case FLOW:
			pSwitch = new PanelFlow();
			setTitle("Flow Layout");
			break;
		case BORDER:
			pSwitch = new PanelBorder();
			setTitle("Border Layout");
			break;
		case GRID:
			pSwitch = new PanelGrid();
			setTitle("Grid Layout");
			break;
		case ABSOLUTE:
			pSwitch = new PanelAbsolute();
			setTitle("Absolute Layout");
			break;
		}
		
		contentPane.add(pSwitch, BorderLayout.CENTER);
		
//		setVisible(true);
	}

}
