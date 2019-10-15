package com.woniuxy.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.test.Dog;

@Controller
public class UserController {
	
	@Autowired
	private Dog dog;
	
	public UserController() {
		System.out.println("uuuuu");
	}
	
	@RequestMapping("hello")
	@ResponseBody  
	public String hello() {
		System.out.println("问候SpringBoot它大爷！！！~~##@@: " + dog);
		return "a"; 
	}
	
	@RequestMapping("hello2")
	public String hello2() {
		System.out.println("问候SpringBoot它大爷！！！");
		return "a"; 
	}
}
