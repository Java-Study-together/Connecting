package memo;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm;

	// �����ư�� ���õǾ� ������ ���ȴ��� Ȯ���ϱ� ���� Flag����
	private boolean openFlag;

	// ���� �����ִ� �ؽ�Ʈ ����
	private File file;
	// ���� �����ִ� �ؽ�Ʈ ������ �ʱ� �޸��� ����
	private String memo;

	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
	}// JavaMemoEvt

	@Override
	public void actionPerformed(ActionEvent ae) {

		// ����

		// �� �� �޴��� ���õǸ� �޸��� ���� �ʱ�ȭ
		if (ae.getSource() == jm.getJmiNew()) {
			// ������ �������� ���� �޸����� ������ ������ ������ ���� ���
			if (!openFlag && !jm.getJtaMemo().getText().isEmpty()) {
				int option = askNewFileSave();
				switch (option) {
				case JOptionPane.OK_OPTION:
					// ���̸����� ���� ����
					newSave();
					// �޸��� �ʱ�ȭ �� tItle ����
					resetTitle_resetText();
					break;
				case JOptionPane.NO_OPTION:
					// �޸����� ������ �ʱ�ȭ
					resetTitle_resetText();
					break;
				}// end switch
					// ������ �������� ���� �� ������ ���� ���
			} else if (openFlag) {
				// ������ ���������� �ʱ���¿� ��������?
				if (memo.equals(jm.getJtaMemo().getText())) { // ������ ������ ���� �������� ��
					// ������ �� �޸��� �ʱ�ȭ
					resetTitle_resetText();
					openFlag = !openFlag;
					// ������ ���������� �ʱ���¿� �������� �������.
				} else {
					int option = askOverwrite();
					switch (option) {
					case JOptionPane.OK_OPTION:
						save(this.file);
						resetTitle_resetText();
						//������ �ʱ���·� ���������� openFlag ������
						openFlag = !openFlag;
						break;
					case JOptionPane.NO_OPTION:
						// �޸����� ������ �ʱ�ȭ
						resetTitle_resetText();
						//������ �ʱ���·� ���������� openFlag ������
						openFlag = !openFlag;
					}// end switch
				} // end else
			} // end if
		} // end if

		//

		// ����

		// ���⸦ ������ File Loadâ ����
		if (ae.getSource() == jm.getJmiOpen()) {

			// ������ �������� ������
			if (!openFlag && jm.getJtaMemo().getText().isEmpty()) {
				openFile();
				// ������ �������� ���� �޸����� ������ �ִ� ���¿��� ���Ⱑ ���� ���
			} else if (!openFlag && !jm.getJtaMemo().getText().isEmpty()) {
				int option = askNewFileSave();
				switch (option) {
				case JOptionPane.OK_OPTION:
					// �� �̸����� ����
					newSave();
					// ���� �� �ʱ�ȭ
					resetText();
					// ���� ����
					openFile();
					break;
				case JOptionPane.NO_OPTION:
					// �ʱ�ȭ
					resetText();
					// ���� ����
					openFile();
				}// end switch
					// �����ư�� ����Ͽ� ������ ������ �ִ� ���
			} else if (openFlag) {
				// ������ ���������� �ʱ���¿� ��������?
				if (memo.equals(jm.getJtaMemo().getText())) { // ������ ������ ���� �ʱ���¿� ��
					// ������ �� ���� ��� ����
					openFile();
					// ������ ���������� �ʱ���¿� �������� �������.
				} else if(!memo.equals(jm.getJtaMemo().getText())) {
					int option = askOverwrite();
					switch (option) {
					case JOptionPane.OK_OPTION:
						save(this.file);
						resetText();
						openFile();
						break;
					case JOptionPane.NO_OPTION:
						resetText();
						openFile();
						break;
					}// end switch
				} else if (jm.getJtaMemo().getText().isEmpty()) {
					openFile();
				}
			} // end if
		} // end if

		//

		// ����

		// ������ ������ File Saveâ ����
		if (ae.getSource() == jm.getJmiSave()) {
			// ������ �������� ������ ������ ���� ���
			if (!openFlag && (((jm.getJtaMemo().getText().isEmpty())) || (!jm.getJtaMemo().getText().isEmpty()))) {
				newSave();
			} else if (openFlag) {
				save(this.file);
				//���� �� ���� ���¿� �޸��峻���� ����
				memo = jm.getJtaMemo().getText();
			} // end if
		} // end if

		//

		// ���̸����� ����

		// ���̸����� ������ File Saveâ ����
		if (ae.getSource() == jm.getJmiNewSave()) {
			newSave();
		} // end if
		
		//

		//�ݱ�
		
		// �ݱ⸦ ������ �޸��� ����
		if (ae.getSource() == jm.getJmiClose()) {
			//������ �������� ������ ������ �ִ� ���¿��� �ݱⰡ �������
			if (!openFlag && !jm.getJtaMemo().getText().isEmpty()) {
				int option = askNewFileSave();
				switch (option) {
				case JOptionPane.OK_OPTION:
					newSave();
					jm.dispose();
					break;
				case JOptionPane.NO_OPTION:
					jm.dispose();
				}// end switch
			} else if (openFlag) {
				if (memo.equals(jm.getJtaMemo().getText())) {
					jm.dispose();
				} else if (!memo.equals(jm.getJtaMemo().getText())) {
					int option = askOverwrite();
					switch (option) {
					case JOptionPane.OK_OPTION:
						save(this.file);
						jm.dispose();
					case JOptionPane.NO_OPTION:
						jm.dispose();
					}// end switch
				} // end else
			} else {
				jm.dispose();
			}
		} // end if

		//
		
		// �۲��� ������ MemoFont Dialog����
		if (ae.getSource() == jm.getJmiFont()) {
			openFont(jm);
		} // end if

		// �޸��������� ������ MemoHelp Dialog����
		if (ae.getSource() == jm.getJmiHelp()) {
			openHelp(jm);
		} // end if

	}// actionPerformed

	// �۲� dialog����
	public void openFont(JavaMemo jm) {
		new JavaMemoFont(jm);
	}// openFont

	// ���� dialog����
	public void openHelp(JavaMemo jm) {
		new MemoHelp(jm);
	}// openFont

	@Override
	public void windowClosing(WindowEvent we) {
		jm.dispose();
	}// windowClosing

	/**
	 * �޸����� reset�ϴ� method Title �� �޸��� ���� reset
	 */
	public void resetTitle_resetText() {
		resetText();
		jm.setTitle("�������.txt");
	}

	/**
	 * �޸����� reset�ϴ� method �޸����� ����
	 */
	public void resetText() {
		jm.getJtaMemo().setText("");
	}// resetText

	public void openFile() {
		FileDialog fd = new FileDialog(jm, "����", FileDialog.LOAD);
		fd.setVisible(true);
		// ������ ���� �Ǿ��� �ÿ��� ���ȴ�.
		if (fd.getFile() != null) {
			try {
				file = new File(fd.getDirectory() + fd.getFile());
				// ��Ʈ������
				BufferedReader bfr = new BufferedReader(new java.io.InputStreamReader(new FileInputStream(file)));

				String msg = "";
				// txt���Ͽ� ���� �ٴ����� �о�� �޸��忡 ���
				while ((msg = bfr.readLine()) != null) {
					jm.getJtaMemo().append(msg + "\n");
				} // end while
					// ��Ʈ������
				bfr.close();

				// ���� ��ư ����� �ʱ� �޸��� ����
				memo = jm.getJtaMemo().getText();

				jm.setTitle("�ڹ�-�޸���[" + fd.getFile() + "]");

				// openflag�� ����( ���� ��� �������)

				// ���Ⱑ ������ �� ���Ⱑ ������ ��� ù ���� ��ư�� ������ ���� flag ����
				if (openFlag == false) {
					openFlag = !openFlag;
				}

			} catch (IOException ie) { // file�� ���õǾ��� �ÿ��� try���������� FileNotFoundException ����
				ie.printStackTrace();
			} // end catch
		} // end if
	}// openFile

	public void newSave() {
		FileDialog fd = new FileDialog(jm, "����", FileDialog.SAVE);
		fd.setVisible(true);
		if (fd.getFile() != null) {
//			 ���̸����� ������ ���� ����
			File newfile = new File(fd.getDirectory() + fd.getFile());
			this.file = newfile;
			save(newfile);
			jm.setTitle("�ڹ�-�޸���[���� : " + fd.getFile() + "]");
		} // newSave
	}// newSave
	
	public void save(File file) {
		try {
			// ��Ʈ������
			BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			
			// ��Ʈ���� ����ϱ�
			//JtextArea�� �ٹٲ��� "\n"�� ������ windows���� �����ϴ� �޸����� "\r\n"���� �ϱ⿡ �ٲ��ش�.
			String msg = jm.getJtaMemo().getText().replaceAll("\n", "\r\n");
			
			bfw.write(msg);
			
			// ��Ʈ������ ���Ϸ�
			bfw.flush();
			
			// ��Ʈ�� ����
			bfw.close();
			
		} catch (IOException ie) {
			ie.printStackTrace();
		} // end catch
	} // save

	
	public int askNewFileSave() {
		int option = JOptionPane.showConfirmDialog(jm, "���� �޸����� ������ �� ���Ͽ� �����Ͻðڽ��ϱ�?");
		return option;
	}// askNewFileSave
	

	
	public int askOverwrite() {
		int option = JOptionPane.showConfirmDialog(jm,
				"���� �޸����� ������ " + this.file.getAbsolutePath()+ " ��ġ�� �����Ͻðڽ��ϱ�?");
		return option;
	}//

}// JavaMemoEvt
