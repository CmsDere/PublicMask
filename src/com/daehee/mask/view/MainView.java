package com.daehee.mask.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.daehee.mask.controller.MainController;
import com.daehee.mask.model.Maskinfo;

public class MainView {

	//필드 변수 설정
	MainController mc = new MainController();
	Scanner sc = new Scanner(System.in);
	
	private JFrame mf = new JFrame();
	private JPanel view;
	private Font f1, f2,f3;
	private int indexnum;
	

	//주된 화면
	public void MainView() {
		
		view = mainPanel();
	
		mf.add(view);
		mf.pack();
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	//Controller에서 약국리스트 및 데이터 받아오기.
	//메인패널에서 사용중이다.
	public ArrayList storeview() {
		return mc.storeview();
	}
	
	
	//패널 교체 메소드
	public void replace(JPanel view) {
		
		mf.remove(this.view);
		this.view = view;
		mf.add(this.view);
		mf.repaint();
		
	}
	
	//처음 목록 보여주는 UI
	public JPanel mainPanel() {
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		
		f1=new Font("궁서",Font.BOLD,40);	
		f2=new Font("바탕",Font.PLAIN	,20);
		f3=new Font("돋음",Font.PLAIN,20);
		
		JPanel storelistPanel = new JPanel();
		JPanel panel = new JPanel();
		
		ArrayList storeList=storeview();
		JList storelist = new JList(storeList.toArray());
		
		
		storelist.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		
		
		JScrollPane scroller = new JScrollPane(storelist);
		scroller.setPreferredSize(new Dimension(500,350));
		
		storelistPanel.add(scroller);
		
		JPanel panel2 = new JPanel();
		
		
		JLabel title = new JLabel("***** 약국 목록 리스트 *****");
		title.setSize(300, 300);
		title.setFont(f1);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		panel2.add(title);
		
		
		
		JLabel label = new JLabel("선택된 항목: ");
		label.setFont(f2);
	
		JTextField selected = new JTextField(40);
		selected.setSize(200, 200);
		selected.setFont(f3);
		
		selected.setEditable(false);
		
		storelist.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {

				selected.setText(storelist.getSelectedValue().toString());
				indexnum =storelist.getSelectedIndex();
				
			}
		});
		
		JButton post = new JButton("선택");
		post.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				replace(storeinfoView());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		
		panel.add(label);
		panel.add(selected);
		panel.add(post);
		
		mainPanel.add(panel2,"North");
		mainPanel.add(storelistPanel,"Center");
		mainPanel.add(panel,"South");
		
		
		
		
		return mainPanel;
	}
	
	//약국정보보여주는 UI
	public JPanel storeinfoView() {
		JPanel storeinforViewPanel = new JPanel();
		storeinforViewPanel.setLayout(new BorderLayout());
		
		//north
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.blue);
		JLabel label1 = new JLabel(mc.getStoreList().get(indexnum).getStoreName().toString()+"의 약국 프로필");
		label1.setForeground(Color.WHITE);
		label1.setFont(f1);
		panel1.add(label1);
		
		
		//center
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setLayout(new GridLayout(2,1));
		JLabel label2 = new JLabel("		● "+mc.getStoreList().get(indexnum).getAddress().toString());
		JLabel label3 = new JLabel("		● "+mc.getStoreList().get(indexnum).getPhoneNumber().toString());
		label2.setFont(f2);
		label3.setFont(f2);
		label2.setHorizontalAlignment(JLabel.LEFT);
		label3.setHorizontalAlignment(JLabel.LEFT);
		panel2.add(label2);
		panel2.add(label3);
		
		
		
		//south
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.getHSBColor(100, 100, 100));
		panel3.setLayout(new GridLayout(3,2));
		JLabel label4 = new JLabel(" ● KF94			");
		JLabel label5 = new JLabel(" "+((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(0)).getMaskNum()+"개");
		JLabel label6 = new JLabel(" ● KF80		");
		JLabel label7 = new JLabel(" "+((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(1)).getMaskNum()+"개");
		JLabel label8 = new JLabel(" ● 일반마스크		");
		JLabel label9 = new JLabel(" "+((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(2)).getMaskNum()+"개");
		label4.setFont(f3);
		label5.setFont(f3);
		label6.setFont(f3);
		label7.setFont(f3);
		label8.setFont(f3);
		label9.setFont(f3);
		panel3.add(label4);
		panel3.add(label5);
		panel3.add(label6);
		panel3.add(label7);
		panel3.add(label8);
		panel3.add(label9);
				
				
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		panel4.add(panel1,"North");
		panel4.add(panel2,"Center");
		panel4.add(panel3,"South");
		
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton button = new JButton("예약진행");
		panel5.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				replace(userinfoView());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
				
				
				
				
		storeinforViewPanel.add(panel4,"Center");
		storeinforViewPanel.add(panel5,"South");
	
		
		return storeinforViewPanel;
	}
	
	
	//필드변수 => 이름값과 주민번호값을 가져온다.
	String textstr1,textstr2;
	//유저 정보를 입력하는 UI 이다.
	public JPanel userinfoView() {
			
		JPanel userinfoViewPanel = new JPanel();
		
		userinfoViewPanel.setLayout(new BorderLayout());
		
		//메인 프레임의 North 부분
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.blue);
		JLabel label1 = new JLabel("노랑약국의 예약진행");
		label1.setFont(f1);
		label1.setForeground(Color.white);
		panel1.add(label1);
		
		
		//메인 프레임의 Center sub 1
		JPanel panel2 = new JPanel();
		JLabel label2 = new JLabel("        이름:  ");
		JTextField text1 = new JTextField(10);
		
		
		label2.setFont(f2);
		panel2.add(label2);
		panel2.add(text1);
		
		//메인 프레임의 Center sub 2
		JPanel panel3 = new JPanel();
		JLabel label3 = new JLabel("주민번호:  ");
		JTextField text2 = new JTextField(10);
		
		text2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textstr = text2.getText();

				if(textstr.length()==6) {
					text2.setText(textstr);
				}else{
					text2.setText("입력방법이 틀립니다.");
				}
			}
		});

		
		label3.setFont(f2);
		panel3.add(label3);
		panel3.add(text2);
		
		
		//메인 프레임의 Center
		//panel4에 panel2, panel3이 들어간다.
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(2,1));
		panel4.add(panel2);
		panel4.add(panel3);
		
				
		//메인 프레임의 South
		JPanel panel5 = new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton button = new JButton("  확인  ");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textstr1=text1.getText();
				textstr2=text2.getText();
				System.out.println("이름: "+textstr1+", 주민번호: "+textstr2);
				usercheck(textstr1, textstr2);
				
				
			}
		});
		
		panel5.add(button);
		
		
		
		
		userinfoViewPanel.add(panel1,"North");
		userinfoViewPanel.add(panel4,"Center");
		userinfoViewPanel.add(panel5,"South");
		
		
		
		
		return userinfoViewPanel;
	}
	
	//유저 예약 가능 여부 판단하는 메소드
	public void usercheck(String name, String num) {

		boolean check=mc.usercheck(name,num);
		
		if(check ==true) {
			System.out.println("예약을 진행합니다.");
			replace(Sell());
			mf.pack();
			mf.setVisible(true);
			mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		}else {
			System.out.println("예약 불가능2");
			replace(NoSell2());
			mf.pack();
			mf.setVisible(true);
			mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

	}
	
	
	
	//필드번수 => 각각의 마스크 수량을 가져온다.
	int num1,num2,num3;
	//살 마스크 개수를 설정하는 UI
	public JPanel Sell() {
		
		JPanel SellPanel = new JPanel();
		Font f1 = new Font("궁서",Font.BOLD,50);
		Font f2 = new Font("굴림",Font.BOLD,25);
		
		SellPanel.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		
		JLabel label1 = new JLabel("노랑약국의 예약진행");
		label1.setFont(f1);
		label1.setForeground(Color.white);
		label1.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(label1);
		panel1.setBackground(Color.BLUE);
		
		
		panel2.setLayout(new GridLayout(3,3));
		JLabel label2 = new JLabel(" KF94          ");
		label2.setFont(f2);
		JLabel label3 = new JLabel(" 1500원          ");
		label3.setFont(f2);
		JTextField text1 = new JTextField("0",3);
		JLabel label4 = new JLabel(" KF80          ");
		label4.setFont(f2);
		JLabel label5 = new JLabel(" 1000원          ");
		label5.setFont(f2);
		JTextField text2 = new JTextField("0",3);
		JLabel label6 = new JLabel(" 일반마스크            ");
		label6.setFont(f2);
		JLabel label7 = new JLabel("  500원 		");
		label7.setFont(f2);
		JTextField text3 = new JTextField("0",3);
		
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(text1);
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(text2);
		panel2.add(label6);
		panel2.add(label7);
		panel2.add(text3);
		
		
		panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton button = new JButton("확인");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				num1=Integer.parseInt(text1.getText());
				num2=Integer.parseInt(text2.getText());
				num3=Integer.parseInt(text3.getText());
				
				System.out.println(num1+", "+num2+", "+num3);
				maskinfo(num1,num2,num3);
				
				replace(reserveinfo());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
			}
		});
		panel3.add(button);
		
		
		
		SellPanel.add(panel1,"North");
		SellPanel.add(panel2,"Center");
		SellPanel.add(panel3,"South");
		
		
		
		
		return SellPanel;
	}
	
	
	//예약 불가능 메소드2
	public JPanel NoSell2() {
		
		JPanel NoSell2Panel = new JPanel();
		
		NoSell2Panel.setLayout(new BorderLayout());
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();   //중간 출력
		
		
		panel1.setBackground(Color.blue);
		panel1.setLayout(new BorderLayout());
		
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel3.setLayout(new GridLayout(9,1));
		
		JLabel label1 = new JLabel("예약이 불가능 합니다.!");
		label1.setForeground(Color.white);
		label1.setFont(f1);
		JLabel label2 = new JLabel("아래 공지를 확인해주세요.");
		label2.setForeground(Color.white);
		label2.setFont(f1);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		panel1.add(label1,"North");
		panel1.add(label2,"Center");
		panel1.setBorder(new LineBorder(Color.white, 30));
		
		JLabel label10 = new JLabel("              ");
		JLabel label3 = new JLabel("* 출생 년도 끝자리 *");
		label3.setFont(f2);
		JLabel label11 = new JLabel("              ");
		JLabel label4 = new JLabel("월요일 - 1, 6");
		JLabel label5 = new JLabel("화요일 - 2, 7");
		JLabel label6 = new JLabel("수요일 - 3, 8");
		JLabel label7 = new JLabel("목요일 - 4, 9");
		JLabel label8 = new JLabel("금요일 - 5, 0");
		JLabel label9 = new JLabel("토요일, 일요일은 누구든 구매 가능합니다.");
		
		label3.setHorizontalAlignment(JLabel.CENTER);
		label4.setHorizontalAlignment(JLabel.CENTER);
		label5.setHorizontalAlignment(JLabel.CENTER);
		label6.setHorizontalAlignment(JLabel.CENTER);
		label7.setHorizontalAlignment(JLabel.CENTER);
		label8.setHorizontalAlignment(JLabel.CENTER);
		label9.setHorizontalAlignment(JLabel.CENTER);
		
		panel3.add(label10);
		panel3.add(label3);
		panel3.add(label11);
		panel3.add(label4);
		panel3.add(label5);
		panel3.add(label6);
		panel3.add(label7);
		panel3.add(label8);
		panel3.add(label9);
		
		
		
		JButton button = new JButton("확인");
		panel2.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				replace(mainPanel());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
		
		
		NoSell2Panel.add(panel1,"North");
		NoSell2Panel.add(panel3,"Center");
		NoSell2Panel.add(panel2,"South");
		

		
		return NoSell2Panel;
	}
	
	
	//마스크 수량 체크하는 메소드
	public void maskinfo(int num1, int num2, int num3) {
		mc.maskinfo(num1, num2, num3);
	
	}
	
	//예약 내역 출력하는 UI
	public JPanel reserveinfo() {
		
		JPanel reserveinfoPanel = new JPanel();
		
		reserveinfoPanel.setLayout(new BorderLayout());

		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("**** 예약 내역 ****");
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setFont(f1);
		panel1.add(label1);
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,3,50,15));
		JLabel label2 = new JLabel(" ● KF94			");
		JLabel label3 = new JLabel("수량 : ");
		JLabel label4 = new JLabel(num1+"개");
		JLabel label5 = new JLabel(" ● KF80		");
		JLabel label6 = new JLabel("수량 : ");
		JLabel label7 = new JLabel(num2+"개");
		JLabel label8 = new JLabel(" ● 일반마스크		");
		JLabel label9 = new JLabel("수량 : ");
		JLabel label10 = new JLabel(num3+"개");
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(label6);
		panel2.add(label7);
		panel2.add(label8);
		panel2.add(label9);
		panel2.add(label10);
		
		
	
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel label11 = new JLabel(mc.getStoreList().get(indexnum).getStoreName().toString()+"의 예약 완료!");
		panel3.add(label11);
		
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton button = new JButton("확인");
		panel4.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				replace(mainPanel());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
			}
		});
		
		
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new BorderLayout());
		JLabel label12 = new JLabel("  ");
		panel5.add(label12,"North");
		panel5.add(panel3,"North");
		panel5.add(panel4,"Center");
	
		
		
		reserveinfoPanel.add(panel1,"North");
		reserveinfoPanel.add(panel2,"Center");
		reserveinfoPanel.add(panel5,"South");

		
		
		return reserveinfoPanel;
	}
	
	

	
	
}
