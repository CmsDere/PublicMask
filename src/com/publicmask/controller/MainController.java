package com.publicmask.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.publicmask.model.AdminUserinfo;
import com.publicmask.model.BuyerList;
import com.publicmask.model.Drugstoreinfo;
import com.publicmask.model.Maskinfo;
import com.publicmask.model.Personinfo;
import com.publicmask.view.MainView;

import sun.swing.MenuItemCheckIconFactory;
import sun.util.logging.resources.logging;

public class MainController {

	private ArrayList<Drugstoreinfo> storeList = new ArrayList<>();
	private ArrayList<Personinfo> personList = new ArrayList<>();
	private MainView mv;
	private ArrayList<AdminUserinfo> adminList = new ArrayList<>();
	private ArrayList<BuyerList> buyerList = new ArrayList<BuyerList>();

	Scanner sc = new Scanner(System.in);
	private int count = 0;
	private int select = 0;

	public MainController() {
		adminList.add(new AdminUserinfo("admin", "123"));
	}

	// 약국 목록 추가(수동)
	public ArrayList storeview() {

		if (count == 0) {
			ArrayList<Maskinfo> maskList = new ArrayList<>();
			maskList.add(new Maskinfo("KF94", 100));
			maskList.add(new Maskinfo("KF80", 80));
			maskList.add(new Maskinfo("일반마스크", 40));
			storeList.add(new Drugstoreinfo("하나약국", "서울시 서초구 양재1동", "02-1234-1211", maskList));
			maskList = new ArrayList<Maskinfo>();
			maskList.add(new Maskinfo("KF94", 70));
			maskList.add(new Maskinfo("KF80", 100));
			maskList.add(new Maskinfo("일반마스크", 30));
			storeList.add(new Drugstoreinfo("둘약국", "서울시 서초구 양재2동", "02-1234-1222", maskList));
			count++;
		}

		return storeList;

	}

	// getter & setter
	public ArrayList<Drugstoreinfo> getStoreList() {
		return storeList;
	}

	public void setStoreList(ArrayList<Drugstoreinfo> storeList) {
		this.storeList = storeList;
	}

	// 유저 데이터와 날짜 비교 메소드
	private int usercount = 0;

	public int usercheck(String name, String num) {

		int check = 1;
		int today = new Date().getDay();
		System.out.println("오늘 요일은 " + today);
		personList.add(new Personinfo(name, num));
		try {
			BufferedReader br = new BufferedReader(new FileReader("logs/data.txt"));
			String string;
			while ((string = br.readLine()) != null) {
				String[] strArr = string.split(", ");
				System.out.println(strArr[0] + ", " + strArr[1]);
				if (strArr[0].equals(personList.get(usercount).getUserName())
						&& strArr[1].equals(personList.get(usercount).getUserNumber())) {
					check = 0;
					usercount++;
					return check;
				} else {
					if (Integer.parseInt((personList.get(usercount).getUserNumber().substring(1, 2))) == today) {
						check = 1;
						System.out.println("유저의 생년월일:" + personList.get(usercount).getUserNumber().substring(1, 2));

					} else {
						check = 2;
						System.out.println("유저의 생년월일:" + personList.get(usercount).getUserNumber().substring(1, 2));
						System.out.println("오늘은 구매 불가능합니다.");

					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		usercount++;
		return check;
	}

	// 마스크 수량 체크 메소드
	public void maskinfo(int indexnum, int num1, int num2, int num3) {
		select = indexnum;
		((Maskinfo) storeList.get(select).getMaskinfo().get(0))
				.setMaskNum(((Maskinfo) storeList.get(select).getMaskinfo().get(0)).getMaskNum() - num1);
		((Maskinfo) storeList.get(select).getMaskinfo().get(1))
				.setMaskNum(((Maskinfo) storeList.get(select).getMaskinfo().get(1)).getMaskNum() - num2);
		((Maskinfo) storeList.get(select).getMaskinfo().get(2))
				.setMaskNum(((Maskinfo) storeList.get(select).getMaskinfo().get(2)).getMaskNum() - num3);

	}

	// 예약 정보를 텍스트파일로 저장
	public void dataSave(String name, String password, String store, String num1, String num2, String num3) {
		String changeLine = System.getProperty("line.separator");
		String log = name + ", " + password + ", " + store + ", " + num1 + ", " + num2 + ", " + num3 + changeLine;
		File file = new File("logs/data.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, true);
			writer.write(log);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void storeDataSave(String name, String address, String phone, int kf94, int kf80, int common) {
		String changeLine = System.getProperty("line.separator");
		String storeData = name + ", " + address + ", " + phone + ", " + kf94 + ", " + kf80 + ", " + common
				+ changeLine;
		File file = new File("logs/storeData.txt");
		FileWriter writer = null;

		try {
			writer = new FileWriter(file, true);
			writer.write(storeData);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean adminCheck(String ID, String password) {

		boolean check = false;

		for (int i = 0; i < adminList.size(); i++) {
			if (ID.equals(adminList.get(i).getUserID()) && password.equals(adminList.get(i).getUserPassword())) {
				System.out.println("로그인 되었습니다.");
				check = true;
				return check;
			}
		}

		return check;
	}

	public ArrayList viewPerson() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("logs/data.txt"));
			String string;
			try {
				while ((string = in.readLine()) != null) {
					String[] strArr = string.split(", ");
					viewPersonData(strArr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return buyerList;
	}

	// buyerList에 값 넣는 메소드
	public void viewPersonData(String[] strArr) {
		BuyerList b = new BuyerList();
		b.setPname(strArr[0]);
		b.setPnum(strArr[1]);
		b.setStorename(strArr[2]);
		buyerList.add(b);
	}

	// getter&setter
	public ArrayList<BuyerList> getbuyerList() {
		return buyerList;
	}

	public void setbuyerList(ArrayList<BuyerList> buyerList) {
		this.buyerList = buyerList;
	}
}
