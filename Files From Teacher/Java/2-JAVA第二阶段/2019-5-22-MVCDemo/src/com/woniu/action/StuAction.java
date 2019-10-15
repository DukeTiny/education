package com.woniu.action;

import com.woniu.bean.Stu;
import com.woniu.controller.Controller;

@Controller("stu.action")
public class StuAction {
	public String save(Stu stu){
		System.out.println("111");
		return "1.jsp";
	}
}
