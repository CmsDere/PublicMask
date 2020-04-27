package com.publicmask.model;

public class Maskinfo {

	private String maskname;
	private int maskNum;
	
	public Maskinfo() {}
	public Maskinfo(String maskname, int maskNum){
		this.maskname = maskname;
		this.maskNum = maskNum;
	}	


	public String getMaskname() {
		return maskname;
	}
	public void setMaskname(String maskname) {
		this.maskname = maskname;
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
