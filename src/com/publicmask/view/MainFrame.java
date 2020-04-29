package com.publicmask.view;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		this.setTitle("공적 마스크 예약 시스템");
		
		this.add(new RefuseNotice());
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
