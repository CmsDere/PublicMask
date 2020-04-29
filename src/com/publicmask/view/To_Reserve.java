package com.publicmask.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class To_Reserve extends JPanel{
	public To_Reserve() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(82, 204, 250));
		panel1.setSize(1280,150);		
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setLayout(new GridLayout(2,2));
		panel2.setSize(1280,420);		
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		panel3.setSize(1280,150);		
		
		JTextField id = new JTextField(30);
		JPasswordField ps = new JPasswordField(30);
		JButton btn = new JButton("예약하기");
		
		JLabel lb1 = new JLabel("봄꽃약국 예약시스템에 접속하셨습니다. ");
		lb1.setLocation(290,10);
		lb1.setSize(700,150);
		lb1.setForeground(Color.WHITE);
		lb1.setFont(lb1.getFont().deriveFont(30.0f));	
		
		panel1.add(lb1);
		panel2.add(new JLabel("이름"));
		panel2.add(id);
		panel2.add(new JLabel("주민번호"));
		panel2.add(ps);
		panel3.add(btn);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.add(panel3, BorderLayout.SOUTH);
	}
}
