package mainstudy;

import memo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiaryScreen extends JFrame{
	
	private JPanel mainPanel = new JPanel();						//바탕 패널
	private JPanel topPanel = new JPanel();							//제목 패널
		private JLabel topLabel = new JLabel("메인화면");				//제목 요소
	private JPanel otherPanel = new JPanel();						//메모,스탑워치 패널
		private JButton memoButton = new JButton("메모");				//메모 버튼
		private JButton watchButton = new JButton("스탑워치");			//스탑워치 버튼
			
	public DiaryScreen()
	{	
		//바탕 패널 설정
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		setContentPane(mainPanel);
		
		//제목 요소
		topPanel.add(topLabel);
		
		//메모,스탑워치 버튼
		otherPanel.add(memoButton);
		memoButton.setSize(10, 20);
		otherPanel.add(watchButton);
		watchButton.setSize(10, 20);


		//바탕 패널에 추가하기
		mainPanel.add(topPanel);
		mainPanel.add(otherPanel);
		
		//각 패널 사이즈 설정
		topPanel.setPreferredSize(new Dimension(500, 200));
		
		//바탕 패널, 전체 화면 관련 설정
		setResizable(false);
		setVisible(true);
		setSize(600,600);
		setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		memoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JavaMemo();
			}
		});
		
		watchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StopWatchEx();			}
        });
		
	}
}