package com.woniu.emp;

public class Dept {
//	����һ�������࣬�������Բ��źţ��������ƣ�����������ȫ�ι��췽�����޲ι��췽����
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
