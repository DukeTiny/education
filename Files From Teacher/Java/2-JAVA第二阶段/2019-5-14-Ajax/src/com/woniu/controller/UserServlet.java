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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/User.do")
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
		String method = request.getParameter("method");
		if("checkUname".equals(method)){
			checkUname(request,response);
		}else if("checkUnameAjax".equals(method)){
			checkUnameAjax(request,response);
		}else if("list".equals(method)){
			list(request,response);
		}else if("findOne".equals(method)){
			findOne(request,response);
		}else if("update".equals(method)){
			update(request,response);
		}else if("add".equals(method)){
			add(request,response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String urole = request.getParameter("urole");
		String ustate = request.getParameter("ustate");
		User user = new User(null, uname, upwd, urole,ustate);
		ServiceFactory.getUserService().addUser(user);
		list(request,response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String urole = request.getParameter("urole");
		String ustate = request.getParameter("ustate");
		User user = new User(uid, uname, upwd, urole,ustate);
		ServiceFactory.getUserService().updateUser(user);
		list(request,response);
	}

	private void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");
		User user = ServiceFactory.getUserService().getUserByUid(Integer.parseInt(uid));
		JSONObject json = JSONObject.fromObject(user);
		response.getWriter().write(json.toString());
		response.getWriter().flush();
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<User> users = ServiceFactory.getUserService().getAllUsers();
		//[{"uid":"","uname":""},{},{}]
//		String html = "";
//		for(int i=0;i<users.size();i++){
//			User u = users.get(i);
//			html+="<tr>";
//			html+="<th>"+(i+1)+"</th>";
//			html+="<th>"+u.getUname()+"</th>";
//			html+="<th>"+u.getUpwd()+"</th>";
//			html+="<th>"+u.getUrole()+"</th>";
//			html+="<th>"+u.getUstate()+"</th>";
//			html+="<th><a href=''>±à¼­</a></th>";
//			html+="<th>"+u.getUid()+"</th>";
//			html+="</tr>";
//		}
		JSONArray json = JSONArray.fromObject(users);
		System.out.println(json);
		response.getWriter().write(json.toString());
		response.getWriter().flush();
	}

	private void checkUnameAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uname = request.getParameter("uname");
		User u = ServiceFactory.getUserService().getUserByUname(uname);
		response.getWriter().write(u==null?"ok":"no");
		response.getWriter().flush();
	}

	private void checkUname(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uname = request.getParameter("uname");
		User user = ServiceFactory.getUserService().getUserByUname(uname);
		request.setAttribute("info", user==null?"ok":"no");
		request.getRequestDispatcher("Reg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
