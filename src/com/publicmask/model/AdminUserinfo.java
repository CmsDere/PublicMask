package com.publicmask.model;

public class AdminUserinfo {

	private String UserID;
	private String UserPassword;
	private String StoreName;
	
	
	public AdminUserinfo() {}
	public AdminUserinfo(String userID, String userPassword) {
		UserID = userID;
		UserPassword = userPassword;
	
	}


	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	@Override
	public String toString() {
		return "관리자 정보 ID=" + UserID ;
	}
	
	
	
	
	
	
	
	
}
