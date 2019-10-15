package com.woniu.bean;

public class User {
	private Integer uid;
	private String uname;
	private String upwd;
	private String urole;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUrole() {
		return urole;
	}
	public void setUrole(String urole) {
		this.urole = urole;
	}
	public User(Integer uid, String uname, String upwd, String urole) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.urole = urole;
	}
	public User() {
		super();
	}
	
}
