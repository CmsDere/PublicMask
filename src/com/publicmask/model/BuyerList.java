package com.publicmask.model;

public class BuyerList {
	private String Pname;
	   private String Pnum;
	   private String Storename;
	   
	   public BuyerList() {}
	   
	   public BuyerList(String Pname, String Pnum, String Storename) {
	      this.Pname = Pname;
	      this.Pnum = Pnum;
	      this.Storename = Storename;
	   }

	   public String getPname() {
	      return Pname;
	   }

	   public void setPname(String pname) {
	      Pname = pname;
	   }

	   public String getPnum() {
	      return Pnum;
	   }

	   public void setPnum(String pnum) {
	      Pnum = pnum;
	   }

	   public String getStorename() {
	      return Storename;
	   }

	   public void setStorename(String Storename) {
	      this.Storename = Storename;
	   }
	   
	   @Override
	   public String toString() {
	      return "구매자 이름:"+Pname+" 구매자 주민번호:"+Pnum+" 구매 약국:"+Storename;   }

}
