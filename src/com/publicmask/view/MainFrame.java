package com.publicmask.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private JPanel mainPanel;
	
	public MainFrame() {
		this.setTitle("공적 마스크 예약 시스템");
		
		this.add(new ReservationResult());
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
