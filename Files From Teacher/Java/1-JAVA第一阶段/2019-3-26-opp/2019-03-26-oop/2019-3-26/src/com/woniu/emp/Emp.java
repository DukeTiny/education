package com.woniu.emp;

import java.util.Date;

public class Emp {
//	����һ��Ա���࣬��������Ա���ţ����������գ��Ա𣬹��ʣ����źš�ȫ�ι��췽�����޲ι��췽����
	private String eno;
	private String ename;
	private Date ebirth;
	private String esex;
	private float esalary;
	private String dno;
	
	
	
	public Emp(){
		
	}
	

	public Emp(String eno, String ename, Date ebirth, String esex, float esalary, String dno) {
		this.eno = eno;
		this.ename = ename;
		this.ebirth = ebirth;
		this.esex = esex;
		this.esalary = esalary;
		this.dno = dno;
	}



	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getEbirth() {
		return ebirth;
	}
	public void setEbirth(Date ebirth) {
		this.ebirth = ebirth;
	}
	public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}
	public float getEsalary() {
		return esalary;
	}
	public void setEsalary(float esalary) {
		this.esalary = esalary;
	}
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	
}
