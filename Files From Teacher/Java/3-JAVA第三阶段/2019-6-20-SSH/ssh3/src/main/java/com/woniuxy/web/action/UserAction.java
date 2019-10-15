package com.woniuxy.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.woniuxy.domain.ShoppingCart;
import com.woniuxy.domain.User;
import com.woniuxy.service.IUserService;
@Controller 
public class UserAction extends ActionSupport implements ModelDriven<User> {

	@Autowired
	private IUserService service;
	
	@Autowired
	private Manager manager;
	
	private int from, to[];
	
	@Autowired
	private ShoppingCart cart;
	
	private User user = new User();
	
	public UserAction() {
		System.out.println("UserAction.UserAction()");
	}
	
	public String save() {
		System.out.println("save...:" + service);
		System.out.println(cart.toString());
		return null;
	}
	
	@Transactional
	public String transfer() {
		// manager.batchTransfer(from, to, user.getMoney().intValue());
		for (int t : to) {
			service.transfer(from, t, user.getMoney().intValue());
		}
		return null;
	}
	
	@Override
	public User getModel() {
		return user;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int[] getTo() {
		return to;
	}

	public void setTo(int[] to) {
		this.to = to;
	}
	
}
