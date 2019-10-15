package com.cxz.k_one2one;

import java.io.Serializable;

public class Wife implements Serializable{
	
	private Integer id;
	private String wname;
	private Husband husband;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
	
	@Override
	public String toString() {
		return "Wife [id=" + id + ", wname=" + wname + "]";
	}
	
	
}
