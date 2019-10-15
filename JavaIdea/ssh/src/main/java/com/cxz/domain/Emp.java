package com.cxz.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Emp {
	
	private Integer eid;
	private String ename;
	private Date birthday;
	private Double money;
	private Dept dept;
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", birthday=" + birthday + ", money=" + money + "]";
	}
	
}
