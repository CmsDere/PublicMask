package com.publicmask.view;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public MainFrame() {
		this.setSize(1280, 720);
		this.setTitle("공적마스크 예약 시스템");
		
		// this.add(약국목록 패널);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
