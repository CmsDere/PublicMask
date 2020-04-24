package com.publicmask.controller;

import java.util.ArrayList;

import com.publicmask.model.*;

public class MainController {

	private ArrayList<Drugstoreinfo> storeList = new ArrayList<>();
	private ArrayList<Maskinfo> maskList = new ArrayList<>();
	private ArrayList<Personinfo> personList = new ArrayList<>();
	
	public void base() {
		storeList.add(new Drugstoreinfo("하나약국","서울시 서초구 양재1동",12341234,100));
		storeList.add(new Drugstoreinfo("둘약국","서울시 서초구 양재2동",12341235,200));
		storeList.add(new Drugstoreinfo("셋약국","서울시 서초구 양재3동",12341246,300));
		storeList.add(new Drugstoreinfo("넷약국","서울시 서초구 양재4동",12341237,400));
		storeList.add(new Drugstoreinfo("다섯약국","서울시 서초구 양재5동",12341238,500));
		storeList.add(new Drugstoreinfo("여섯약국","서울시 서초구 양재6동",12341239,600));
	}

	
	
	public void inforinput(Personinfo person) {

		
		
	}
		
	
	
	
	
	
}
