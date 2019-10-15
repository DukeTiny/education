package com.woniuxy.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.service.IUserService;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private IUserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void findOne() {
		System.out.println("UserController.findOne():" + service);
	}
}
