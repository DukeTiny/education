package com.woniu.action;

import com.woniu.controller.Controller;

@Controller("emp.action")
public class EmpAction {
	public String findAll(){
		System.out.println("in empAction findAll...");
		return "2.jsp";
	}
}
