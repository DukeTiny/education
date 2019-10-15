package com.cxz.web.action;

import com.cxz.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	
	public String save() {
		System.out.println("UserAction.save()");
		return null;
	}
	
	public User getModel() {
		return user;
	}
	
	
	public static void main(String[] args) {

	}
}
