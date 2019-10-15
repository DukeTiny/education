package com.woniu.bean;

public class User {
	private Integer uid;//用户id
	private String uname;//用户名
	private String upwd;//用户密码
	private String urole;//用户角色
	private String ustate;//用户状态
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
