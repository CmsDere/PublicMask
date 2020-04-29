package com.publicmask.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private JPanel mainPanel;
	public MainFrame() {
		
	}
	
	public JPanel callReservationPanel() {
		return new Reservation();
	}
}
