package com.publicmask.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReservationResult extends JPanel{
	public ReservationResult() {
		this.setLayout(new BorderLayout());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel topicPanel = new JPanel();
		JLabel topic = new JLabel("예약 내역");
		topicPanel.setBackground(Color.CYAN);
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
}
