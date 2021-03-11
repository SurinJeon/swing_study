package swing_study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import swing_study.component.FrameComponentEx;
import swing_study.component.Fruit;
import swing_study.component.JButtonEx;
import swing_study.component.JCheckBoxCustomEx;
import swing_study.component.JCheckBoxEx;
import swing_study.component.JComboBoxEx1;
import swing_study.component.JComboBoxEx2;
import swing_study.component.JComboBoxEx3;
import swing_study.component.JLabelEx;
import swing_study.component.JLabelEx1;
import swing_study.component.JListEx;
import swing_study.component.JListEx2;
import swing_study.component.JListEx3;
import swing_study.component.JRadioButtonEx;
import swing_study.component.JSliderEx;
import swing_study.component.JSpinnerEx;
import swing_study.component.JTabbedPaneEx;
import swing_study.component.JTableEx;
import swing_study.component.JTextFieldAreaEx;
import swing_study.dlg.JFileChooserEx;
import swing_study.dlg.JOptionPaneConfirmEx;
import swing_study.dlg.JOptionPaneInputEx;
import swing_study.dlg.JOptionPaneMessageEx;
import swing_study.frame.JPanelEx;
import swing_study.frame.contentPaneEx;
import swing_study.layout.FrameLayout;
import swing_study.layout.LayoutGubun;
import swing_study.listener.AnonymousClassListener;
import swing_study.listener.IndepClassListener;
import swing_study.listener.InnerClassListener;
import swing_study.listener.MouseAdapterEx;
import swing_study.listener.MouseListenerEx;
import swing_study.menu.JMenuEx;
import swing_study.menu.JPopupMenuEx;

@SuppressWarnings("serial")
public class SwingMain extends JFrame implements ActionListener {

	private JPanel contentPane; 
	private JButton btn01;
	private JButton btn02;
	private JPanel pLayout;
	private JButton btnFlowLayout;
	private JButton btnBorderLayout;
	private JButton btnGridLayout;
	private JButton btnAbsoluteLayout;
	private JButton btn03;
	private JPanel pComponent1;
	private JButton btn04;
	private JButton btn05;
	private JPanel pCheckRadio;
	private JButton btn06;
	private JButton btn07;
	private JPanel pText;
	private JButton btn08;
	private JPanel pList;
	private JButton btn09;
	private JButton btn10;
	private JButton btn11;
	private JPanel pComboBox;
	private JButton btn12;
	private JButton btn13;
	private JButton btn14;
	private JPanel pSliderSpiner;
	private JPanel pSlider;
	private JPanel pSpiner;
	private JButton btn15;
	private JButton btn16;
	private JPanel pTabbedPane;
	private JButton btn17;
	private JButton btn0402;
	private JButton btn18;
	private JPanel pEventListener;
	private JButton btn19;
	private JButton btn20;
	private JButton btn21;
	private JButton btn22;
	private JButton btn23;
	private JPanel pMenu;
	private JButton btn24;
	private JButton btn25;
	private JPanel pDlg;
	private JButton btn26;
	private JButton btn27;
	private JButton btn28;
	private JPanel pFileChooser;
	private JButton btn29;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain frame = new SwingMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingMain() {
		initialize();
	}
	private void initialize() {
		setTitle("swing study");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 686, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 5, 10, 10)); // 행 열 수평 수직
		
		btn01 = new JButton("JFrame Ex");
		btn01.addActionListener(this);
		contentPane.add(btn01);
		
		btn02 = new JButton("JPanel Ex");
		btn02.addActionListener(this);
		contentPane.add(btn02);
		
		pLayout = new JPanel();
		pLayout.setBorder(new TitledBorder(null, "Layout", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLayout);
		pLayout.setLayout(new GridLayout(0, 1, 0, 10));
		
		btnFlowLayout = new JButton("FlowLayout");
		btnFlowLayout.addActionListener(this);
		
		/*
		btnFlowLayout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameLayout flow = new FrameLayout(LayoutGubun.FLOW);
//				flow.setVisible(true); << FrameLayout initialize()에 넣어줌 필요없어줌!
			}
		});
		*/
		
		// 람다식으로 하면 아래
		/*btnFlowLayout.addActionListener(e -> new FrameLayout(LayoutGubun.FLOW));*/
		pLayout.add(btnFlowLayout);
		
		btnBorderLayout = new JButton("BorderLayout");
		btnBorderLayout.addActionListener(this);
		pLayout.add(btnBorderLayout);
		
		btnGridLayout = new JButton("GridLayout");
		btnGridLayout.addActionListener(this);
		pLayout.add(btnGridLayout);
		
		btnAbsoluteLayout = new JButton("AbsoluteLayout");
		btnAbsoluteLayout.addActionListener(this);
		pLayout.add(btnAbsoluteLayout);
		
		btn03 = new JButton("JComponent 공통속성");
		btn03.addActionListener(this);
		contentPane.add(btn03);
		
		pComponent1 = new JPanel();
		pComponent1.setBorder(new TitledBorder(null, "JLabel & JButton & JToggleButton", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pComponent1);
		pComponent1.setLayout(new GridLayout(0, 1, 0, 10));
		
		btn04 = new JButton("JLabel");
		btn04.addActionListener(this);
		pComponent1.add(btn04);
		
		btn05 = new JButton("JToggleButton");
		btn05.addActionListener(this);
		
		btn0402 = new JButton("JLabelSize");
		btn0402.addActionListener(this);
		pComponent1.add(btn0402);
		pComponent1.add(btn05);
		
		pCheckRadio = new JPanel();
		pCheckRadio.setBorder(new TitledBorder(null, "JCheckBox & JRadioButton", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pCheckRadio);
		pCheckRadio.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn06 = new JButton("JCheckBox");
		btn06.addActionListener(this);
		pCheckRadio.add(btn06);
		
		btn07 = new JButton("JRadioButton");
		btn07.addActionListener(this);
		pCheckRadio.add(btn07);
		
		pText = new JPanel();
		pText.setBorder(new TitledBorder(null, "TextField", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pText);
		
		btn08 = new JButton("TextField");
		btn08.addActionListener(this);
		pText.add(btn08);
		
		pList = new JPanel();
		pList.setBorder(new TitledBorder(null, "JList", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pList);
		pList.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn09 = new JButton("JList1");
		btn09.addActionListener(this);
		pList.add(btn09);
		
		btn10 = new JButton("JList2");
		btn10.addActionListener(this);
		pList.add(btn10);
		
		btn11 = new JButton("JList3");
		btn11.addActionListener(this);
		pList.add(btn11);
		
		pComboBox = new JPanel();
		pComboBox.setBorder(new TitledBorder(null, "JComboBox", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pComboBox);
		pComboBox.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn12 = new JButton("JComboBox1");
		btn12.addActionListener(this);
		pComboBox.add(btn12);
		
		btn13 = new JButton("JComboBox2");
		btn13.addActionListener(e->{ // 람다식으로도 구현 가능
			JComboBoxEx2 frame = new JComboBoxEx2();
			frame.setVisible(true);
		});
		pComboBox.add(btn13);
		
		btn14 = new JButton("JComboBox3");
		btn14.addMouseListener(new MouseListener() {
			
			// 어떻게 작동하는지 console에서 확인해보기!
			@Override
			public void mouseReleased(MouseEvent e) {
//				System.out.println("mouseRealeased");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
//				System.out.println("mousePressed");
				JComboBoxEx3 frame = new JComboBoxEx3();
				frame.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
//				System.out.println("mouseExited");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
//				System.out.println("mouseEntered");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println("mouseClicked");
			}
		});
		pComboBox.add(btn14);
		
		pSliderSpiner = new JPanel();
		contentPane.add(pSliderSpiner);
		pSliderSpiner.setLayout(new GridLayout(0, 1, 0, 0));
		
		pSlider = new JPanel();
		pSlider.setBorder(new TitledBorder(null, "JSlider", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSliderSpiner.add(pSlider);
		pSlider.setLayout(new BorderLayout(0, 0));
		
		btn15 = new JButton("JSlider");
		btn15.addActionListener(this);
		pSlider.add(btn15, BorderLayout.CENTER);
		
		pSpiner = new JPanel();
		pSpiner.setBorder(new TitledBorder(null, "JSpiner", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSliderSpiner.add(pSpiner);
		pSpiner.setLayout(new BorderLayout(0, 0));
		
		btn16 = new JButton("JSpiner");
		btn16.addActionListener(this);
		pSpiner.add(btn16, BorderLayout.CENTER);
		
		pTabbedPane = new JPanel();
		pTabbedPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JTabbedPane&JTable", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pTabbedPane);
		
		btn17 = new JButton("JTabbedPane");
		btn17.addActionListener(this);
		pTabbedPane.setLayout(new GridLayout(0, 1, 0, 0));
		pTabbedPane.add(btn17);
		
		btn18 = new JButton("JTable");
		/* 이렇게 하면 익명 클래스로 들어오는데, btn18에서만 쓸 수 있는 method가 됨...
		btn18.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		*/
		/*
		* 그럴바에야 this로 이 frame에서 처리하겠다 넘겨주고
		* >> implements한 ActionListener를 통해서 아래 actionPerformed()로 넘어가면 더 편하기 때문에
		* 이렇게 한 것
		*/
		
		// mouseListener처럼 여러개 overriding해야하면 그냥 adapter로 선택 가능함
		btn18.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
			}

			
		});
		btn18.addActionListener(this);
		pTabbedPane.add(btn18);
		
		// 혹은 actionListene를 new actionListner로 만들어서 this대신 넣어주면 됨
		
		pEventListener = new JPanel();
		pEventListener.setBorder(new TitledBorder(null, "EventListener", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pEventListener);
		pEventListener.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn19 = new JButton("독립클래스");
		btn19.addActionListener(this);
		pEventListener.add(btn19);
		
		btn20 = new JButton("내부클래스");
		btn20.addActionListener(this);
		pEventListener.add(btn20);
		
		btn21 = new JButton("익명클래스");
		btn21.addActionListener(this);
		pEventListener.add(btn21);
		
		btn22 = new JButton("MouseListener");
		btn22.addActionListener(this);
		pEventListener.add(btn22);
		
		btn23 = new JButton("MouseAdapter");
		btn23.addActionListener(this);
		pEventListener.add(btn23);
		
		pMenu = new JPanel();
		pMenu.setBorder(new TitledBorder(null, "JMenu&JPopupMenu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pMenu);
		pMenu.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn24 = new JButton("JMenuBar");
		btn24.addActionListener(this);
		pMenu.add(btn24);
		
		btn25 = new JButton("JPopupMenu");
		btn25.addActionListener(this);
		pMenu.add(btn25);
		
		pDlg = new JPanel();
		pDlg.setBorder(new TitledBorder(null, "JOptionPane", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pDlg);
		pDlg.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn26 = new JButton("InputDlg");
		btn26.addActionListener(this);
		pDlg.add(btn26);
		
		btn27 = new JButton("ConfirmDlg");
		btn27.addActionListener(this);
		pDlg.add(btn27);
		
		btn28 = new JButton("MessageDlg");
		btn28.addActionListener(this);
		pDlg.add(btn28);
		
		pFileChooser = new JPanel();
		contentPane.add(pFileChooser);
		
		btn29 = new JButton("JFileChooser");
		btn29.addActionListener(this);
		pFileChooser.add(btn29);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn29) {
			actionPerformedBtn29(e);
		}
		if (e.getSource() == btn28) {
			actionPerformedBtn28(e);
		}
		if (e.getSource() == btn27) {
			actionPerformedBtn27(e);
		}
		if (e.getSource() == btn26) {
			actionPerformedBtn26(e);
		}
		if (e.getSource() == btn25) {
			actionPerformedBtn25(e);
		}
		if (e.getSource() == btn24) {
			actionPerformedBtn24(e);
		}
		if (e.getSource() == btn23) {
			actionPerformedBtn23(e);
		}
		if (e.getSource() == btn22) {
			actionPerformedBtn22(e);
		}
		if (e.getSource() == btn21) {
			actionPerformedBtn21(e);
		}
		if (e.getSource() == btn20) {
			actionPerformedBtn20(e);
		}
		if (e.getSource() == btn19) {
			actionPerformedBtn19(e);
		}
		// 조건문을 통해서 어떤 부분의 event가 일어났는지 확인 후 실행
		if (e.getSource() == btn18) {
			actionPerformedBtn18(e);
		}
		if (e.getSource() == btn0402) {
			actionPerformedBtn0402(e);
		}
		if (e.getSource() == btn17) {
			actionPerformedBtn17(e);
		}
		if (e.getSource() == btn16) {
			actionPerformedBtn16(e);
		}
		if (e.getSource() == btn15) {
			actionPerformedBtn15(e);
		}
//		if (e.getSource() == btn14) {
//			actionPerformedBtn14(e);
//		}
//		if (e.getSource() == btn13) {
//			actionPerformedBtn13(e);
//		}
		if (e.getSource() == btn12) {
			actionPerformedBtn12(e);
		}
		if (e.getSource() == btn11) {
			actionPerformedBtn11(e);
		}
		if (e.getSource() == btn10) {
			actionPerformedBtn10(e);
		}
		if (e.getSource() == btn09) {
			actionPerformedBtn09(e);
		}
		if (e.getSource() == btn08) {
			actionPerformedBtn08(e);
		}
		if (e.getSource() == btn07) {
			actionPerformedBtn07(e);
		}
		if (e.getSource() == btn06) {
			actionPerformedBtn06(e);
		}
		if (e.getSource() == btn05) {
			actionPerformedBtn05(e);
		}
		if (e.getSource() == btn04) {
			actionPerformedBtn04(e);
		}
		if (e.getSource() == btn03) {
			actionPerformedBtn03(e);
		}
		if (e.getSource() == btnAbsoluteLayout) {
			actionPerformedBtnAbsoluteLayout(e);
		}
		if (e.getSource() == btnGridLayout) {
			actionPerformedBtnGridLayout(e);
		}
		if (e.getSource() == btnBorderLayout) {
			actionPerformedBtnBorderLayout(e);
		}
		if (e.getSource() == btnFlowLayout) {
			actionPerformedBtnFlowLayout(e);
		}
		if (e.getSource() == btn02) {
			actionPerformedBtn02(e);
		}
		if (e.getSource() == btn01) {
			actionPerformedBtn01(e);
		}
	}

	protected void actionPerformedBtn01(ActionEvent e) {
		contentPaneEx frame = new contentPaneEx();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn02(ActionEvent e) {
		JPanelEx frame = new JPanelEx();
		frame.setVisible(true);
	}

	protected void actionPerformedBtnFlowLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGubun.FLOW);
		frame.setVisible(true);
	}

	protected void actionPerformedBtnBorderLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGubun.BORDER);
		frame.setVisible(true);
	}

	protected void actionPerformedBtnGridLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGubun.GRID);
		frame.setVisible(true);

	}

	protected void actionPerformedBtnAbsoluteLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGubun.ABSOLUTE);
		frame.setVisible(true);
	}
	protected void actionPerformedBtn03(ActionEvent e) {
		FrameComponentEx frame = new FrameComponentEx();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn04(ActionEvent e) {
		JLabelEx frame = new JLabelEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn05(ActionEvent e) {
		JButtonEx frame = new JButtonEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn06(ActionEvent e) {
		JCheckBoxEx frame = new JCheckBoxEx();
		frame.setVisible(true);
		
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		list.add(new Fruit("사과", 100));
		list.add(new Fruit("배", 500));
		list.add(new Fruit("체리", 2000));
		list.add(new Fruit("바나나", 1000));
		list.add(new Fruit("포도", 800));
		list.add(new Fruit("토마토", 1500));
		
		JCheckBoxCustomEx frame1 = new JCheckBoxCustomEx(list);
		frame1.setVisible(true);
	}
	protected void actionPerformedBtn07(ActionEvent e) {
		JRadioButtonEx frame = new JRadioButtonEx();
		frame.setVisible(true);
		
	}
	protected void actionPerformedBtn08(ActionEvent e) {
		JTextFieldAreaEx frame = new JTextFieldAreaEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn09(ActionEvent e) {
		JListEx frame = new JListEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn10(ActionEvent e) {
		JListEx2 frame = new JListEx2();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn11(ActionEvent e) {
		JListEx3 frame = new JListEx3();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn12(ActionEvent e) {
		JComboBoxEx1 frame = new JComboBoxEx1();
		frame.setVisible(true);
	}
//	protected void actionPerformedBtn13(ActionEvent e) {
//		JComboBoxEx2 frame = new JComboBoxEx2();
//		frame.setVisible(true);
//	}
//	protected void actionPerformedBtn14(ActionEvent e) {
//		JComboBoxEx3 frame = new JComboBoxEx3();
//		frame.setVisible(true);
//	}
	protected void actionPerformedBtn15(ActionEvent e) {
		JSliderEx frame = new JSliderEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn16(ActionEvent e) {
		JSpinnerEx frame = new JSpinnerEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn17(ActionEvent e) {
		JTabbedPaneEx frame = new JTabbedPaneEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn0402(ActionEvent e) {
		JLabelEx1 frame = new JLabelEx1();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn18(ActionEvent e) {
//		System.out.println(e.getActionCommand()); // actionPerformedEven안의 method 사용 가능
		JTableEx frame = new JTableEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn19(ActionEvent e) {
		IndepClassListener frame = new IndepClassListener();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn20(ActionEvent e) {
		InnerClassListener frame = new InnerClassListener();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn21(ActionEvent e) {
		AnonymousClassListener frame = new AnonymousClassListener();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn22(ActionEvent e) {
		MouseListenerEx frame = new MouseListenerEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn23(ActionEvent e) {
		MouseAdapterEx frame = new MouseAdapterEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn24(ActionEvent e) {
		JMenuEx frame = new JMenuEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn25(ActionEvent e) {
		JPopupMenuEx frame = new JPopupMenuEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn26(ActionEvent e) {
		JOptionPaneInputEx frame = new JOptionPaneInputEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn27(ActionEvent e) {
		JOptionPaneConfirmEx frame = new JOptionPaneConfirmEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn28(ActionEvent e) {
		JOptionPaneMessageEx frame = new JOptionPaneMessageEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn29(ActionEvent e) {
		JFileChooserEx frame = new JFileChooserEx();
		frame.setVisible(true);
	}
}
