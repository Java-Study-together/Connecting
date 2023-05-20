package mainstudy;

import memo.*;
import javax.swing.*;

import DiaryScreen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame{
	
	private JPanel mainPanel = new JPanel();						//바탕 패널
	private JPanel topPanel = new JPanel();							//제목 패널
		private JLabel topLabel = new JLabel("메인화면");				//제목 요소
	private JPanel studyPanel = new JPanel();						//메인 패널
		private JButton matchButton = new JButton("스터디원 찾기");		//버튼 요소
		private JButton diaryButton = new JButton("스터디 일기");		
	
			
	public MainScreen()
	{	
		//바탕 패널 설정
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		setContentPane(mainPanel);
		
		//제목 요소
		topPanel.add(topLabel);
		
		//버튼요소
		studyPanel.add(matchButton);
		matchButton.setSize(10,20);
		studyPanel.add(diaryButton);
		diaryButton.setSize(10,20);
		
		
		//바탕 패널에 추가하기
		mainPanel.add(topPanel);
		mainPanel.add(studyPanel);
		
		//각 패널 사이즈 설정
		topPanel.setPreferredSize(new Dimension(500, 200));
		studyPanel.setPreferredSize(new Dimension(500, 300));
		
		//바탕 패널, 전체 화면 관련 설정
		setResizable(false);
		setVisible(true);
		setSize(600,600);
		setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//스터디 매칭으로 연결
		matchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
        });
		//스터디 일기로 연결
		diaryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DiaryScreen();
				setVisible(false);
			}
        });
		
	}
	public static void main(String[] args) {
		new MainScreen();
	}
}