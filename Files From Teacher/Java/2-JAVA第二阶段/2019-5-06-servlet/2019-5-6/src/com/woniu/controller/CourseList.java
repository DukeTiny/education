package com.woniu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.bean.Course;
import com.woniu.dao.CourseDAOImpl;
import com.woniu.dao.ICourseDAO;

/**
 * Servlet implementation class CourseList
 */
//使用注解进行servlet配置
@WebServlet("/courseList.do")
public class CourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得参数
		//调用dao方法
		ICourseDAO cd = new CourseDAOImpl();
		List<Course> courses = cd.findAll();
		request.setAttribute("list", courses);
		//跳转
		request.getRequestDispatcher("courseList.jsp").forward(request, response);
	}

}
