package com.publicmask.view;

import java.util.Scanner;

import com.publicmask.controller.MainController;
import com.publicmask.model.Personinfo;

public class MainView {

	MainController mc = new MainController();
	Scanner sc = new Scanner(System.in);
	

	public void MainView() {
		
		
		while(true) {
			System.out.println("=============공적마스크 예약 시스템=============");
			System.out.println("***약국 목록입니다***");
			storeview();
			System.out.println("------------------------------");
			System.out.print("약국 선택: ");
			int num = sc.nextInt();
			
			
			switch(num) {
			case 1: searchstore(num); break;
			case 2:	searchstore(num); break;
			case 3: searchstore(num); break;
			case 4: searchstore(num); break;
			default:
				System.out.println("잘못 입력하셨습니다.!!");

			
			}
			
			
			
		}
		
		
		
	}
	
	public void storeview() {
		mc.storeview();
	}
	
	public void searchstore(int num) {
	
		mc.searchstore(num);
		char answer=' ';
		System.out.print("예약하시겠습니까? (Y/N) : ");
		answer = sc.next().toUpperCase().charAt(0);
		if(answer=='Y') {
			System.out.println("**손님의 구매 가능 여부 확인**");
			usercheck();
		}
		
		
		
	}

	public void usercheck() {
		
		System.out.print("이름 : ");
		String name=sc.next();
		System.out.print("주민번호(생년월일): ");
		String num =sc.next();
		
		boolean check=mc.usercheck(name,num);
		
		if(check ==true) {
			System.out.println("예약을 진행합니다.");
			maskinfo();
		}else {
			
			
		}
		
		
	}
	
	public void maskinfo() {
		int num1=0,num2=0,num3=0;
		
		
		System.out.println("** 항목별 구입 수량을 적으시오. **");
		System.out.print("KF94 : ");
		num1 = sc.nextInt();
		System.out.print("KF80 : ");
		num2 = sc.nextInt();
		System.out.print("일반마스크 : ");
		num3 = sc.nextInt();
		
		
		mc.maskinfo(num1, num2, num3);
				
		
	}
	
	
	
	
	
	
	
}
