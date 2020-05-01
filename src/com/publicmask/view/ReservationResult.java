package com.publicmask.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReservationResult extends JPanel{
	private MainFrame mf;
	private Dialog choice;
	
	public ReservationResult() {
		this.setLayout(new BorderLayout());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel topicPanel = new JPanel();
		JLabel topic = new JLabel("예약 내역");
		topicPanel.setBackground(new Color(255, 0, 0));
		topicPanel.setLocation(0, 0);
		topic.setForeground(Color.WHITE);
		topic.setFont(topic.getFont().deriveFont(50.0f));
		
		JPanel contentPanel = new JPanel();
		JLabel kf94Mask = new JLabel("KF94                  수량 2개");
		JLabel kf80Mask = new JLabel("KF80                  수량 0개");
		JLabel commonMask = new JLabel("일반 마스크       수량 1개");
		contentPanel.setBackground(Color.BLUE);
		contentPanel.setLayout(new BorderLayout());
		kf94Mask.setForeground(Color.WHITE);
		kf94Mask.setFont(kf94Mask.getFont().deriveFont(50.0f));
		kf80Mask.setForeground(Color.WHITE);
		kf80Mask.setFont(kf80Mask.getFont().deriveFont(50.0f));
		commonMask.setForeground(Color.WHITE);
		commonMask.setFont(commonMask.getFont().deriveFont(50.0f));
		
		JPanel resultPanel = new JPanel();
		JLabel result = new JLabel("노랑 약국 예약 완료");
		JButton nextButton = new JButton("확인");
		resultPanel.setBackground(Color.WHITE);
		result.setForeground(Color.BLACK);
		result.setFont(result.getFont().deriveFont(50.0f));
		nextButton.setFont(nextButton.getFont().deriveFont(50.0f));
		nextButton.addActionListener(new GoToDialogButton());
		
		choice = new Dialog(mf, "안내");
		choice.setBounds(300, 200, 300, 200);;
		choice.setLayout(new GridLayout(1, 2));
		JButton goToMain = new JButton("처음으로");
		JButton exit = new JButton("종료");
		choice.add(goToMain);
		choice.add(exit);
		goToMain.addActionListener(new GoToMainButton());
		exit.addActionListener(new ProgramExitButton());
		
		topicPanel.add(topic);
		
		contentPanel.add(kf94Mask, "North");
		contentPanel.add(kf80Mask, "Center");
		contentPanel.add(commonMask, "South");
		
		resultPanel.add(result);
		resultPanel.add(nextButton);
		
		mainPanel.add(topicPanel, "North");
		mainPanel.add(contentPanel, "Center");
		mainPanel.add(resultPanel, "South");
		
		this.add(mainPanel);
	}
	
	private class GoToDialogButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			choice.setVisible(true);
		}
	}
	
	private class GoToMainButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class ProgramExitButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
