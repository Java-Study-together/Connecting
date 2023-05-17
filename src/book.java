import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class book extends JFrame{
	private JPanel mainPanel = new JPanel();						//바탕 패널
	private JPanel topPanel = new JPanel();							//제목 패널
		private JLabel topLabel = new JLabel("책장");			//제목 요소
	private JPanel loginPanel = new JPanel();						//로그인 패널
		private JLabel idLabel = new JLabel("진행률");					//로그인 요소 - 아이디 라벨
		private JTextField idText = new JTextField();				//로그인 요소 - 아이디 치는 곳
		private JLabel pwLabel = new JLabel("메모");			//로그인 요소 - 패스워드 라벨
		private JButton pwText = new JButton("찾기");	
		private JButton stw = new JButton("스톱워치");	
	private JPanel buttonPanel = new JPanel();						//버튼 패널
		private JButton lgnButton = new JButton("저장");
		
		
		//버튼 요소 - 로그인 버튼
			//버튼 요소 - 회원가입 버튼
	
public book (){
	//바탕 패널 설정
			mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			setContentPane(mainPanel);
			
			//제목 요소
			topPanel.add(topLabel);
			
			//로그인 - 각 요소 사이즈/위치 설정
			idLabel.setSize(100, 30);
			pwLabel.setSize(100, 30);
			idLabel.setLocation(150,  0);
			pwLabel.setLocation(150, 40);
			idText.setSize(20, 30);
			pwText.setSize(60, 30);
			idText.setLocation(300, 0);
			pwText.setLocation(300, 40);
			stw.setSize(90, 30);
			stw.setLocation(300, 80);
			
			//rgstButton.setBounds(300,300,20,20);
			//로그인 요소 삽입
			loginPanel.setLayout(null);
			//loginPanel.add(idLabel);
			//loginPanel.add(idText);
			loginPanel.add(pwLabel);
			loginPanel.add(pwText);
			loginPanel.add(stw);
			
			//loginPanel.add(rgstButton);
			
			
			//로그인 버튼 요소
			buttonPanel.add(lgnButton);
			lgnButton.setSize(10, 20);
			//buttonPanel.add(rgstButton);
			//rgstButton.setSize(10, 20);
			//창 넘기기
			pwText.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
	                new JavaMemo();
	                setVisible(true); }
			});
			
			stw.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
	                new StopWatchEx();
	                setVisible(true); }
			});
			//바탕 패널에 추가하기
			mainPanel.add(topPanel);
			mainPanel.add(loginPanel);
			mainPanel.add(buttonPanel);
			//topPanel.add(rgstButton);
			//각 패널 사이즈 설정
			topPanel.setPreferredSize(new Dimension(500, 200));
			loginPanel.setPreferredSize(new Dimension(500, 300));
			buttonPanel.setPreferredSize(new Dimension(500, 100));
			

			
			//바탕 패널, 전체 화면 관련 설정
			setResizable(false);
			setVisible(true);
			setSize(600,600);
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
	new book();
	}
}