package swing_study.dlg;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class JFileChooserEx extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnOpen;
	private JLabel lblImg;
	private JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
	FileInputStream fis;

	public JFileChooserEx() {
		initialize();
	}

	private void initialize() {
		setTitle("JFileChooser Ex");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 388);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		lblImg = new JLabel("");
		contentPane.add(lblImg, BorderLayout.CENTER);

		btnOpen = new JButton("이미지 불러오기");
		btnOpen.addActionListener(this);
		contentPane.add(btnOpen, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnOpen) {
				if (e.getActionCommand().equals("이미지 불러오기")) {

					actionPerformedBtnOpen(e);

				} else {
					actionPerformedBtnSave(e);
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	private void actionPerformedBtnSave(ActionEvent e) {
		// download 폴더에 lbl에 뜬 사진을 저장되도록 만들기
		// 해당 폴더가 없다면 새성 후 저장되게 만들기
		int res = chooser.showSaveDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "WARNING", JOptionPane.WARNING_MESSAGE);
			return;
		} else {

			String chooseFilePath = chooser.getSelectedFile().getPath();

			int data;

			try (FileOutputStream fos = new FileOutputStream(chooseFilePath)) {
				while ((data = fis.read()) != -1) {
					fos.write(data);
				}

			} catch (FileNotFoundException e3) {
				e3.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();

			}
		}
	}

	protected void actionPerformedBtnOpen(ActionEvent e) throws FileNotFoundException {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG images", "jpg", "png", "gif");
		chooser.setFileFilter(filter);
		int res = chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "WARNING", JOptionPane.WARNING_MESSAGE);
			return;
		} // 여기 넘어오면 approve option 선택했다는 뜻

		String chooseFilePath = chooser.getSelectedFile().getPath();
		lblImg.setIcon(new ImageIcon(chooseFilePath));

		if (btnOpen.getText().equals("이미지 불러오기")) {
			btnOpen.setText("이미지 저장하기");
		}

		fis = new FileInputStream(chooseFilePath);

	}
}
