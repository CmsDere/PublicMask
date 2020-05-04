package com.publicmask.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.publicmask.controller.MainController;
import com.publicmask.model.Drugstoreinfo;

public class View_DrugStoreInfo extends JPanel {
	private Drugstoreinfo drugstoreInfo;
<<<<<<< HEAD
	private MainController Info;
=======

	private MainController Info = new MainController();

>>>>>>> 64ad98d20663c5291033ea52b7c0e06216033207
	
	  Font f1 = new Font("돋음",Font.BOLD,30);
      Font f2 = new Font("돋음",Font.BOLD,25);
      Font f3 = new Font("돋음",Font.BOLD,20);
	
	public View_DrugStoreInfo() {
//		this.setSize(1280, 720);
		this.setBackground(Color.white);
//		JLabel titleLabel = new JLabel("노랑약국");
		this.setLayout(new BorderLayout());
	
		
		JPanel Panel1  = new JPanel();	//타이틀
		JPanel Panel2 = new JPanel();	//약국
		JPanel Panel3 = new JPanel();	//마스크
		JPanel Panel3_main = new JPanel();	//마스크
		JPanel Panel3_mask = new JPanel();	//마스크
		JPanel Panel3_btn = new JPanel();	//마스크
		
		Panel1.setLayout(new GridLayout(2,1));
//		Panel1.setPreferredSize(new Dimension(500, 50));
		Panel1.setBackground(Color.white);
		Panel2.setLayout(new GridLayout(2,1));
		Panel2.setBackground(Color.white);
//		Panel2.setPreferredSize(new Dimension(500, 70));
		Panel3_main.setLayout(new GridLayout(2,1));
		Panel3_main.setBackground(Color.white);
		Panel3_mask.setLayout(new GridLayout(3,2));
		Panel3_mask.setBackground(Color.white);
		Panel3_btn.setBackground(Color.white);
		
		Panel2.setBorder(BorderFactory.createLineBorder(Color.black,2));
		Panel3_mask.setBorder(BorderFactory.createLineBorder(Color.black,2));

		
		JLabel titleLabel1 = new JLabel("약국정보 ");
		JLabel nameLabel= new JLabel();	//약국정보 라벨 이름
		JLabel adressLabel = new JLabel();	//약국정보 라벨 주소
		JLabel pNumLabel = new JLabel();	//약국정보 라벨	전번
		JLabel KF94Label = new JLabel("KF94");	
		JLabel KF94Label_num = new JLabel();	
		JLabel KF80Label = new JLabel("KF80");	
		JLabel KF80Label_num = new JLabel();	
		JLabel dentalLabel = new JLabel("일반마스크");	
		JLabel dentalLabel_num = new JLabel();
		
		JButton btn = new JButton("예약 진행");
		
		titleLabel1.setOpaque(true);
		titleLabel1.setBackground(Color.blue);
		titleLabel1.setForeground(Color.white);
		titleLabel1.setHorizontalAlignment(JLabel.CENTER);
		titleLabel1.setFont(f1);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setFont(f3);
		adressLabel.setHorizontalAlignment(JLabel.CENTER);
		adressLabel.setFont(f3);
		pNumLabel.setHorizontalAlignment(JLabel.CENTER);
		pNumLabel.setFont(f3);
		KF94Label.setHorizontalAlignment(JLabel.CENTER);
		KF94Label.setFont(f3);
		KF94Label_num.setHorizontalAlignment(JLabel.CENTER);
		KF94Label_num.setFont(f3);
		KF80Label.setHorizontalAlignment(JLabel.CENTER);
		KF80Label.setFont(f3);
		KF80Label_num.setHorizontalAlignment(JLabel.CENTER);
		KF80Label_num.setFont(f3);
		dentalLabel.setHorizontalAlignment(JLabel.CENTER);
		dentalLabel.setFont(f3);
		dentalLabel_num.setHorizontalAlignment(JLabel.CENTER);
		dentalLabel_num.setFont(f3);
		
		
		
<<<<<<< HEAD
		String name = drugstoreInfo.getStoreName();
=======

		String name=  drugstoreInfo.getStoreName();
>>>>>>> 64ad98d20663c5291033ea52b7c0e06216033207
		String adress = drugstoreInfo.getAddress();
		String pNumber = drugstoreInfo.getPhoneNumber();
//		String pNumber =Integer.toString(Info.SelectDrugstoreList().get(0).getpNumber());
		
<<<<<<< HEAD
//		String KF94 = Integer.toString(drugstoreInfo.getMaskinfo().get(0));
//		String KF80 = Integer.toString(Info.viewMask().get(0).getKF80());
//		String dental = Integer.toString(Info.viewMask().get(0).getDentalmask());
=======

		String KF94 = Integer.toString(Info.maskinfo().get(0).getKF94());
		String KF80 = Integer.toString(Info.viewMask().get(0).getKF80());
		String dental = Integer.toString(Info.viewMask().get(0).getDentalmask());
>>>>>>> 64ad98d20663c5291033ea52b7c0e06216033207
	
		nameLabel.setText(name);
		
		Panel1.add(titleLabel1);
		Panel1.add(nameLabel);
		
		adressLabel.setText(adress);
		pNumLabel.setText(pNumber);
		
		Panel2.add(adressLabel);
		Panel2.add(pNumLabel);
		
//		KF94Label_num.setText(KF94);
//		KF80Label_num.setText(KF80);
//		dentalLabel_num.setText(dental);
		
		Panel3_mask.add(KF94Label);
		Panel3_mask.add(KF94Label_num);
		Panel3_mask.add(KF80Label);
		Panel3_mask.add(KF80Label_num);
		Panel3_mask.add(dentalLabel);
		Panel3_mask.add(dentalLabel_num);
		
		Panel3_btn.add(btn);
		Panel3_btn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		Panel3_main.add(Panel3_mask,"North");
		Panel3_main.add(Panel3_btn,BorderLayout.EAST);
		
		
		this.add(Panel1,"North");
		this.add(Panel2,"Center");
		this.add(Panel3_main,"South");

		this.setVisible(true);
		
	}
}
