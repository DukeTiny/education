package com.woniuxy.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.woniuxy.service.IUserService;

@Controller
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	public IUserService service;
	
	public UserServlet() {
		System.out.println("UserServlet()");
	}
	public void init() throws ServletException {
//		System.out.println("UserServlet.init()");
	}
	public void destroy() {
//		System.out.println("UserServlet.destroy()");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet.service():" + service); 
	}
	
	

}
