package com.woniuxy.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

public class MyServletProxy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		ApplicationContext ctx = (ApplicationContext) application.getAttribute("ioc");
		
		Servlet servlet = (Servlet) ctx.getBean(this.getServletName());
		servlet.service(request, response);
	}

}
