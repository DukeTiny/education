package com.woniu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.bean.Course;
import com.woniu.dao.CourseDAOImpl;
import com.woniu.dao.ICourseDAO;

/**
 * Servlet implementation class CourseEdit
 */
@WebServlet("/courseEdit.do")
public class CourseEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cno = request.getParameter("cno");
		String cname =request.getParameter("cname");
		String tno = request.getParameter("tno");
		Course c = new Course();
		c.setCname(cname);
		c.setCno(cno);
		c.setTno(tno);
		
		ICourseDAO cd = new CourseDAOImpl();
		cd.update(c);
		
		response.sendRedirect("courseList.do");
	}

}
