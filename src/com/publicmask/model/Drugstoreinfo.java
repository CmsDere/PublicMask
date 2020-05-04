package com.publicmask.model;

import java.util.ArrayList;

//약국 정보
public class Drugstoreinfo {

	private String StoreName;
	private String address;
	private String phoneNumber;
	private ArrayList maskinfo;
	
	public Drugstoreinfo() {}

	public Drugstoreinfo(String storeName, String address, String phoneNumber, ArrayList maskinfo) {
		this.StoreName = storeName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.maskinfo = maskinfo;
	}

	public String getStoreName() {
		return StoreName;
	}

	public void setStoreName(String storeName) {
		this.StoreName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public ArrayList getMaskinfo() {
		return maskinfo;
	}

	public void setMaskinfo(ArrayList maskinfo) {
		this.maskinfo = maskinfo;
	}

	@Override
	public String toString() {
		return StoreName + ", 주소=" + address + ", 전화번호=" + phoneNumber;
	}
	
	
	
	
	
}
