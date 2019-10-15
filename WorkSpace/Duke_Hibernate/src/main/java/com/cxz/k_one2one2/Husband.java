package com.cxz.k_one2one2;

import java.io.Serializable;

public class Husband implements Serializable {
	
	private Integer id;
	private String Hname;
	private Wife wife;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHname() {
		return Hname;
	}
	public void setHname(String hname) {
		Hname = hname;
	}
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	
	@Override
	public String toString() {
		return "Husband [id=" + id + ", Hname=" + Hname + "]";
	}
	
	
	
}
