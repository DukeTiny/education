package com.woniuxy.j_annotation;

import java.io.Serializable;

@Table(name = "abc")
public class User implements Serializable{
	@SQLInteger
	@Column(name = "iiiddd")
	private Integer id;
	@SQLString(length = 300)
	@Column(name = "uuuuuuuuusername")
	private String username;
	
	private String address;
	
	public User() {
	}

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
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}

}
