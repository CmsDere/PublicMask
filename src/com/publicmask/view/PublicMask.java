package com.publicmask.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.publicmask.controller.MainController;

public class PublicMask extends JPanel{
	private MainController mainController;
	private MainFrame mainFrame;
	
	public PublicMask() {
		this.setLayout(new BorderLayout());
		
		//공적마스크 예약시스템   North 
		JPanel toppanel = new JPanel();
		JLabel label = new JLabel("공적마스크 예약시스템");
		label.setForeground(Color.white);
		label.setFont(new Font("맑은 고딕",Font.BOLD, 11));//글씨체
		label.setFont(label.getFont().deriveFont(50.0f));//글씨크기
		toppanel.setBackground(new Color(82,204,250));
		toppanel.add(label);
				
		//약국 목록  Center 
		JPanel ctpanel = new JPanel();
		JLabel ctlabel = new JLabel("약국 목록 →  ");
		ctlabel.setFont(new Font("맑은 고딕" , Font.PLAIN, 40 ));//글씨체
//		ctlabel.setFont(ctlabel.getFont().deriveFont(55.0f));//글씨크기60.0f
		ctlabel.setForeground(new Color(82,204,250));//글씨색깔
		ctpanel.setBackground(new Color(255,255,255));//배경색
		ctpanel.add(ctlabel);
				
		//리스트 Center
		String[] pharmacy = {"    빨강 약국","    주황 약국","    노랑 약국","    초록 약국","    파랑 약국","    남색 약국","    보라 약국"};
		JList list = new JList(pharmacy);
		list.setFont(list.getFont().deriveFont(20.0f));//메뉴안글씨크기29.0f
		list.setBorder(BorderFactory.createLineBorder(Color.black,2));//테두리
		list.setPreferredSize(new Dimension(100,200));// 가로세로 사이즈100,280
		list.setBackground(Color.WHITE);
		ctpanel.add(list);
		
		//스크롤 Center
		JScrollPane scroller = new JScrollPane(list);
		scroller.setPreferredSize(new Dimension(160,90));//스크롤 사이즈210,80
							
		ctpanel.add(scroller);
		
		//선택한 약국: 라벨 South
		JLabel ctlabel1 = new JLabel(" 선택한 약국: ");
		ctlabel1.setFont(new Font("맑은 고딕" , Font.BOLD, 17 ));
		
		JTextField selected = new JTextField(9);
		selected.setEditable(false);
			
		//선택완료 버튼 South
		JPanel stpanel = new JPanel();
		JButton stbutton = new JButton("선택 완료");
		stbutton.setPreferredSize(new Dimension(120,30));
		stbutton.setFont(stbutton.getFont().deriveFont(19.0f));
		stpanel.setBackground(Color.WHITE);
				
				
		//약국 선택시 선택한 약국:에 표시 
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				selected.setText((String)list.getSelectedValue());
				selected.setPreferredSize(new Dimension(200,160));
				selected.setFont(new Font("serif" , Font.BOLD, 15));
			}
		});
		stbutton.addActionListener(new nextButtonEvent());
				
		stpanel.add(ctlabel1);
		stpanel.add(selected);
		stpanel.add(stbutton);
						
		this.add(toppanel,"North");
		this.add(ctpanel ,"Center");
		this.add(stpanel,"South");
	}
	
	private class nextButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mainFrame.replace(new View_DrugStoreInfo());
		}
		
	}
}
