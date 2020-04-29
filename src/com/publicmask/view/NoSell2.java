package com.publicmask.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;

public class NoSell2 {
	
	

	public static void main(String[] args) {


		Font f1 = new Font("궁서",Font.BOLD,30);
		Font f2 = new Font("굴림",Font.BOLD,25);
		
		JFrame mf = new JFrame("예약 불가능");
		
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();   //중간 출력
		
		
		panel1.setBackground(Color.blue);
		panel1.setLayout(new BorderLayout());
		
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel3.setLayout(new GridLayout(9,1));
		
		JLabel label1 = new JLabel("예약이 불가능 합니다.!");
		label1.setForeground(Color.white);
		label1.setFont(f1);
		JLabel label2 = new JLabel("아래 공지를 확인해주세요.");
		label2.setForeground(Color.white);
		label2.setFont(f1);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		panel1.add(label1,"North");
		panel1.add(label2,"Center");
		panel1.setBorder(new LineBorder(Color.white, 30));
		
		JLabel label10 = new JLabel("              ");
		JLabel label3 = new JLabel("* 출생 년도 끝자리 *");
		label3.setFont(f2);
		JLabel label11 = new JLabel("              ");
		JLabel label4 = new JLabel("월요일 - 1, 6");
		JLabel label5 = new JLabel("화요일 - 2, 7");
		JLabel label6 = new JLabel("수요일 - 3, 8");
		JLabel label7 = new JLabel("목요일 - 4, 9");
		JLabel label8 = new JLabel("금요일 - 5, 0");
		JLabel label9 = new JLabel("토요일, 일요일은 누구든 구매 가능합니다.");
		
		label3.setHorizontalAlignment(JLabel.CENTER);
		label4.setHorizontalAlignment(JLabel.CENTER);
		label5.setHorizontalAlignment(JLabel.CENTER);
		label6.setHorizontalAlignment(JLabel.CENTER);
		label7.setHorizontalAlignment(JLabel.CENTER);
		label8.setHorizontalAlignment(JLabel.CENTER);
		label9.setHorizontalAlignment(JLabel.CENTER);
		
		panel3.add(label10);
		panel3.add(label3);
		panel3.add(label11);
		panel3.add(label4);
		panel3.add(label5);
		panel3.add(label6);
		panel3.add(label7);
		panel3.add(label8);
		panel3.add(label9);
		
		
		
		JButton button = new JButton("확인");
		
		panel2.add(button);
		
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
		
		
		mf.add(panel1,"North");
		mf.add(panel3,"Center");
		mf.add(panel2,"South");
		mf.pack();
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
