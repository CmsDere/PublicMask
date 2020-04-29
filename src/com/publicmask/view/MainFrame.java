package com.publicmask.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	public JPanel mainPanel;
	
	public MainFrame() {
		this.setTitle("공적 마스크 예약 시스템");
		
		mainPanel = this.callReservationPanel();
		this.add(mainPanel);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public JPanel callReservationPanel() {
		return new Reservation();
	}
	
	public JPanel callReservationResultPanel() {
		return new ReservationResult();
	}
	
	public JPanel callPublicMaskPanel() {
		return new PublicMask();
	}
	
	public void ReservationToReservationResult() {
		this.remove(mainPanel);
		this.mainPanel = callReservationResultPanel();
		this.add(mainPanel);
		this.repaint();
	}
	
	public void ReservationResultToPublicMask() {
		this.remove(mainPanel);
		this.mainPanel = callPublicMaskPanel();
		this.add(mainPanel);
		this.repaint();
	}
}
