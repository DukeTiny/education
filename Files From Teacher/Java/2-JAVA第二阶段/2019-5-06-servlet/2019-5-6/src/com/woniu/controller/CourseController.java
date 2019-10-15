package com.woniu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.bean.Course;
import com.woniu.dao.CourseDAOImpl;
import com.woniu.dao.ICourseDAO;

public class CourseController extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("in init...");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获得表单数据
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		String tno = request.getParameter("tno");
		Course course = new Course();
		course.setCno(cno);
		course.setCname(cname);
		course.setTno(tno);
		
		//调用dao方法
		ICourseDAO cd = new CourseDAOImpl();
		cd.save(course);
		
		//跳转页面
		response.sendRedirect("courseList.do");
		
//		super.service(request, response);
//		System.out.println("in service...");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in doPost...");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("in service...");
	}
}
