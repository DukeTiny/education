package com.woniu.action;

import com.woniu.core.UrlMapping;

@UrlMapping("/stu.action")
public class StuAction {
	public String execute(){
		System.out.println("in execute...");
		return "1.jsp";
	}
	public String addStu(String name,String age){
		System.out.println("in addStu..."+name+":"+age);
		return "stuList.jsp";
	}
	public String getAllStus(){
		System.out.println("in getAllStus...");
		return "stuList.jsp";
	}
}
