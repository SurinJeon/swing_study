package swing_study.layout;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class PanelBorder extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelBorder() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(10, 10));
		
		JLabel lblNorth = new JLabel("North");
		lblNorth.setFont(new Font("굴림", Font.BOLD, 20));
		lblNorth.setOpaque(true); // JLabel은 원래 투명함 -> 이걸 불투명하게 바꿈
		lblNorth.setBackground(Color.ORANGE);
		lblNorth.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNorth, BorderLayout.NORTH); // 위치 북쪽에!
		
		JLabel lblCenter = new JLabel("Center");
		lblCenter.setFont(new Font("굴림", Font.BOLD, 20));
		lblCenter.setBackground(Color.RED);
		lblCenter.setOpaque(true);
		lblCenter.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCenter, BorderLayout.CENTER);
		
		JLabel lblWest = new JLabel("West");
		lblWest.setFont(new Font("굴림", Font.BOLD, 20));
		lblWest.setBackground(Color.CYAN);
		lblWest.setHorizontalAlignment(SwingConstants.CENTER);
		lblWest.setOpaque(true);
		add(lblWest, BorderLayout.WEST);
		
		JLabel lblEast = new JLabel("East");
		lblEast.setFont(new Font("굴림", Font.BOLD, 20));
		lblEast.setBackground(Color.GREEN);
		lblEast.setOpaque(true);
		add(lblEast, BorderLayout.EAST);
		
		JLabel lblSouth = new JLabel("South");
		lblSouth.setFont(new Font("굴림", Font.BOLD, 20));
		lblSouth.setBackground(Color.YELLOW);
		lblSouth.setHorizontalAlignment(SwingConstants.CENTER);
		lblSouth.setOpaque(true);
		add(lblSouth, BorderLayout.SOUTH);
	}

}
