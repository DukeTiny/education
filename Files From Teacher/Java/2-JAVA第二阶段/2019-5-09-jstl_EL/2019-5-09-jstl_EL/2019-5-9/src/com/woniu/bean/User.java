package com.woniu.bean;

public class User {
	private Integer uid;//�û�id
	private String uname;//�û���
	private String upwd;//�û�����
	private String urole;//�û���ɫ
	private String ustate;//�û�״̬
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
	public String getUstate() {
		return ustate;
	}
	public void setUstate(String ustate) {
		this.ustate = ustate;
	}
	public User(Integer uid, String uname, String upwd, String urole, String ustate) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.urole = urole;
		this.ustate = ustate;
	}
	public User() {
		super();
	}
	
}
