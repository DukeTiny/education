package com.cxz.model;

import java.util.List;

public class User {

	private Integer id;
	private String username;
	private String password;
	private List roles;
	private List trees;
	private boolean isDelete;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List getRoles() {
		return roles;
	}
	public void setRoles(List roles) {
		this.roles = roles;
	}
	
	public List getTrees() {
		return trees;
	}
	public void setTrees(List trees) {
		this.trees = trees;
	}
	
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", isDelete=" + isDelete + "]";
	}
	
	
	
	
	

	
	
}