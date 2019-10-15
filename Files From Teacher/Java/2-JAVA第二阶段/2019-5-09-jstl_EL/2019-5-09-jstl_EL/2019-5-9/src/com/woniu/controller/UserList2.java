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
@WebServlet("/UserList2.do")
public class UserList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList2() {
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
		List<User> users = ServiceFactory.getUserService().getAllUsersByPage(pb); //��ȡ��ǰҳ��Ҫ��ʾ������
		request.setAttribute("users", users);
		request.setAttribute("pb", pb);
		//��ת
		request.getRequestDispatcher("UserSqlList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
