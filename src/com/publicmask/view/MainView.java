package com.publicmask.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.publicmask.controller.MainController;
import com.publicmask.model.Maskinfo;

import javafx.scene.input.KeyEvent;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class MainView {

	// 필드 변수 설정
	MainController mc = new MainController();
	Scanner sc = new Scanner(System.in);

	private JFrame mf = new JFrame();
	private JPanel view;
	private Font f1, f2, f3;
	private int indexnum;

	// 필드변수 => 이름값과 주민번호값을 가져온다.
	private String textstr1, textstr2;
	private int strcount = 0;

	// 주된 화면
	public MainView() {

		view = ModeChoosePanel();

		mf.setTitle("공적마스크 예약 시스템");
		try {
			mf.setIconImage(ImageIO.read(new File("image/mask2.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		mf.add(view);
		mf.setSize(1200, 500);
		mf.setLocation(650, 300);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// Controller에서 약국리스트 및 데이터 받아오기.
	// 메인패널에서 사용중이다.
	public ArrayList storeview() {
		return mc.storeview();
	}

	// 패널 교체 메소드
	public void replace(JPanel view) {

		mf.remove(this.view);
		this.view = view;
		mf.add(this.view);
		mf.repaint();

	}

	// 모드를 선택하는 패널
	public JPanel ModeChoosePanel() {

		JPanel modeChoosePanel = new JPanel();
		modeChoosePanel.setLayout(new BorderLayout());

		modeChoosePanel.setLayout(new BorderLayout());
		modeChoosePanel.setBounds(650, 300, 1200, 500);

		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("***공적마스크 예약시스템에 오신걸 환영합니다***");
		label1.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		label1.setFont(label1.getFont().deriveFont(50.0f));
		label1.setForeground(Color.WHITE);
		panel1.setBackground(new Color(82, 204, 250));
		panel1.add(label1);

		JPanel panel2 = new JPanel(new GridLayout(1, 2));
		JButton button1 = new JButton("고객 모드");
		button1.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		button1.setFont(button1.getFont().deriveFont(30.0f));
		JButton button2 = new JButton("관리자 모드");
		button2.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		button2.setFont(button2.getFont().deriveFont(30.0f));
		JLabel label2 = new JLabel(" ");

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				replace(mainPanel());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				replace(LoginPanel());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});

		panel2.add(button1);
		panel2.add(button2);

		modeChoosePanel.add(panel1, "North");
		modeChoosePanel.add(panel2, "Center");

		return modeChoosePanel;
	}

	public JPanel LoginPanel() {

		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		
		
		Image icon = new ImageIcon("image/1_top_01.PNG").getImage().getScaledInstance(500, 180, 0);
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(252,252,243));
		JLabel label1 = new JLabel(new ImageIcon(icon));
		label1.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(label1);
	
		
		JPanel panel2 = new JPanel(new GridLayout(4,1));
		panel2.setBackground(new Color(252,252,243));
		JLabel label2 = new JLabel("  ");
		
		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel4.setBackground(new Color(252,252,243));
		JLabel label3 = new JLabel("          ID :");
		label3.setFont(new Font("맑은 고딕",Font.BOLD,13));
		label3.setFont(label3.getFont().deriveFont(30.0f));
		label3.setHorizontalAlignment(JLabel.CENTER);
		JTextField text1 = new JTextField(13);
		text1.setFont(text1.getFont().deriveFont(20.0f));
		panel4.add(label3);
		panel4.add(text1);
		
		JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel5.setBackground(new Color(252,252,243));
		JLabel label4 = new JLabel("Password :");
		label4.setFont(new Font("맑은 고딕",Font.BOLD,13));
		label4.setFont(label4.getFont().deriveFont(30.0f));
		label4.setHorizontalAlignment(JLabel.CENTER);
		JPasswordField text2 = new JPasswordField(13);
		text2.setFont(text2.getFont().deriveFont(20.0f));
		text2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean check = mc.adminCheck(text1.getText(), text2.getText());

				if (check == true) {
					replace(adminMainViewPanel());
					mf.setSize(500, 500);
					mf.setVisible(true);
					mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				} else {
					JFrame warningf = new JFrame();
					Dialog warning = new Dialog(warningf, "로그인 안내");
					warning.setBounds(300, 200, 500, 200);
					;
					warning.setLayout(new GridLayout(2, 1));
					JLabel warninglabel1 = new JLabel("입력하신 ID, Password가 잘못되었습니다.");
					warninglabel1.setFont(f3);
					warninglabel1.setHorizontalAlignment(JLabel.CENTER);
					JPanel panel1 = new JPanel(null);
//						panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
					JButton checkmemo = new JButton("확인");
					checkmemo.setBounds(200, 25, 70, 35);
					panel1.add(checkmemo);
					warning.setVisible(true);
					checkmemo.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							text1.setText("");
							text2.setText("");
							warning.dispose();
						}
					});
					warning.add(warninglabel1);
					warning.add(panel1);
				}
			}
		});
		panel5.add(label4);
		panel5.add(text2);
		
		panel2.add(new JLabel(" "));
		panel2.add(panel4);
		panel2.add(panel5);		
		panel2.add(new JLabel(" "));
		
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel3.setBackground(new Color(252,252,243));		
		JButton button1 = new JButton(new ImageIcon("image/1_right_btn.png"));
		button1.setPreferredSize(new Dimension(100,100));
		JButton button2 = new JButton(new ImageIcon("image/1_left_btn.png"));
		button2.setPreferredSize(new Dimension(100,100));
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				replace(ModeChoosePanel());
				mf.setSize(1200, 500);
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean check = mc.adminCheck(text1.getText(), text2.getText());
				
				if(check==true) {
					replace(adminMainViewPanel());
					mf.setSize(500, 500);
					mf.setVisible(true);
					mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				}else {
					JFrame warningf = new JFrame();
					Dialog warning = new Dialog(warningf,"로그인 안내");
					warning.setBounds(300, 200, 500, 200);;
					warning.setLayout(new GridLayout(2, 1));
					JLabel warninglabel1 = new JLabel("입력하신 ID, Password가 잘못되었습니다.");
					warninglabel1.setFont(f3);
					warninglabel1.setHorizontalAlignment(JLabel.CENTER);
					JPanel panel1 = new JPanel(null);
//					panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
					JButton checkmemo = new JButton("확인");
					checkmemo.setBounds(200, 25, 70, 35);
					panel1.add(checkmemo);
					warning.setVisible(true);
					checkmemo.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							text1.setText("");
							text2.setText("");
							warning.dispose();
						}
					});
					warning.add(warninglabel1);
					warning.add(panel1);
				}
			}
		});
		
		panel3.add(button1);
		panel3.add(new Label("               "));
		panel3.add(button2);
		
		
		loginPanel.add(panel1,"North");
		loginPanel.add(panel2,"Center");
		loginPanel.add(panel3,"South");
		
		
		return loginPanel;
	}

	public JPanel adminMainViewPanel() {

		JPanel adminMainViewPanel = new JPanel();
		adminMainViewPanel.setLayout(new BorderLayout());
		adminMainViewPanel.setSize(500, 500);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(252,252,243));
		panel1.setLayout(new BorderLayout());
		Image icon = new ImageIcon("image/1_top_01.PNG").getImage().getScaledInstance(500, 180, 0);
		JLabel topimage = new JLabel(new ImageIcon(icon));
		JLabel label1 = new JLabel("*관리자 페이지에 오신걸 환영합니다.*");
		label1.setFont(new Font("HY헤드라인", Font.BOLD, 13));
		label1.setFont(label1.getFont().deriveFont(25.0f));
		label1.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(topimage,"North");
		panel1.add(label1,"Center");
		
		
		JPanel panel3 = new JPanel(new GridLayout(2,1));
		panel3.setBackground(new Color(252,252,243));
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel2.setBackground(new Color(252,252,243));
		JButton button1 = new JButton(new ImageIcon("image/2_storeinfo_btn.png"));
		button1.setPreferredSize(new Dimension(100,100));
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				replace(adminStorelistViewPanel());
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
			}
		});
		JButton button2 = new JButton(new ImageIcon("image/2_consumerlist_btn.png"));
		button2.setPreferredSize(new Dimension(100,100));
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				replace(BuyerListPanel());
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		JButton button3 = new JButton(new ImageIcon("image/2_first_btn.png"));
		button3.setPreferredSize(new Dimension(100,100));
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				replace(LoginPanel());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		panel2.add(button2);
		panel2.add(new JLabel("  "));
		panel2.add(button1);
		panel2.add(new JLabel("  "));
		panel2.add(button3);
		
		panel3.add(new JLabel("  "));
		panel3.add(panel2);
		
		adminMainViewPanel.add(panel1,"North");
		adminMainViewPanel.add(panel3,"Center");
		

		return adminMainViewPanel;
	}

	public JPanel adminStorelistViewPanel() {

		JPanel adminStorelistViewPanel = new JPanel();
		
		adminStorelistViewPanel.setLayout(new BorderLayout());
		adminStorelistViewPanel.setSize(500, 500);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(252,252,243));
		Image icon1 = new ImageIcon("image/4_top.png").getImage().getScaledInstance(500, 130, 0);
		JLabel label1 = new JLabel(new ImageIcon(icon1));
		label1.setFont(new Font("맑은 고딕" , Font.PLAIN, 40 ));//글씨체
		label1.setFont(label1.getFont().deriveFont(55.0f));//글씨크기60.0f
		panel1.add(label1);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(252,252,243));
		ArrayList pharmacy = storeview();
		JList list = new JList(pharmacy.toArray());
		list.setFont(list.getFont().deriveFont(20.0f));
		list.setBorder(BorderFactory.createLineBorder(Color.black,2));
		list.setPreferredSize(new Dimension(100,200));
		list.setBackground(Color.WHITE);
		panel2.add(list);
		
		
		JScrollPane scroller = new JScrollPane(list);
		scroller.setPreferredSize(new Dimension(300,250));		
		panel2.add(scroller);
		

		JLabel label2 = new JLabel(" 선택한 약국: ");
		label2.setFont(new Font("맑은 고딕" , Font.BOLD, 18 ));
		
		JTextField selected = new JTextField(9);
//		selected.setPreferredSize(new Dimension());
		selected.setEditable(false);
			
		//선택완료 버튼 South
		JPanel panel3 = new JPanel();
		JButton stbutton = new JButton(new ImageIcon("image/4_choice_btn.png"));
		stbutton.setPreferredSize(new Dimension(60,40));
		stbutton.setFont(stbutton.getFont().deriveFont(19.0f));
		panel3.setBackground(new Color(252,252,243));
		stbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				replace(adminChangeStoreinfo());
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		
		JButton back = new JButton(new ImageIcon("image/3_back_btn.png"));
		back.setPreferredSize(new Dimension(60,40));
		back.setFont(back.getFont().deriveFont(19.0f));
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				replace(adminMainViewPanel());
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		
				
		//약국 선택시 선택한 약국:에 표시 
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				selected.setText(list.getSelectedValue().toString().split(",")[0]);
				selected.setPreferredSize(new Dimension(200,40));
				selected.setFont(new Font("serif" , Font.BOLD, 15));
				indexnum =list.getSelectedIndex();
			}
		});
		
		panel3.add(label2);
		panel3.add(selected);
		panel3.add(stbutton);
		panel3.add(back);
		
		
		adminStorelistViewPanel.add(panel1,"North");
		adminStorelistViewPanel.add(panel2,"Center");
		adminStorelistViewPanel.add(panel3,"South");
		
		
		
		
		
		return adminStorelistViewPanel;
	}

	public JPanel adminChangeStoreinfo() {

		JPanel adminChangeStorinfoPanel = new JPanel();
		
		adminChangeStorinfoPanel.setLayout(new BorderLayout());
		adminChangeStorinfoPanel.setSize(500, 500);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(252,252,243));
		JLabel label1 = new JLabel(mc.getStoreList().get(indexnum).getStoreName().toString()+"의 프로필");
		label1.setFont(new Font("맑은 고딕",Font.BOLD, 11));
		label1.setFont(label1.getFont().deriveFont(35.0f));
		panel1.add(label1);
		
		
		
		JPanel panel5 = new JPanel(new GridLayout(2,1));
		panel5.setBackground(new Color(252,252,243));
		JPanel panel2 = new JPanel(new GridLayout(0,2));
		panel2.setBackground(new Color(252,252,243));
		JLabel label2 = new JLabel("1. 주소: ");
		label2.setFont(new Font("견고딕",Font.BOLD, 13));
		label2.setFont(label2.getFont().deriveFont(20.0f));
		JTextField text1 = new JTextField(mc.getStoreList().get(indexnum).getAddress().toString());
		JLabel label3 = new JLabel("2. 전화번호:");
		label3.setFont(new Font("견고딕",Font.BOLD, 13));
		label3.setFont(label2.getFont().deriveFont(20.0f));
		JTextField text2 = new JTextField(mc.getStoreList().get(indexnum).getPhoneNumber().toString());
		JLabel label4 = new JLabel("3. 마스크 현황");
		label4.setFont(new Font("견고딕",Font.BOLD, 13));
		label4.setFont(label2.getFont().deriveFont(20.0f));
		
		panel2.add(label2);
		panel2.add(text1);
		panel2.add(label3);
		panel2.add(text2);
		panel2.add(label4);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(252,252,243));
		panel3.setLayout(new GridLayout(3,2));
		JLabel label5 = new JLabel("    KF94 : ");
		label5.setFont(label2.getFont().deriveFont(15.0f));
		JTextField text3 = new JTextField(((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(0)).getMaskNum()+"");
		JLabel label6 = new JLabel("    KF80 : ");
		label6.setFont(label2.getFont().deriveFont(15.0f));
		JTextField text4 = new JTextField(((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(1)).getMaskNum()+"");
		JLabel label7 = new JLabel("    일반마스크 : ");
		label7.setFont(label2.getFont().deriveFont(15.0f));
		JTextField text5 = new JTextField(((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(2)).getMaskNum()+"");
		
		
		text1.setFocusTraversalKeysEnabled(false);
		text1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				if(e.getKeyCode()==e.VK_TAB) {
					text2.requestFocus();
					text2.setText("");
				}
				
			}
		});
		text1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				text1.setText("");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				text1.setText("");
				
			}
		});
		
		text2.setFocusTraversalKeysEnabled(false);
		text2.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				if(e.getKeyCode()==e.VK_TAB) {
					text3.requestFocus();
					text3.setText("");
				}
				
			}
		});
		text2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				text2.setText("");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				text2.setText("");
				
			}
		});
		text3.setFocusTraversalKeysEnabled(false);
		text3.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				if(e.getKeyCode()==e.VK_TAB) {
					text4.requestFocus();
					text4.setText("");
				}
				
			}
		});
		text3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				text3.setText("");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				text3.setText("");
				
			}
		});
		text4.setFocusTraversalKeysEnabled(false);
		text4.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				if(e.getKeyCode()==e.VK_TAB) {
					text5.requestFocus();
					text5.setText("");
				}
				
			}
		});
		text4.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				text4.setText("");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				text4.setText("");
				
			}
		});
		text5.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				text5.setText("");
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				text5.setText("");
				
			}
		});
		
		panel3.add(label5);
		panel3.add(text3);
		panel3.add(label6);
		panel3.add(text4);
		panel3.add(label7);
		panel3.add(text5);
		
		panel5.add(panel2);
		panel5.add(panel3);
		
		
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(252,252,243));
		panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton button1 = new JButton("수정");
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String address;
				String phoneNumber;
				int num1,num2,num3;
				
				if(text1.getText().equals("") || text1.getText().equals(mc.getStoreList().get(indexnum).getAddress().toString())) {
					address = mc.getStoreList().get(indexnum).getAddress().toString();
				}else {
					address = text1.getText();
				}
				if(text2.getText().equals("") || text2.getText().equals(mc.getStoreList().get(indexnum).getPhoneNumber().toString())) {
					phoneNumber= mc.getStoreList().get(indexnum).getPhoneNumber().toString();
				}else {
					phoneNumber = text2.getText();
				}
				if(text3.getText().equals("") || text3.getText().equals((((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(0)).getMaskNum()+""))) {
					num1=((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(0)).getMaskNum();
				}else {
					num1 = Integer.parseInt(text3.getText());
				}
				if(text4.getText().equals("") || text3.getText().equals((((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(1)).getMaskNum()+""))) {
					num2=((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(1)).getMaskNum();
				}else {
					num2 = Integer.parseInt(text4.getText());
				}
				if(text5.getText().equals("") || text3.getText().equals((((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(2)).getMaskNum()+""))) {
					num3=((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(2)).getMaskNum();
				}else {
					num3 = Integer.parseInt(text5.getText());
				}
				
				JFrame checkinfomf = new JFrame();
				Dialog checkinfo = new Dialog(checkinfomf,"수정할 정보 확인");
				checkinfo.setBounds(700, 250, 700, 500);
				
				JPanel checkpanel1 = new JPanel();
				JLabel checkLabel1 = new JLabel("입력하신 정보가 맞습니까?");
				checkLabel1.setFont(new Font("맑은 고딕",Font.BOLD, 11));
				checkLabel1.setFont(checkLabel1.getFont().deriveFont(30.0f));
				checkpanel1.setBackground(Color.white);
				checkpanel1.add(checkLabel1);
				
				Font f2 = new Font("굴림",Font.BOLD,25);
				
				JPanel checkpanel2 = new JPanel(new GridLayout(5,2));
				
				JLabel checkLabel2 = new JLabel("       주소: ");
				checkLabel2.setHorizontalAlignment(JLabel.LEFT);
				JLabel checkLabel3 = new JLabel(address+"     ");
				checkLabel3.setHorizontalAlignment(JLabel.RIGHT);
				JLabel checkLabel4 = new JLabel("       전화번호: ");
				checkLabel4.setHorizontalAlignment(JLabel.LEFT);
				JLabel checkLabel5 = new JLabel(phoneNumber+"     ");
				checkLabel5.setHorizontalAlignment(JLabel.RIGHT);
				JLabel checkLabel6 = new JLabel("       KF94");
				checkLabel6.setHorizontalAlignment(JLabel.LEFT);
				JLabel checkLabel7 = new JLabel(num1+"개          ");
				checkLabel7.setHorizontalAlignment(JLabel.RIGHT);
				JLabel checkLabel8 = new JLabel("       KF80");
				checkLabel8.setHorizontalAlignment(JLabel.LEFT);
				JLabel checkLabel9 = new JLabel(num2+"개          ");
				checkLabel9.setHorizontalAlignment(JLabel.RIGHT);
				JLabel checkLabel10 = new JLabel("       일반마스크");
				checkLabel10.setHorizontalAlignment(JLabel.LEFT);
				JLabel checkLabel11 = new JLabel(num3+"개          ");
				checkLabel11.setHorizontalAlignment(JLabel.RIGHT);
				checkLabel2.setFont(f2);
				checkLabel3.setFont(f2);
				checkLabel4.setFont(f2);
				checkLabel5.setFont(f2);
				checkLabel6.setFont(f2);
				checkLabel7.setFont(f2);
				checkLabel8.setFont(f2);
				checkLabel9.setFont(f2);
				checkLabel10.setFont(f2);
				checkLabel11.setFont(f2);
				checkpanel2.add(checkLabel2);
				checkpanel2.add(checkLabel3);
				checkpanel2.add(checkLabel4);
				checkpanel2.add(checkLabel5);
				checkpanel2.add(checkLabel6);
				checkpanel2.add(checkLabel7);
				checkpanel2.add(checkLabel8);
				checkpanel2.add(checkLabel9);
				checkpanel2.add(checkLabel10);
				checkpanel2.add(checkLabel11);
				checkpanel2.setBackground(Color.white);
				
				
				JPanel checkpanel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
				JButton checkButton1 = new JButton("네");
				JButton checkButton2 = new JButton("아니요");
				checkButton1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {

						mc.getStoreList().get(indexnum).setAddress(address);
						mc.getStoreList().get(indexnum).setPhoneNumber(phoneNumber);

						((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(0)).setMaskNum(num1);
						((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(1)).setMaskNum(num2);
						((Maskinfo)mc.getStoreList().get(indexnum).getMaskinfo().get(2)).setMaskNum(num3);

						mc.storeDataSave(mc.getStoreList().get(indexnum).getStoreName(), address, phoneNumber, num1,
								num2, num3);
						
//						mc.replaceStoreData(mc.getStoreList().get(indexnum).getStoreName(), address, phoneNumber, num1,
//								num2, num3);

//						((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(0)).setMaskNum(num1);
//						;
//						((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(1)).setMaskNum(num2);
//						;
//						((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(2)).setMaskNum(num3);
//						;


						JFrame modifymf = new JFrame();
						Dialog modifyComplete = new Dialog(modifymf,"약국 정보 수정 완료");
						modifyComplete.setLayout(new GridLayout(3,1));
						modifyComplete.setBounds(700, 250, 300, 300);
						modifyComplete.add(new JPanel(null));
						
						JPanel panel1 = new JPanel();
						JLabel label1 = new JLabel("수정이 완료되었습니다.");
						label1.setFont(new Font("HY헤드라인",Font.BOLD,14));
						label1.setFont(label1.getFont().deriveFont(20.0f));
						panel1.add(label1);
						
						JPanel panel2 = new JPanel();
						JButton button1 = new JButton("확인");
						panel2.add(button1);
						
						button1.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								replace(adminMainViewPanel());
								mf.setSize(500, 500);
								mf.setVisible(true);
								mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								checkinfo.dispose();
								modifyComplete.dispose();
							}
						});
						
						modifyComplete.add(panel1);
						modifyComplete.add(panel2);
						
						modifyComplete.setVisible(true);
						
					}
				});
				checkButton2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						replace(adminChangeStoreinfo());
						mf.setSize(500, 500);
						mf.setVisible(true);
						mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						checkinfo.dispose();
					}
				});
				
				checkpanel3.add(checkButton1);
				checkpanel3.add(checkButton2);
				checkpanel3.setBackground(Color.white);
				
				checkinfo.add(checkpanel1,"North");
				checkinfo.add(checkpanel2,"Center");
				checkinfo.add(checkpanel3,"South");
				
				checkinfo.setVisible(true);

				
			}
		});
		panel4.add(button1);
		
		
		adminChangeStorinfoPanel.add(panel1,"North");
		adminChangeStorinfoPanel.add(panel5,"Center");
		adminChangeStorinfoPanel.add(panel4,"South");
		
		
		
		return adminChangeStorinfoPanel;
	}

	public ArrayList viewPerson() {
		return mc.viewPerson();
	}

	public JPanel BuyerListPanel() {
		viewPerson();

		JPanel ShowPersonPanel = new JPanel();
		ShowPersonPanel.setLayout(new BorderLayout());

		Font storef1 = new Font("돋음", Font.BOLD, 30);
		Font storef2 = new Font("돋음", Font.BOLD, 25);
		Font storef3 = new Font("돋음", Font.BOLD, 20);

		// 열
		String header[] = { "이름", "주민등록번호", "구매약국" };

		DefaultTableModel model = new DefaultTableModel(header, 0);
		JTable table = new JTable(model);

		// 행 받아오기
		Object[] buyerName = mc.getbuyerList().toArray();
		Object[] buyerNum = mc.getbuyerList().toArray();
		Object[] buyerStore = mc.getbuyerList().toArray();

		for (int i = 0; i < mc.getbuyerList().size(); i++) {
			buyerName[i] = mc.getbuyerList().get(i).getPname();
			buyerNum[i] = mc.getbuyerList().get(i).getPnum();
			buyerStore[i] = mc.getbuyerList().get(i).getStorename();

		}

		for (int i = 0; i < mc.getbuyerList().size(); i++) {

			String[] contents = new String[3];

			contents[0] = (String) buyerName[i];
			contents[1] = (String) buyerNum[i];
			contents[2] = (String) buyerStore[i];

			// 행 추가
			model.addRow(contents);
			contents[0] = null;
			contents[1] = null;
			contents[2] = null;

		}

		// 초기화하려는데 안됨

		table.getTableHeader().setBackground(Color.white);
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		table.setPreferredScrollableViewportSize(new Dimension(525, 200)); // 테이블 크기

		// 제목 패널
		JPanel Panel1 = new JPanel();

		Panel1.setPreferredSize(new Dimension(525, 50)); // 패널 사이즈 설정으로 그 전화면과 사이즈 통일
		Panel1.setBackground(new Color(82, 204, 250));

		JLabel titleLabel = new JLabel("구매자 리스트");
		titleLabel.setBackground(Color.white);
		titleLabel.setForeground(Color.white);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(storef1);

		Panel1.add(titleLabel);

		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBackground(Color.WHITE);

		// 가운데 정렬위한 객체 생성
		DefaultTableCellHeaderRenderer celAlignCenter = new DefaultTableCellHeaderRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		TableColumnModel tcmSchedule = table.getColumnModel();

		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {

			tcmSchedule.getColumn(i).setCellRenderer(celAlignCenter);

		}

		JPanel btnPanel = new JPanel();

		JButton btn = new JButton("이전으로");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				replace(adminMainViewPanel());
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});

		btnPanel.add(btn);
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		ShowPersonPanel.add(Panel1, "North");
		ShowPersonPanel.add(scrollpane, BorderLayout.CENTER);
		ShowPersonPanel.add(btnPanel, "South");

		return ShowPersonPanel;

	}

	// 처음 목록 보여주는 UI
	public JPanel mainPanel() {

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		f1 = new Font("궁서", Font.BOLD, 40);
		f2 = new Font("바탕", Font.PLAIN, 20);
		f3 = new Font("돋음", Font.PLAIN, 20);

		JPanel toppanel = new JPanel();
		JLabel label = new JLabel("공적마스크 예약시스템");
		label.setForeground(Color.white);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 11));// 글씨체
		label.setFont(label.getFont().deriveFont(50.0f));// 글씨크기
		toppanel.setBackground(new Color(82, 204, 250));
		toppanel.add(label);

		// 약국 목록 Center
		JPanel ctpanel = new JPanel();
		JLabel ctlabel = new JLabel("약국 목록 →  ");
		ctlabel.setFont(new Font("맑은 고딕", Font.PLAIN, 40));// 글씨체
//		ctlabel.setFont(ctlabel.getFont().deriveFont(55.0f));//글씨크기60.0f
		ctlabel.setForeground(new Color(82, 204, 250));// 글씨색깔
		ctpanel.setBackground(new Color(255, 255, 255));// 배경색
		ctpanel.add(ctlabel);

		JPanel storelistPanel = new JPanel();
		JPanel panel = new JPanel();

		ArrayList pharmacy = storeview();
		JList list = new JList(pharmacy.toArray());

		list.setFont(list.getFont().deriveFont(20.0f));// 메뉴안글씨크기29.0f
		list.setBorder(BorderFactory.createLineBorder(Color.black, 2));// 테두리
//		list.setPreferredSize(new Dimension(100,200));// 가로세로 사이즈100,280
		list.setBackground(Color.WHITE);
		ctpanel.add(list);

		// 스크롤 Center
		JScrollPane scroller = new JScrollPane(list);
//		scroller.setPreferredSize(new Dimension(160,90));//스크롤 사이즈210,80
//		scroller.setPreferredSize(new Dimension(500,350));

		ctpanel.add(scroller);

		// 선택한 약국: 라벨 South
		JLabel ctlabel1 = new JLabel(" 선택한 약국: ");
		ctlabel1.setFont(new Font("맑은 고딕", Font.BOLD, 17));

		JTextField selected = new JTextField(9);
		selected.setEditable(false);

		// 선택완료 버튼 South
		JPanel stpanel = new JPanel();
		JButton stbutton = new JButton("선택 완료");
		stbutton.setPreferredSize(new Dimension(120, 30));
		stbutton.setFont(stbutton.getFont().deriveFont(19.0f));
		stpanel.setBackground(Color.WHITE);

		// 약국 선택시 선택한 약국:에 표시
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				selected.setText(list.getSelectedValue().toString().split(",")[0]);
				selected.setPreferredSize(new Dimension(200, 160));
				selected.setFont(new Font("serif", Font.BOLD, 15));
				indexnum = list.getSelectedIndex();
			}
		});

		stbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				replace(storeinfoView());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});

		stpanel.add(ctlabel1);
		stpanel.add(selected);
		stpanel.add(stbutton);

		mainPanel.add(toppanel, "North");
		mainPanel.add(ctpanel, "Center");
		mainPanel.add(stpanel, "South");

		return mainPanel;
	}

	// 약국정보보여주는 UI
	public JPanel storeinfoView() {
		JPanel storeinforViewPanel = new JPanel();
		storeinforViewPanel.setLayout(new BorderLayout());

		Font storef1 = new Font("돋음", Font.BOLD, 30);
		Font storef2 = new Font("돋음", Font.BOLD, 25);
		Font storef3 = new Font("돋음", Font.BOLD, 20);

		JPanel Panel1 = new JPanel(); // 타이틀
		JPanel Panel2_info = new JPanel(); // 약국 정보(약국정보 + 마스크 수량)
		JPanel Panel2_drug = new JPanel(); // 약국정보
		JPanel Panel2_mask_t = new JPanel();
		JPanel Panel2_mask = new JPanel(); // 마스크 수량
		JPanel Panel3_btn = new JPanel(); // 버튼

		Panel1.setPreferredSize(new Dimension(525, 70)); // 패널 사이즈 설정으로 그 전화면과 사이즈 통일
		Panel1.setBackground(new Color(82, 204, 250));
		Panel2_info.setLayout(new GridLayout(3, 1));
		Panel2_drug.setLayout(new GridLayout(2, 2));
		Panel2_drug.setBackground(Color.white);
//		Panel2.setPreferredSize(new Dimension(500, 70));
		Panel2_mask_t.setLayout(new GridLayout(2, 1));
		Panel2_mask_t.setBackground(Color.white);
		Panel2_mask.setLayout(new GridLayout(3, 2));
		Panel2_mask.setBackground(Color.white);
		Panel3_btn.setBackground(Color.white);

		Panel2_drug.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		Panel2_mask.setBorder(BorderFactory.createLineBorder(Color.black, 2));

		JLabel titleLabel1 = new JLabel();
		JLabel nameLabel_t = new JLabel("주소");
		JLabel adressLabel_t = new JLabel("전화번호");
		JLabel nameLabel = new JLabel(); // 약국정보 라벨 이름
		JLabel adressLabel = new JLabel(); // 약국정보 라벨 주소
		JLabel pNumLabel = new JLabel(); // 약국정보 라벨 전번
		JLabel maskLabel = new JLabel("마스크 현황");
		JLabel maskLabel2 = new JLabel(" ");
		JLabel KF94Label = new JLabel("KF94");
		JLabel KF94Label_num = new JLabel();
		JLabel KF80Label = new JLabel("KF80");
		JLabel KF80Label_num = new JLabel();
		JLabel dentalLabel = new JLabel("일반마스크");
		JLabel dentalLabel_num = new JLabel();

		JButton btn = new JButton("예약 진행");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				replace(userinfoView());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});
		JButton btn2 = new JButton("이전으로");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				replace(mainPanel());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});

		titleLabel1.setOpaque(true);
		titleLabel1.setForeground(Color.white);
		titleLabel1.setHorizontalAlignment(JLabel.CENTER);
		titleLabel1.setFont(storef1);
		titleLabel1.setBackground(new Color(82, 204, 250)); // 배경색
		titleLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 11));// 글씨체
		titleLabel1.setFont(titleLabel1.getFont().deriveFont(50.0f));// 글씨크기
		nameLabel_t.setFont(storef3);
		nameLabel_t.setHorizontalAlignment(JLabel.CENTER);
		adressLabel_t.setFont(storef3);
		adressLabel_t.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setFont(storef3);
		adressLabel.setHorizontalAlignment(JLabel.CENTER);
		adressLabel.setFont(storef3);
		maskLabel.setFont(storef2);
		maskLabel.setHorizontalAlignment(JLabel.CENTER);
		maskLabel.setForeground(Color.blue);// 글씨색깔
		pNumLabel.setHorizontalAlignment(JLabel.CENTER);
		pNumLabel.setFont(storef3);
		KF94Label.setHorizontalAlignment(JLabel.CENTER);
		KF94Label.setFont(storef3);
		KF94Label_num.setHorizontalAlignment(JLabel.CENTER);
		KF94Label_num.setFont(storef3);
		KF80Label.setHorizontalAlignment(JLabel.CENTER);
		KF80Label.setFont(storef3);
		KF80Label_num.setHorizontalAlignment(JLabel.CENTER);
		KF80Label_num.setFont(storef3);
		dentalLabel.setHorizontalAlignment(JLabel.CENTER);
		dentalLabel.setFont(storef3);
		dentalLabel_num.setHorizontalAlignment(JLabel.CENTER);
		dentalLabel_num.setFont(storef3);

		String name = mc.getStoreList().get(indexnum).getStoreName().toString() + "의 정보";
		String adress = mc.getStoreList().get(indexnum).getAddress().toString();
		String pNumber = mc.getStoreList().get(indexnum).getPhoneNumber().toString();

		String KF94 = ((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(0)).getMaskNum() + "개";
		String KF80 = ((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(1)).getMaskNum() + "개";
		String dental = ((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(2)).getMaskNum() + "개";

		titleLabel1.setText(name);
		Panel1.add(titleLabel1);

		adressLabel.setText(adress);
		pNumLabel.setText(pNumber);

		Panel2_drug.add(nameLabel_t);
		Panel2_drug.add(adressLabel);
		Panel2_drug.add(adressLabel_t);
		Panel2_drug.add(pNumLabel);

		Panel2_mask_t.add(maskLabel2);
		Panel2_mask_t.add(maskLabel, "South");

		KF94Label_num.setText(KF94);
		KF80Label_num.setText(KF80);
		dentalLabel_num.setText(dental);

		Panel2_mask.add(KF94Label);
		Panel2_mask.add(KF94Label_num);
		Panel2_mask.add(KF80Label);
		Panel2_mask.add(KF80Label_num);
		Panel2_mask.add(dentalLabel);
		Panel2_mask.add(dentalLabel_num);

		Panel2_info.add(Panel2_drug, "North");
		Panel2_info.add(Panel2_mask_t, "Center");
		Panel2_info.add(Panel2_mask, "South");

		Panel3_btn.add(btn2);
		Panel3_btn.add(btn);
		Panel3_btn.setLayout(new FlowLayout(FlowLayout.RIGHT));

		storeinforViewPanel.add(Panel1, "North");
		storeinforViewPanel.add(Panel2_info, "Center");
		storeinforViewPanel.add(Panel3_btn, "South");

		return storeinforViewPanel;
	}

	// 유저 정보를 입력하는 UI 이다.
	public JPanel userinfoView() {

		JPanel userinfoViewPanel = new JPanel();
		userinfoViewPanel = new JPanel();
		userinfoViewPanel.setLayout(new BorderLayout());
		userinfoViewPanel.setBackground(Color.WHITE);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(82, 204, 250));
		panel1.setSize(1280, 150);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
//		panel2.setLayout(new GridLayout(2,2));
		panel2.setSize(1280, 420);

		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		panel3.setSize(1280, 150);

		Dialog warnning = new Dialog(mf, "경고");
		JLabel msg = new JLabel("입력방법이 틀립니다.");
		JButton exitButton = new JButton("확인");
		warnning.setBounds(300, 200, 400, 200);
		;
		warnning.setLayout(new GridLayout(2, 1));
		msg.setHorizontalAlignment(JLabel.CENTER);
		warnning.add(msg);
		warnning.add(exitButton);

		JTextField id = new JTextField(14);
		JPanel panel4 = new JPanel();
		JTextField ps1 = new JTextField(14);
		JPasswordField ps2 = new JPasswordField(14);
		panel4.add(ps1);
		panel4.add(new JLabel("-"));
		panel4.add(ps2);

		ps1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JFormattedTextField) ke.getSource()).getText().length() > 7) {
					ke.consume();
				}
			}
		});

		ps1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				strcount += 1;
				if (strcount == 6) {
					ps2.requestFocus();
				}
			}
		});
		ps2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == ps1) {
					ps2.requestFocus();
				}

				textstr1 = id.getText();
				textstr2 = ps1.getText() + ps2.getText();

				if (ps1.getText().length() < 6) {
					msg.setText("주민번호 앞자리가 6자리보다 짧습니다.");
					warnning.setVisible(true);
					ps1.setText("");
				} else if (ps1.getText().length() > 6) {
					msg.setText("주민번호 앞자리가 6자리보다 깁니다.");
					warnning.setVisible(true);
					ps1.setText("");
				} else if (ps2.getText().length() < 7) {
					msg.setText("주민번호 뒷자리가 7자리보다 짧습니다.");
					warnning.setVisible(true);
					ps2.setText("");
				} else if (ps2.getText().length() > 7) {
					msg.setText("주민번호 뒷자리가 7자리보다 깁니다.");
					warnning.setVisible(true);
					ps2.setText("");
				} else if (id.getText().length() < 2) {
					msg.setText("이름이 너무 짧습니다.");
					warnning.setVisible(true);
					id.setText("");
				} else if (id.getText().length() > 10) {
					msg.setText("이름이 너무 깁니다.");
					warnning.setVisible(true);
					id.setText("");
				} else if (id.getText().equals("") || ps1.getText().equals("") || ps2.getText().equals("")) {
					msg.setText("아무것도 적혀 있지 않습니다.");
					warnning.setVisible(true);
					id.setText("");
					ps1.setText("");
					ps2.setText("");
				} else {
					System.out.println("이름: " + textstr1 + ", 주민번호: " + textstr2);
					usercheck(textstr1, textstr2);
				}
			}
		});

		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				warnning.dispose();
			}
		});

		JButton btn = new JButton("예약하기");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textstr1 = id.getText();
				textstr2 = ps1.getText() + ps2.getText();

				if (ps1.getText().length() < 6) {
					msg.setText("주민번호 앞자리가 6자리보다 짧습니다.");
					warnning.setVisible(true);
					ps1.setText("");
				} else if (ps1.getText().length() > 6) {
					msg.setText("주민번호 앞자리가 6자리보다 깁니다.");
					warnning.setVisible(true);
					ps1.setText("");
				} else if (ps2.getText().length() < 7) {
					msg.setText("주민번호 뒷자리가 7자리보다 짧습니다.");
					warnning.setVisible(true);
					ps2.setText("");
				} else if (ps2.getText().length() > 7) {
					msg.setText("주민번호 뒷자리가 7자리보다 깁니다.");
					warnning.setVisible(true);
					ps2.setText("");
				} else if (id.getText().length() < 2) {
					msg.setText("이름이 너무 짧습니다.");
					warnning.setVisible(true);
					id.setText("");
				} else if (id.getText().length() > 10) {
					msg.setText("이름이 너무 깁니다.");
					warnning.setVisible(true);
					id.setText("");
				} else if (id.getText().equals("") || ps1.getText().equals("") || ps2.getText().equals("")) {
					msg.setText("아무것도 적혀 있지 않습니다.");
					warnning.setVisible(true);
					id.setText("");
					ps1.setText("");
					ps2.setText("");
				} else {
					System.out.println("이름: " + textstr1 + ", 주민번호: " + textstr2);
					usercheck(textstr1, textstr2);
				}
			}
		});

		JLabel lb1 = new JLabel(mc.getStoreList().get(indexnum).getStoreName().toString() + "의 예약시스템에 접속하셨습니다. ");
		lb1.setLocation(290, 10);
		lb1.setSize(700, 150);
		lb1.setForeground(Color.WHITE);
		lb1.setFont(lb1.getFont().deriveFont(30.0f));

		panel1.add(lb1);
		panel2.add(new JLabel("이름"));
		panel2.add(id);
		panel2.add(new JLabel("주민번호"));
		panel2.add(panel4);
		panel3.add(btn);

		userinfoViewPanel.add(panel1, BorderLayout.NORTH);
		userinfoViewPanel.add(panel2, BorderLayout.CENTER);
		userinfoViewPanel.add(panel3, BorderLayout.SOUTH);

		return userinfoViewPanel;
	}

	// 유저 예약 가능 여부 판단하는 메소드
	public void usercheck(String name, String num) {

		int check = mc.usercheck(name, num);

		if (check == 0) {
			System.out.println("예약 불가능1");
			replace(NoSell1());
			mf.pack();
			mf.setVisible(true);
			mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else if (check == 1) {
			System.out.println("예약을 진행합니다.");
			replace(Sell());
			mf.pack();
			mf.setVisible(true);
			mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else if (check == 2) {
			System.out.println("예약 불가능2");
			replace(NoSell2());
			mf.pack();
			mf.setVisible(true);
			mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	}

	// 필드번수 => 각각의 마스크 수량을 가져온다.
	private int num1, num2, num3;

	// 살 마스크 개수를 설정하는 UI
	public JPanel Sell() {

		JPanel SellPanel = new JPanel();
		Font f1 = new Font("궁서", Font.BOLD, 50);
		Font f2 = new Font("굴림", Font.BOLD, 25);

		SellPanel.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		JLabel label1 = new JLabel(mc.getStoreList().get(indexnum).getStoreName().toString() + "의 예약진행");
		label1.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		label1.setFont(label1.getFont().deriveFont(50.0f));
		label1.setForeground(Color.white);
		label1.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(label1);
		panel1.setBackground(new Color(82, 204, 250));

		panel2.setLayout(new GridLayout(3, 3));
		panel2.setBackground(Color.white);
		JLabel label2 = new JLabel(" KF94          ");
		label2.setFont(f2);
		JLabel label3 = new JLabel(" 1500원   ");
		label3.setFont(f2);
		JLabel label4 = new JLabel(" KF80          ");
		label4.setFont(f2);
		JLabel label5 = new JLabel(" 1000원   ");
		label5.setFont(f2);
		JLabel label6 = new JLabel(" 일반마스크            ");
		label6.setFont(f2);
		JLabel label7 = new JLabel("  500원 	");
		label7.setFont(f2);
		JTextField text1 = new JTextField(
				((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(0)).getMaskNum() + "개 남아있습니다.", 10);
		JTextField text2 = new JTextField(
				((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(1)).getMaskNum() + "개 남아있습니다.", 10);
		JTextField text3 = new JTextField(
				((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(2)).getMaskNum() + "개 남아있습니다.", 10);

		// TextField에 관한 Key Event
		if (((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(0)).getMaskNum() == 0) {
			text1.setEditable(false);
			text1.setText("0");
			num1 = 0;
		} else {
			text1.setFocusTraversalKeysEnabled(false);
			text1.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == e.VK_TAB) {
						text2.requestFocus();
						text2.setText("");
					}

				}
			});
			text1.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					text1.setText("");
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					text1.setText("");

				}
			});
		}

		if (((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(1)).getMaskNum() == 0) {
			text2.setEditable(false);
			text2.setText("0");
			num2 = 0;
		} else {
			text2.setFocusTraversalKeysEnabled(false);
			text2.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(java.awt.event.KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == e.VK_TAB) {
						text3.requestFocus();
						text3.setText("");
					}

				}
			});
			text2.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					text2.setText("");
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					text2.setText("");

				}
			});
		}

		if (((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(2)).getMaskNum() == 0) {

			text3.setEditable(false);
			text3.setText("0");
			num3 = 0;
		} else {
			text3.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					text3.setText("");

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					text3.setText("");

				}
			});
		}

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

				num1 = Integer.parseInt(text1.getText());
				num2 = Integer.parseInt(text2.getText());
				num3 = Integer.parseInt(text3.getText());
				if (num1 == 0 && num2 == 0 && num3 == 0) {
					replace(mainPanel());
					mf.pack();
					mf.setVisible(true);
					mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else if (num1 > ((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(0)).getMaskNum()) {
					JFrame warningf = new JFrame();
					Dialog warning = new Dialog(warningf, "안내");
					warning.setBounds(300, 200, 500, 200);
					;
					warning.setLayout(new GridLayout(2, 1));
					JLabel warninglabel1 = new JLabel("원하시는 KF90 수량이 부족합니다.");
					warninglabel1.setFont(f3);
					warninglabel1.setHorizontalAlignment(JLabel.CENTER);
					JButton checkmemo = new JButton("확인");
					warning.setVisible(true);
					checkmemo.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							warning.dispose();
						}
					});
					warning.add(warninglabel1);
					warning.add(checkmemo);

				} else if (num2 > ((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(1)).getMaskNum()) {
					JFrame warningf = new JFrame();
					Dialog warning = new Dialog(warningf, "안내");
					warning.setBounds(300, 200, 500, 200);
					;
					warning.setLayout(new GridLayout(2, 1));
					JLabel warninglabel1 = new JLabel("원하시는 KF80 수량이 부족합니다.");
					warninglabel1.setFont(f3);
					warninglabel1.setHorizontalAlignment(JLabel.CENTER);
					warning.setVisible(true);
					JButton checkmemo = new JButton("확인");
					checkmemo.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							warning.dispose();
						}
					});
					warning.add(warninglabel1);
					warning.add(checkmemo);
				} else if (num3 > ((Maskinfo) mc.getStoreList().get(indexnum).getMaskinfo().get(2)).getMaskNum()) {
					JFrame warningf = new JFrame();
					Dialog warning = new Dialog(warningf, "안내");
					warning.setBounds(300, 200, 500, 200);
					;
					warning.setLayout(new GridLayout(2, 1));
					JLabel warninglabel1 = new JLabel("원하시는 일반마스크 수량이 부족합니다.");
					warninglabel1.setFont(f3);
					warninglabel1.setHorizontalAlignment(JLabel.CENTER);
					warning.setVisible(true);
					JButton checkmemo = new JButton("확인");
					checkmemo.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							warning.dispose();
						}
					});
					warning.add(warninglabel1);
					warning.add(checkmemo);
				} else {
					JFrame checkmf = new JFrame();
					Dialog checknum = new Dialog(checkmf, "수량 확인");
					checknum.setBounds(700, 250, 500, 500);
					checknum.setLayout(new BorderLayout());

					JPanel checkPanel1 = new JPanel();
					JLabel checkLabel1 = new JLabel("입력하신 수량이 맞습니까?");
					checkLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 11));
					checkLabel1.setFont(checkLabel1.getFont().deriveFont(30.0f));
					checkPanel1.setBackground(Color.white);
					checkPanel1.add(checkLabel1);

					Font f2 = new Font("굴림", Font.BOLD, 25);

					JPanel checkPanel2 = new JPanel(new GridLayout(3, 2));
					JLabel checkLabel2 = new JLabel("       KF94");
					checkLabel2.setHorizontalAlignment(JLabel.LEFT);
					JLabel checkLabel3 = new JLabel(num1 + "개          ");
					checkLabel3.setHorizontalAlignment(JLabel.RIGHT);
					JLabel checkLabel4 = new JLabel("       KF80");
					checkLabel4.setHorizontalAlignment(JLabel.LEFT);
					JLabel checkLabel5 = new JLabel(num2 + "개          ");
					checkLabel5.setHorizontalAlignment(JLabel.RIGHT);
					JLabel checkLabel6 = new JLabel("       일반마스크");
					checkLabel6.setHorizontalAlignment(JLabel.LEFT);
					JLabel checkLabel7 = new JLabel(num3 + "개          ");
					checkLabel7.setHorizontalAlignment(JLabel.RIGHT);
					checkLabel2.setFont(f2);
					checkLabel3.setFont(f2);
					checkLabel4.setFont(f2);
					checkLabel5.setFont(f2);
					checkLabel6.setFont(f2);
					checkLabel7.setFont(f2);
					checkPanel2.add(checkLabel2);
					checkPanel2.add(checkLabel3);
					checkPanel2.add(checkLabel4);
					checkPanel2.add(checkLabel5);
					checkPanel2.add(checkLabel6);
					checkPanel2.add(checkLabel7);
					checkPanel2.setBackground(Color.white);

					JPanel checkPanel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
					JButton checkButton1 = new JButton("네");
					JButton checkButton2 = new JButton("아니요");
					checkButton1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							maskinfo(indexnum, num1, num2, num3);

							replace(reserveinfo());
							mf.pack();
							mf.setVisible(true);
							mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							checknum.dispose();

						}
					});
					checkButton2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							replace(Sell());
							mf.pack();
							mf.setVisible(true);
							mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							checknum.dispose();
						}
					});
					checkPanel3.add(checkButton1);
					checkPanel3.add(checkButton2);
					checkPanel3.setBackground(Color.white);

					checknum.add(checkPanel1, "North");
					checknum.add(checkPanel2, "Center");
					checknum.add(checkPanel3, "South");
					checknum.setVisible(true);

				}

			}
		});
		panel3.add(button);

		SellPanel.add(panel1, "North");
		SellPanel.add(panel2, "Center");
		SellPanel.add(panel3, "South");

		return SellPanel;
	}

	// 예약 불가능 메소드1
	public JPanel NoSell1() {

		Font f1 = new Font("궁서", Font.BOLD, 30);

		JPanel NoSell1Panel = new JPanel();
		NoSell1Panel.setLayout(new BorderLayout());

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		panel1.setBackground(Color.blue);
		panel1.setLayout(new BorderLayout());
		panel1.setBorder(new LineBorder(Color.white, 50));

		JLabel label1 = new JLabel("예약 불가능!!");
		label1.setForeground(Color.white);
		label1.setFont(f1);
		JLabel label2 = new JLabel("마스크 예약 내역이 존재합니다.");
		label2.setForeground(Color.white);
		label2.setFont(f1);
		label2.setHorizontalAlignment(JLabel.CENTER);

		panel1.add(label1, "North");
		panel1.add(label2, "Center");

		Dialog accept = new Dialog(mf, "안내");
		accept.setBounds(300, 200, 300, 200);
		;
		accept.setLayout(new GridLayout(1, 2));
		JButton goToMain = new JButton("처음으로");
		JButton exit = new JButton("종료");
		accept.add(goToMain);
		accept.add(exit);
		goToMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				replace(mainPanel());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				accept.dispose();
			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JButton button = new JButton("확인");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				accept.setVisible(true);
			}
		});

		panel2.add(button);
		panel2.setBackground(Color.white);

		NoSell1Panel.add(panel1, "Center");
		NoSell1Panel.add(panel2, "South");

		return NoSell1Panel;
	}

	// 예약 불가능 메소드2
	public JPanel NoSell2() {

		JPanel NoSell2Panel = new JPanel();
		NoSell2Panel.setLayout(new BorderLayout());

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel(); // 중간 출력

		panel1.setBackground(new Color(82, 204, 250));
		panel1.setLayout(new BorderLayout());

		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JLabel label1 = new JLabel("예약이 불가능 합니다.!");
		label1.setForeground(Color.white);
		label1.setFont(f1);
		JLabel label2 = new JLabel("아래 공지를 확인해주세요.");
		label2.setForeground(Color.white);
		label2.setFont(f1);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);

		panel1.add(label1, "North");
		panel1.add(label2, "Center");
		panel1.setBorder(new LineBorder(Color.white, 30));

		Image icon = new ImageIcon("image/NoSellImage.PNG").getImage().getScaledInstance(400, 400, 0);
		JLabel label3 = new JLabel(new ImageIcon(icon));
		label3.setHorizontalAlignment(JLabel.CENTER);
		panel3.add(label3);

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

		NoSell2Panel.add(panel1, "North");
		NoSell2Panel.add(panel3, "Center");
		NoSell2Panel.add(panel2, "South");

		return NoSell2Panel;
	}

	// 마스크 수량 체크하는 메소드
	public void maskinfo(int indexnum, int num1, int num2, int num3) {
		mc.maskinfo(indexnum, num1, num2, num3);

	}

	// 예약 내역 출력하는 UI
	private static Dialog choice;

	public JPanel reserveinfo() {

		JPanel reserveinfoPanel = new JPanel();
		reserveinfoPanel.setLayout(new BorderLayout());

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JPanel topicPanel = new JPanel();
		JLabel topic = new JLabel("예약 내역");
		topicPanel.setBackground(new Color(82, 204, 250));
		topicPanel.setLocation(0, 0);
		topic.setForeground(Color.WHITE);
		topic.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		topic.setFont(topic.getFont().deriveFont(50.0f));

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(3, 2));
		JLabel kf94Mask = new JLabel("          KF94");
		JLabel kf94MaskNum = new JLabel("수량  " + num1 + "개          ");
		JLabel kf80Mask = new JLabel("          KF80");
		JLabel kf80MaskNum = new JLabel("수량  " + num2 + "개          ");
		JLabel commonMask = new JLabel("          일반 마스크");
		JLabel commonMaskNum = new JLabel("수량  " + num3 + "개          ");

		contentPanel.setBackground(Color.WHITE);
		kf94Mask.setFont(kf94Mask.getFont().deriveFont(35.0f));
		kf94Mask.setHorizontalAlignment(JLabel.LEFT);
		kf94MaskNum.setFont(kf94Mask.getFont().deriveFont(35.0f));
		kf94MaskNum.setHorizontalAlignment(JLabel.RIGHT);
		kf80Mask.setFont(kf80Mask.getFont().deriveFont(35.0f));
		kf80Mask.setHorizontalAlignment(JLabel.LEFT);
		kf80MaskNum.setFont(kf80Mask.getFont().deriveFont(35.0f));
		kf80MaskNum.setHorizontalAlignment(JLabel.RIGHT);
		commonMask.setFont(commonMask.getFont().deriveFont(35.0f));
		commonMask.setHorizontalAlignment(JLabel.LEFT);
		commonMaskNum.setFont(commonMask.getFont().deriveFont(35.0f));
		commonMaskNum.setHorizontalAlignment(JLabel.RIGHT);

		JPanel resultPanel = new JPanel();
		JLabel result = new JLabel(mc.getStoreList().get(indexnum).getStoreName().toString() + "의 예약 완료!");
		JButton nextButton = new JButton("확인");
		resultPanel.setBackground(Color.WHITE);
		result.setForeground(Color.BLACK);
		result.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		result.setFont(result.getFont().deriveFont(50.0f));
		nextButton.setFont(nextButton.getFont().deriveFont(50.0f));
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				choice.setVisible(true);
				mc.dataSave(textstr1, textstr2, mc.getStoreList().get(indexnum).getStoreName().toString(),
						Integer.toString(num1), Integer.toString(num2), Integer.toString(num3));
			}
		});
		choice = new Dialog(mf, "안내");
		choice.setBounds(300, 200, 300, 200);
		;
		choice.setLayout(new GridLayout(1, 2));
		JButton goToMain = new JButton("처음으로");
		JButton exit = new JButton("종료");
		choice.add(goToMain);
		choice.add(exit);
		goToMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				replace(mainPanel());
				mf.pack();
				mf.setVisible(true);
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				choice.dispose();
			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		topicPanel.add(topic);

		contentPanel.add(kf94Mask);
		contentPanel.add(kf94MaskNum);
		contentPanel.add(kf80Mask);
		contentPanel.add(kf80MaskNum);
		contentPanel.add(commonMask);
		contentPanel.add(commonMaskNum);
		contentPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));

		resultPanel.add(result);
		resultPanel.add(nextButton);

		mainPanel.add(topicPanel, "North");
		mainPanel.add(contentPanel, "Center");
		mainPanel.add(resultPanel, "South");

		reserveinfoPanel.add(mainPanel);

		return reserveinfoPanel;
	}

}
