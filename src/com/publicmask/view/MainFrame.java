package com.publicmask.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	public JPanel panel;
	
	public MainFrame() {
		this.setTitle("공적 마스크 예약 시스템");
		
		panel = this.ReservationPanel();
		this.add(panel);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public JPanel ReservationPanel() {
		return new Reservation();
	}
	
	public JPanel ReservationResultPanel() {
		return new ReservationResult();
	}
	
	public JPanel PublicMaskPanel() {
		return new PublicMask();
	}
	
	public void replace(JPanel panel) {
		
	}
	
}
