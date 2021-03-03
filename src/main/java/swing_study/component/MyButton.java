package swing_study.component;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButton extends JButton {

	String imgPath = System.getProperty("user.dir")
					+ File.separator
					+ "img"
					+ File.separator;
	
	public MyButton() {
		setIcon(new ImageIcon(imgPath + "normalIcon.gif"));
		setRolloverIcon(new ImageIcon(imgPath + "rolloverIcon.gif"));
		setPressedIcon(new ImageIcon(imgPath + "pressedIcon.gif"));
	}

	


}
