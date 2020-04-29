package com.publicmask.view;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class NoSell1 extends JPanel{
	
	

	public NoSell1() {


		Font f1 = new Font("궁서",Font.BOLD,30);

		this.setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		
		panel1.setBackground(Color.blue);
		panel1.setLayout(new BorderLayout());
		panel1.setBorder(new LineBorder(Color.white, 50));
		

		JLabel label1 = new JLabel("예약 불가능!!");
		label1.setForeground(Color.white);
		label1.setFont(f1);
		JLabel label2 = new JLabel("마스크 예약 내역이 존재합니다.");
		label2.setForeground(Color.white);
		label2.setFont(f1);
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		panel1.add(label1,"North");
		panel1.add(label2,"Center");
		
		
		
		JButton button = new JButton("확인");
		
		panel2.add(button);
		panel2.setBackground(Color.white);
		
		
		this.add(panel1,"Center");
		this.add(panel2,"South");
	
	}

}
