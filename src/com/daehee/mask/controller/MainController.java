package com.daehee.mask.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.daehee.mask.model.Drugstoreinfo;
import com.daehee.mask.model.Maskinfo;
import com.daehee.mask.model.Personinfo;
public class MainController {

	private ArrayList<Drugstoreinfo> storeList = new ArrayList<>();
	private ArrayList<Personinfo> personList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	private int count=0;
	private int select=0;
	
	public ArrayList storeview() {
		
		if(count==0) {
			ArrayList<Maskinfo> maskList = new ArrayList<>();
			maskList.add(new Maskinfo("KF94",100));
			maskList.add(new Maskinfo("KF80",80));
			maskList.add(new Maskinfo("일반마스크",40));
			storeList.add(new Drugstoreinfo("하나약국","서울시 서초구 양재1동","02-1234-1211",maskList));
			maskList = new ArrayList<>();
			maskList.add(new Maskinfo("KF94",70));
			maskList.add(new Maskinfo("KF80",100));
			maskList.add(new Maskinfo("일반마스크",30));
			storeList.add(new Drugstoreinfo("둘약국","서울시 서초구 양재2동","02-1234-1222",maskList));
			count++;
		}

		
		return storeList;
		
	}
	
	public ArrayList<Drugstoreinfo> getStoreList() {
		return storeList;
	}

	public void setStoreList(ArrayList<Drugstoreinfo> storeList) {
		this.storeList = storeList;
	}
	
	public boolean usercheck(String name, String num) {
		
		boolean check ;
		personList.add(new Personinfo(name,num));
	
		int today = new Date().getDay();
		System.out.println("오늘 요일은 "+today);
		
		if(Integer.parseInt((personList.get(0).getUserNumber().substring(1, 2)))==today) {
			check = true;
			System.out.println("유저의 생년월일:"+personList.get(0).getUserNumber().substring(1, 2));
			return check;
		}else {
			check = false;
			System.out.println("유저의 생년월일:"+personList.get(0).getUserNumber().substring(1, 2));
			System.out.println("오늘은 구매 불가능합니다.");
			return check;
		}
		
	}
	
	
	public void maskinfo(int num1, int num2, int num3) {
		
		
		((Maskinfo)storeList.get(select).getMaskinfo().get(0)).setMaskNum(((Maskinfo)storeList.get(select).getMaskinfo().get(0)).getMaskNum()-num1);
		((Maskinfo)storeList.get(select).getMaskinfo().get(1)).setMaskNum(((Maskinfo)storeList.get(select).getMaskinfo().get(1)).getMaskNum()-num2);
		((Maskinfo)storeList.get(select).getMaskinfo().get(2)).setMaskNum(((Maskinfo)storeList.get(select).getMaskinfo().get(2)).getMaskNum()-num3);



//		System.out.println("*****예약 내역*****");
//		System.out.println(((Maskinfo)storeList.get(select).getMaskinfo().get(0)).getMaskname() + " 수량: "+num1+"개");
//		System.out.println(((Maskinfo)storeList.get(select).getMaskinfo().get(1)).getMaskname() + " 수량: "+num2+"개");
//		System.out.println(((Maskinfo)storeList.get(select).getMaskinfo().get(2)).getMaskname() + " 수량: "+num3+"개");
//		System.out.println("--------------------------------------------");
//		System.out.println("예약 완료 하였습니다.");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//=========================================================================================================================	
	
	
	
	public void searchstore(int num) {
		
		select=num-1;
		System.out.println(storeList.get(num-1).toString());
		
		for(int j=0;j<storeList.get(num-1).getMaskinfo().size();j++) {
			System.out.println(storeList.get(num-1).getStoreName()+" => "+storeList.get(num-1).getMaskinfo().get(j));
		}
		
		

	}
	


	
	


	
	
}






















