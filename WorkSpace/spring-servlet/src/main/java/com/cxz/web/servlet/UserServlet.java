package com.cxz.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

import com.cxz.service.IUserService;

@Controller
public class UserServlet extends HttpServlet {
	
	
	@Autowired
	private IUserService userService;
	
	public UserServlet() {
		System.out.println("UserServlet.UserServlet()");
	}
	
	public void init() throws ServletException {
	
		System.out.println("UserServlet.init()~~~~~~~~~~~");
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UserServlet.service()" + " : " + userService);
	}

	public void destroy() {
		System.out.println("UserServlet.destroy()");
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	
	
	
}
