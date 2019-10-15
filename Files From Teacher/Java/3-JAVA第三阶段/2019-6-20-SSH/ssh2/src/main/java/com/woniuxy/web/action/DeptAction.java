package com.woniuxy.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.woniuxy.domain.Dept;
import com.woniuxy.service.IDeptService;


@Controller
public class DeptAction extends ActionSupport implements ModelDriven<Dept> {

	private Dept d = new Dept();
	
	@Autowired
	private IDeptService service;
	
	
	public DeptAction() {
		System.out.println("DeptAction()");
	}
	
	public String save() {
		System.out.println("save...:" + service.getClass());
		Dept d = new Dept();
		Dept d2 = new Dept();
		d.setDname("aaa");
		d2.setDname("bbb");
		service.saveTwo(d, d2);
		return null;
	}
	
	@Override
	public Dept getModel() {
		return d;
	}

}
