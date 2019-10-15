package com.woniu.emp;

public class Dept {
//	声明一个部门类，包含属性部门号，部门名称，部门人数。全参构造方法和无参构造方法。
	private String dno;
	private String dname;
	private int dnum;
	
	
	public Dept() {
	}
	
	
	public Dept(String dno, String dname) {
		this.dno = dno;
		this.dname = dname;
	}


	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
	
}
