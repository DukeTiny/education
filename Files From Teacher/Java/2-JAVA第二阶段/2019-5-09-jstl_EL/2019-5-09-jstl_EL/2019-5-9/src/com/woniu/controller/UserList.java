package com.woniu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.bean.PageBean;
import com.woniu.bean.User;
import com.woniu.service.ServiceFactory;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/UserList.do")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ����
		PageBean pb = new PageBean();
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null){
			pageNum = "1";
		}
		pb.setPageNum(Integer.parseInt(pageNum));
		pb.setPageRow(3);
		
		//����service����
		List<User> users = (List<User>) request.getSession().getAttribute("users");
		if(users==null){
			users = ServiceFactory.getUserService().getAllUsers();
			request.getSession().setAttribute("users", users);
		}
		pb.setCountRow(users.size());
		pb.setCountPage(users.size()%pb.getPageRow()==0?users.size()/pb.getPageRow():users.size()/pb.getPageRow()+1);
		request.setAttribute("pb", pb);
		//��ת
		request.getRequestDispatcher("UserList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
