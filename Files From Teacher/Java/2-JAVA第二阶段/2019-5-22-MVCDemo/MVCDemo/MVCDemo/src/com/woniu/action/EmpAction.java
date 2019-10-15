package com.woniu.action;

import com.woniu.core.UrlMapping;

@UrlMapping("/emp.action")
public class EmpAction {
	public String execute(){
		System.out.println("in empAction execute...");
		return "2.jsp";
	}
}
