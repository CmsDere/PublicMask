package com.publicmask.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import com.publicmask.model.Drugstoreinfo;
import com.publicmask.model.Maskinfo;
import com.publicmask.model.Personinfo;
import com.publicmask.view.MainView;

public class MainController {

	private ArrayList<Drugstoreinfo> storeList = new ArrayList<>();
	private ArrayList<Personinfo> personList = new ArrayList<>();
	private MainView mv;
	
	Scanner sc = new Scanner(System.in);
	private int count=0;
	private int select=0;
	
	
	//약국 목록 추가(수동)
	public ArrayList storeview() {
		
		
		if(count==0) {
			ArrayList<Maskinfo> maskList = new ArrayList<>();
			maskList.add(new Maskinfo("KF94",100));
			maskList.add(new Maskinfo("KF80",80));
			maskList.add(new Maskinfo("일반마스크",40));
			storeList.add(new Drugstoreinfo("하나약국","서울시 서초구 양재1동","02-1234-1211",maskList));
			maskList = new ArrayList<Maskinfo>();
			maskList.add(new Maskinfo("KF94",70));
			maskList.add(new Maskinfo("KF80",100));
			maskList.add(new Maskinfo("일반마스크",30));
			storeList.add(new Drugstoreinfo("둘약국","서울시 서초구 양재2동","02-1234-1222",maskList));
			count++;
		}

		
		return storeList;
		
	}
	
	//getter & setter
	public ArrayList<Drugstoreinfo> getStoreList() {
		return storeList;
	}
	public void setStoreList(ArrayList<Drugstoreinfo> storeList) {
		this.storeList = storeList;
	}
	
	
	//유저 데이터와 날짜 비교 메소드
	private int usercount=0;
	public int usercheck(String name, String num) {
		
		int check = 0 ;
		personList.add(new Personinfo(name,num));
		Properties prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("logs/data.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		int today = new Date().getDay();
		System.out.println("오늘 요일은 "+today);
		
		if (prop.getProperty("name").equals(personList.get(usercount).getUserName()) && 
				prop.getProperty("password").equals(personList.get(usercount).getUserNumber())) {
			check = 0;
			usercount++;
		}
		else {
			if(Integer.parseInt((personList.get(usercount).getUserNumber().substring(1, 2)))==today) {
				check = 1;
				System.out.println("유저의 생년월일:"+personList.get(usercount).getUserNumber().substring(1, 2));
				usercount++;
			}
			else {
				check = 2;
				System.out.println("유저의 생년월일:"+personList.get(usercount).getUserNumber().substring(1, 2));
				System.out.println("오늘은 구매 불가능합니다.");
				usercount++;
			}
		}
		return check;
	}
	
	
	//마스크 수량 체크 메소드
	public void maskinfo(int indexnum, int num1, int num2, int num3) {
		select = indexnum;
		((Maskinfo)storeList.get(select).getMaskinfo().get(0)).setMaskNum(((Maskinfo)storeList.get(select).getMaskinfo().get(0)).getMaskNum()-num1);
		((Maskinfo)storeList.get(select).getMaskinfo().get(1)).setMaskNum(((Maskinfo)storeList.get(select).getMaskinfo().get(1)).getMaskNum()-num2);
		((Maskinfo)storeList.get(select).getMaskinfo().get(2)).setMaskNum(((Maskinfo)storeList.get(select).getMaskinfo().get(2)).getMaskNum()-num3);
	
	}
	
	public void dataSave(String name, String password, String store, String num1, String num2, String num3) {
		Properties prop = new Properties();
		prop.setProperty("name", name);
		prop.setProperty("password", password);
		prop.setProperty("Drugstore Name", store);
		prop.setProperty("KF94", num1);
		prop.setProperty("KF80", num2);
		prop.setProperty("Common", num3);
		
		try {
			prop.storeToXML(new FileOutputStream("logs/data.xml", true), "Reservation System");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}






















