package com.publicmask.model;

public class Maskinfo {

	private String maskname;
	private String maskuser;
	private String masksize;
	private int maskNum;
	
	public Maskinfo() {}
	public Maskinfo(String maskname, int maskNum){
		this.maskname = maskname;
		this.maskNum = maskNum;
	}	
	
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
	public int getMaskNum() {
		return maskNum;
	}
	public void setMaskNum(int maskNum) {
		this.maskNum = maskNum;
	}
	@Override
	public String toString() {
		return "마스크 종류=" + maskname + ", 갯수=" + maskNum;
	}
	
	
	
	
	
}
