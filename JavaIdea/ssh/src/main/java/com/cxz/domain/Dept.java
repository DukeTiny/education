package com.cxz.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Dept {
	
	private Integer did;
	private String dname;
	private Set<Emp> emps = new HashSet<>();
	
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String danme) {
		this.dname = danme;
	}
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	@Override
	public String toString() {
		return "Dept [did=" + did + ", danme=" + dname + "]";
	} 

	
}
