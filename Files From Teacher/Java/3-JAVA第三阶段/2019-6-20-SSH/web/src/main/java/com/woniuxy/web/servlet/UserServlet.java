package com.woniuxy.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.service.IUserService;
import com.woniuxy.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	
	private IUserService service = new UserServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int from = Integer.parseInt(request.getParameter("from"));
		int to = Integer.parseInt(request.getParameter("to"));
		double money = Double.parseDouble(request.getParameter("money"));
		
		
		service.transfer(from, to, money);
	}

}
