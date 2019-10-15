package com.woniu.atm.bean;

public class Card {
	private String cno;
	private String cpwd;
	private String cname;
	private int cmoney;
	
	public Card() {
		super();
	}
	
	public Card(String cno, String cpwd, String cname, int cmoney) {
		super();
		this.cno = cno;
		this.cpwd = cpwd;
		this.cname = cname;
		this.cmoney = cmoney;
	}

	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getCno()+":"+this.getCpwd()+":"+this.getCname()+":"+this.getCmoney();
	}
	
}
