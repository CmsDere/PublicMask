package com.publicmask.model;

public class Maskinfo {

	private String maskname;
	private String maskuser;
	private String masksize;
	
	public Maskinfo() {}
	public Maskinfo(String maskname, String maskuser, String masksize) {
		this.maskname = maskname;
		this.maskuser = maskuser;
		this.masksize = masksize;
	}



	public String getMaskname() {
		return maskname;
	}
	public void setMaskname(String maskname) {
		this.maskname = maskname;
	}
	public String getMaskuser() {
		return maskuser;
	}
	public void setMaskuser(String maskuser) {
		this.maskuser = maskuser;
	}
	public String getMasksize() {
		return masksize;
	}
	public void setMasksize(String masksize) {
		this.masksize = masksize;
	}
	
	@Override
	public String toString() {
		return "마스크정보= [마스크이름=" + maskname + ", 사용자=" + maskuser + ", 규격="+masksize+"]";
	}
	
	
	
	
	
}
