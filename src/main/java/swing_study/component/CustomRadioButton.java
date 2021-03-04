package swing_study.component;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class CustomRadioButton extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	// RadioButton들 field로 빼줌
	private JRadioButton rdbtnApple;
	private JRadioButton rdbtnPear;
	private JRadioButton rdbtnCherry;

	// 코드 최적화 위해 배열로 받아와서 공통 코드들 그냥 묶어버리기
	private ArrayList<JRadioButton> rdBtns;

	// getter 추가
	// getter를 추가했기때문에 다른 frame에 Morph해서 글자 보이게 할 수 있음
	public JRadioButton getRdbtnApple() {
		return rdbtnApple;
	}

	public JRadioButton getRdbtnPear() {
		return rdbtnPear;
	}

	public JRadioButton getRdbtnCherry() {
		return rdbtnCherry;
	}

	public CustomRadioButton() {
		rdBtns = new ArrayList<JRadioButton>();
		initialize();
		
		// 이 부분이 rdBtns ArrayList를 추가하며 바뀜
		rdBtns.add(rdbtnApple);
		rdBtns.add(rdbtnPear);
		rdBtns.add(rdbtnCherry);

	}

	private void initialize() {

		rdbtnApple = new JRadioButton("사과");
		buttonGroup.add(rdbtnApple);
		add(rdbtnApple);

		rdbtnPear = new JRadioButton("배");
		buttonGroup.add(rdbtnPear);
		add(rdbtnPear);

		rdbtnCherry = new JRadioButton("체리");
		buttonGroup.add(rdbtnCherry);
		add(rdbtnCherry);

	}

	public ArrayList<JRadioButton> getRdBtns() {
		return rdBtns;
	}

}
