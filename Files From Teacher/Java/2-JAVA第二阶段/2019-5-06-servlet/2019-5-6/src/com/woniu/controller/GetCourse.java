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
 * Servlet implementation class GetCourse
 */
@WebServlet("/getCourse.do")
public class GetCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCourse() {
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
		String cno = request.getParameter("cno");
		
		ICourseDAO cd = new CourseDAOImpl();
		Course c = cd.findOne(cno);
		
		request.setAttribute("c", c);
		
		request.getRequestDispatcher("courseEditForm.jsp").forward(request, response);
	}

}
