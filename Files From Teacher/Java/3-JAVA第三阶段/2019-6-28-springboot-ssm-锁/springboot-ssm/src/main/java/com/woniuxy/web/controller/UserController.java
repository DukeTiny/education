package com.woniuxy.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.User;
import com.woniuxy.service.IUserService;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private IUserService service;
	
	@RequestMapping(method =  RequestMethod.GET)
	@ResponseBody
	public String save() {
		User user = new User();
		user.setName("黄药师");
		service.save(user);
		return "hahah";
	}
	
}
