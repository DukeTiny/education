package com.woniu.atm.bean;

public class Card {
	private String cid;
	private String cpwd;
	private String cname;
	private int cmoney;
	
	public Card() {
		super();
	}
	public Card(String cid, String cpwd, String cname, int cmoney) {
		super();
		this.cid = cid;
		this.cpwd = cpwd;
		this.cname = cname;
		this.cmoney = cmoney;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCpwd() {
		return cpwd;
	}
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCmoney() {
		return cmoney;
	}
	public void setCmoney(int cmoney) {
		this.cmoney = cmoney;
	}
	public String toString() {
		return super.toString();
	}
	
}
