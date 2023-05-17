

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class JavaMemoFont extends JDialog{
	
	
	//�̺�Ʈ�� ���õ� component�� ����
	private JTextField jtfFont;
	private JTextField jtfStyle;
	private JTextField jtfSize;
	
	private JLabel jiblPreview;
	
	private DefaultComboBoxModel<String> djcbScript;
	private JComboBox<String> jcbScript;
	
	private DefaultListModel<String> dlmFont;
	private DefaultListModel<String> dlmStyle;
	private DefaultListModel<Integer> dlmSize;
	
	private JList<String> jlFont;
	private JList<String> jlStyle;
	private JList<Integer> jlSize;
	
	private JButton jbtnApply;
	private JButton jbtnClose;
	
	private String previewFont;
	private int previewStyle;
	private int previewSize;
	
	public JavaMemoFont(JavaMemo jm) {

		//������ �ۼ�.
		super(jm, "�۲�", false);

		//component����
		
		
		JLabel jlblFont = new JLabel("�۲�");
		JLabel jlblStyle = new JLabel("��Ÿ��");
		JLabel jlblSize = new JLabel("ũ��");
		
		//�ʱ� �޸����� ���İ��� �޾��ֱ� ���� ������ �� argument�� �־� ����
		jtfFont = new JTextField(jm.getFt().getFontName());
		jtfStyle = new JTextField(JavaMemo.STYLENAME[jm.getFt().getStyle()]);
		jtfSize = new JTextField(String.valueOf(jm.getFt().getSize()));
		
		//�̸�����â �⺻ ������ �޸����� �⺻���İ� ����
		previewFont = JavaMemo.FONT[0];
		previewStyle = JavaMemo.STYLE[0];
		previewSize = JavaMemo.SIZE[0];
		
		jiblPreview = new JLabel("AaBbCc");
		Font ftPreview = new Font(previewFont, previewStyle, previewSize);
		jiblPreview.setFont(ftPreview);
		TitledBorder tbPriview = new TitledBorder("��ũ��Ʈ");
		jiblPreview.setBorder(tbPriview);
		
		djcbScript = new DefaultComboBoxModel<String>();
		djcbScript.addElement("����");
		djcbScript.addElement("�ѱ�");
		
		jcbScript = new JComboBox<String>(djcbScript);
		
		dlmFont = new DefaultListModel<String>();
		for(int i = 0; i < JavaMemo.FONT.length; i++) {
			dlmFont.addElement(JavaMemo.FONT[i]);
		}//end for
		jlFont = new JList<String>(dlmFont);
		
		dlmStyle = new DefaultListModel<String>();
		for(int i = 0; i < JavaMemo.STYLENAME.length; i++) {
			dlmStyle.addElement(JavaMemo.STYLENAME[i]);
		}//end for
		jlStyle = new JList<String>(dlmStyle);
		
		dlmSize = new DefaultListModel<Integer>();
		for(int i = 0; i < JavaMemo.SIZE.length; i++) {
			dlmSize.addElement(JavaMemo.SIZE[i]);
		}//end for
		jlSize = new JList<Integer>(dlmSize);
		JScrollPane jspSize = new JScrollPane(jlSize);
		
		jbtnApply = new JButton("����");
		jbtnClose = new JButton("�ݱ�");
		
		
		//�̺�Ʈ ����ϱ�
		JavaMemoFontEvt jmfe = new JavaMemoFontEvt(jm,this);
		jlFont.addListSelectionListener(jmfe);
		jlStyle.addListSelectionListener(jmfe);
		jlSize.addListSelectionListener(jmfe);

		jcbScript.addActionListener(jmfe);
		
		jbtnApply.addActionListener(jmfe);
		jbtnClose.addActionListener(jmfe);
		
		
		//��ġ������
		setLayout(null);
		setResizable(false);
		
		//component ��ġ
		
		jlblFont.setBounds(50, 20, 80, 30);
		jtfFont.setBounds(50, 50, 80, 30);
		jlFont.setBounds(50, 100, 80, 150);
		
		add(jlblFont);
		add(jtfFont);
		add(jlFont);
		
		jlblStyle.setBounds(180, 20, 80, 30);
		jtfStyle.setBounds(180, 50, 80, 30);
		jlStyle.setBounds(180, 100, 80, 150);
		
		add(jlblStyle);
		add(jtfStyle);
		add(jlStyle);
		
		jlblSize.setBounds(310, 20, 80, 30);
		jtfSize.setBounds(310, 50, 80, 30);
		jspSize.setBounds(310, 100, 80, 150);
		
		add(jlblSize);
		add(jtfSize);
		add(jspSize);
		
		jiblPreview.setBounds(280, 270, 100, 50);
		add(jiblPreview);
		
		jcbScript.setBounds(310, 330, 80, 30);
		add(jcbScript);
		
		jbtnApply.setBounds(220, 370, 80, 30);
		add(jbtnApply);
		
		jbtnClose.setBounds(310, 370, 80, 30);
		add(jbtnClose);
		
		
		//window������
		setBounds(jm.getX()+50, jm.getY(), 460, 470);
		
		//����ڿ��� �����ֱ�
		setVisible(true);
		
	 }//JavaMemoFont


	public JTextField getJtfFont() {
		return jtfFont;
	}


	public JTextField getJtfStyle() {
		return jtfStyle;
	}


	public JTextField getJtfSize() {
		return jtfSize;
	}


	public JLabel getJiblPreview() {
		return jiblPreview;
	}


	public DefaultComboBoxModel<String> getDjcbScript() {
		return djcbScript;
	}


	public JComboBox<String> getJcbScript() {
		return jcbScript;
	}


	public DefaultListModel<String> getDlmFont() {
		return dlmFont;
	}


	public DefaultListModel<String> getDlmStyle() {
		return dlmStyle;
	}


	public DefaultListModel<Integer> getDlmSize() {
		return dlmSize;
	}


	public JList<String> getJlFont() {
		return jlFont;
	}


	public JList<String> getJlStyle() {
		return jlStyle;
	}


	public JList<Integer> getJlSize() {
		return jlSize;
	}


	public JButton getJbtnApply() {
		return jbtnApply;
	}


	public JButton getJbtnClose() {
		return jbtnClose;
	}


	public String getPreviewFont() {
		return previewFont;
	}


	public int getPreviewStyle() {
		return previewStyle;
	}


	public int getPreviewSize() {
		return previewSize;
	}
	
	
	

}//JavaMemoFont
