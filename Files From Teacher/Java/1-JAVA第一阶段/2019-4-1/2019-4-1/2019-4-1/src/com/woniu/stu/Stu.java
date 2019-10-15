package com.woniu.stu;

public class Stu {
	private String sid;
	private String sname;
	private int sage;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getSid()+"-"+this.getSname()+"-"+this.getSage();
	}
	
}
