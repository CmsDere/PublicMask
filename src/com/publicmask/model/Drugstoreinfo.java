package com.publicmask.model;

public class Drugstoreinfo {

	private String StoreName;
	private String address;
	private int phoneNumber;
	private int maskstate;
	
	public Drugstoreinfo() {}

	public Drugstoreinfo(String storeName, String address, int phoneNumber, int maskstate) {
		StoreName = storeName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.maskstate = maskstate;
	}

	public String getStoreName() {
		return StoreName;
	}

	public void setStoreName(String storeName) {
		StoreName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getMaskstate() {
		return maskstate;
	}

	public void setMaskstate(int maskstate) {
		this.maskstate = maskstate;
	}

	
	@Override
	public String toString() {
		return "약국정보= [약국이름=" + StoreName + ", 주소=" + address + ", 전화번호=" + phoneNumber
				+ "]";
	}
	
	
	
	
	
}
