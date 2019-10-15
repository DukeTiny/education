package com.cxz.model;

import java.util.List;

public class Role {

	private Integer id;
	private String name;
	private List<RoletreeKey> trees;

	public List<RoletreeKey> getTrees() {
		return trees;
	}

	public void setTrees(List<RoletreeKey> trees) {
		this.trees = trees;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return name;
	}

	public void setUsername(String username) {
		this.name = username;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	
	
}