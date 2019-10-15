package com.woniu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.bean.User;
import com.woniu.service.ServiceFactory;

/**
 * Servlet implementation class User
 */
@WebServlet("/UserServlet.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if(method==null||"findAll".equals(method)){
			findAll(request,response);
		}else if(method.equals("edit")){
			edit(request,response);
		}else if(method.equals("add")){
			add(request,response);
		}else if(method.equals("del")){
			del(request,response);
		}else if(method.equals("findOne")){
			findOne(request,response);
		}
	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		ServiceFactory.getUserService().delUser(uid);
		response.sendRedirect("UserServlet.do?method=findAll");
	}

	private void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		ServiceFactory.getUserService().findOne(uid);
		response.sendRedirect("User.jsp");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("uname");
		String sex = request.getParameter("sex");
		Integer age = Integer.parseInt(request.getParameter("age"));
		User u = new User(uid,uname,sex,age);
		ServiceFactory.getUserService().addUser(u);
		response.sendRedirect("UserServlet.do?method=findAll");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("uname");
		String sex = request.getParameter("sex");
		Integer age = Integer.parseInt(request.getParameter("age"));
		User u = new User(uid,uname,sex,age);
		ServiceFactory.getUserService().editUser(u);
		response.sendRedirect("UserServlet.do?method=findAll");
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> list = ServiceFactory.getUserService().findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("User.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
