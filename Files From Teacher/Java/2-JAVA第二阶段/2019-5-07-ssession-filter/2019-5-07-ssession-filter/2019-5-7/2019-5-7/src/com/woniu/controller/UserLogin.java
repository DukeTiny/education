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
@WebServlet("/UserLogin.do")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		IUserDAO ud = new UserDAOImpl();
		User loginUser = ud.login(uname, upwd);
		if(loginUser!=null){
			request.getSession().setAttribute("loginUser", loginUser);
			if(loginUser.getUrole().equals("π‹¿Ì‘±")){
				response.sendRedirect("UserList.do");
			}else{
				response.sendRedirect("UpdatePwd.jsp");
			}
		}else{
			response.sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
