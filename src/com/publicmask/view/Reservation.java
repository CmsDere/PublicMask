package com.publicmask.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.publicmask.model.Drugstoreinfo;

public class Reservation extends JPanel{
	public Reservation() {
		Font f1 = new Font("궁서",Font.BOLD,50);
		Font f2 = new Font("굴림",Font.BOLD,25);
		
		this.setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		JLabel label1 = new JLabel("노랑약국의 예약진행");
		label1.setFont(f1);
		label1.setForeground(Color.white);
		label1.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(label1);
		panel1.setBackground(Color.BLUE);		
		
		panel2.setLayout(new GridLayout(3,3));
		JLabel label2 = new JLabel(" KF94          ");
		label2.setFont(f2);
		JLabel label3 = new JLabel(" 1500원          ");
		label3.setFont(f2);
		JTextField text1 = new JTextField("0",3);
		JLabel label4 = new JLabel(" KF80          ");
		label4.setFont(f2);
		JLabel label5 = new JLabel(" 1000원          ");
		label5.setFont(f2);
		JTextField text2 = new JTextField("0",3);
		JLabel label6 = new JLabel(" 일반마스크            ");
		label6.setFont(f2);
		JLabel label7 = new JLabel("  500원 		");
		label7.setFont(f2);
		JTextField text3 = new JTextField("0",3);
		
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(text1);
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(text2);
		panel2.add(label6);
		panel2.add(label7);
		panel2.add(text3);
		
		panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton button = new JButton("확인");
		panel3.add(button);

		this.add(panel1,"North");
		this.add(panel2,"Center");
		this.add(panel3,"South");
	}
}
