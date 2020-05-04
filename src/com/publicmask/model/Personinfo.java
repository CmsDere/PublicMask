package com.publicmask.model;

//입력된 유저정보
public class Personinfo {

	private String userName;
	private String userNumber;
	
	public Personinfo() {}
	public Personinfo(String userName, String userNumber) {
		this.userName = userName;
		this.userNumber = userNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	@Override
	public String toString() {
		return "유저정보 [이름=" + userName + ", 주민번호=" + userNumber + "]";
	}
	
	
	
	
	
	
	
	
}
