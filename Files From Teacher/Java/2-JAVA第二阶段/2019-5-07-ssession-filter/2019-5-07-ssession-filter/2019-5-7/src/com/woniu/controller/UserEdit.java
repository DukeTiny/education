package com.woniu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.bean.User;
import com.woniu.dao.IUserDAO;
import com.woniu.dao.UserDAOImpl;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/UserEdit.do")
public class UserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ยาย๋
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		String uname=request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String urole = request.getParameter("urole");
		User user = new User();
		user.setUname(uname);
		user.setUpwd(upwd);
		user.setUid(uid);
		user.setUrole(urole);
		
		
		IUserDAO ud = new UserDAOImpl();
		ud.update(user);
		
		response.sendRedirect("UserList.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
