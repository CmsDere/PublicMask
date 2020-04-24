package com.publicmask.model;

public class Personinfo {

	private String userName;
	private int userNumber;
	
	public Personinfo() {}
	public Personinfo(String userName, int userNumber) {
		this.userName = userName;
		this.userNumber = userNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	@Override
	public String toString() {
		return "유저정보 [이름=" + userName + ", 주민번호=" + userNumber + "]";
	}
	
	
	
	
	
	
	
	
}
