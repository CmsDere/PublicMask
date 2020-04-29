package com.publicmask.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PublicMask extends JPanel{
	public PublicMask() {
		this.setLayout(new BorderLayout());
		
		//공적마스크 예약시스템   North 
		JPanel toppanel = new JPanel();
		JLabel label = new JLabel("공적마스크 예약시스템");
		label.setFont(new Font("serif" , Font.BOLD, 11));//글씨체
		label.setFont(label.getFont().deriveFont(80.0f));//글씨크기
		toppanel.setBackground(Color.WHITE);
		toppanel.add(label);
		
		//약국 목록  Center 
		JPanel ctpanel = new JPanel();
		JLabel ctlabel = new JLabel("약국 목록 →  ");
		ctlabel.setFont(new Font("serif" , Font.BOLD, 55 ));//글씨체
//		ctlabel.setFont(ctlabel.getFont().deriveFont(55.0f));//글씨크기60.0f
		ctlabel.setForeground(Color.BLUE);//글씨색깔
		ctpanel.setBackground(Color.WHITE);//배경색
		ctpanel.add(ctlabel);
		
		//리스트 Center
		String[] pharmacy = {"    빨강 약국","    주황 약국","    노랑 약국","    초록 약국","    파랑 약국","    남색 약국","    보라 약국"};
		JList list = new JList(pharmacy);
		list.setFont(list.getFont().deriveFont(27.0f));//메뉴안글씨크기29.0f
		list.setBorder(BorderFactory.createLineBorder(Color.black,2));//테두리
		list.setPreferredSize(new Dimension(100,260));// 가로세로 사이즈100,280
		list.setBackground(Color.CYAN);
		ctpanel.add(list);
		
		//스크롤 Center
		JScrollPane scroller = new JScrollPane(list);
		scroller.setPreferredSize(new Dimension(210,120));//스크롤 사이즈210,80
		ctpanel.add(scroller);
		
		//선택한 약국: 라벨 South
		JLabel ctlabel1 = new JLabel("선택한 약국:                        ");
		JTextField selected = new JTextField(10);
		selected.setEditable(false);
		ctlabel1.setFont(new Font("serif" , Font.BOLD, 28 ));
				
		//선택완료 버튼 South
		JPanel stpanel = new JPanel();
		JButton stbutton = new JButton("선택 완료");
		stbutton.setPreferredSize(new Dimension(200,50));
		stbutton.setFont(stbutton.getFont().deriveFont(30.0f));
		stpanel.setBackground(Color.WHITE);
		stpanel.add(ctlabel1);
		stpanel.add(stbutton);
			
		this.add(toppanel,"North");
		this.add(ctpanel ,"Center");
		this.add(stpanel,"South");
	}
}
