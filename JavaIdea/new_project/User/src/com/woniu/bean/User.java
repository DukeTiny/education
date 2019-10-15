package com.woniu.bean;

public class User {
	 private Integer uid; 
	 private String uname;
	 private String sex;
	 private Integer age;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public User(Integer uid, String uname, String sex, Integer age) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.sex = sex;
		this.age = age;
	}
	public User() {
		super();
	} 
	 
}
