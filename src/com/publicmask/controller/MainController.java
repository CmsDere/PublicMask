package com.publicmask.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.publicmask.model.Drugstoreinfo;
import com.publicmask.model.Maskinfo;
import com.publicmask.model.Personinfo;

public class MainController {

	private ArrayList<Drugstoreinfo> storeList = new ArrayList<>();
	private ArrayList<Maskinfo> maskList = new ArrayList<>();
	private ArrayList<Personinfo> personList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	
	
	public void searchstore1() {
		
		storeList.add(new Drugstoreinfo("하나약국","서울시 서초구 양재1동","02-1234-1234",100));
		System.out.println(storeList.get(0).toString());
		
		maskList.add(new Maskinfo("KF94",100));
		maskList.add(new Maskinfo("KF80",80));
		maskList.add(new Maskinfo("일반마스크",2));
		
		for(int i = 0; i<maskList.size();i++) {
			System.out.println(maskList.get(i).toString());
		}
		

	}
	public void maskinfo(int num1, int num2, int num3) {
		
		maskList.get(0).setMaskNum(maskList.get(0).getMaskNum()-num1);
		maskList.get(1).setMaskNum(maskList.get(1).getMaskNum()-num2);
		maskList.get(2).setMaskNum(maskList.get(2).getMaskNum()-num3);



		System.out.println("*****예약 내역*****");
		System.out.println(maskList.get(0).getMaskname() + " 수량: "+num1+"개");
		System.out.println(maskList.get(1).getMaskname() + " 수량: "+num2+"개");
		System.out.println(maskList.get(2).getMaskname() + " 수량: "+num3+"개");
		System.out.println("--------------------------------------------");
		System.out.println("예약 완료 하였습니다.");
		
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


	
	
}






















