package com.sia.controller;

import com.sia.bean.User;
import com.sia.dao.IUserDao;
import com.sia.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/managerChangeUserPass.do")
public class ManagerChangeUserPass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = (String)request.getSession().getAttribute("uname");
        String oldUpwd = (String)request.getSession().getAttribute("upwd");
        String upwd = request.getParameter("upwd");
        String repeatUpwd = request.getParameter("repeatUpwd");
        if(  upwd.equals(repeatUpwd) ){
            IUserDao ud = new UserDaoImpl();
            User user = ud.getLoginUser(uname,oldUpwd);
            user.setUpwd( repeatUpwd );
            ud.update(user);
            List<User> users = ud.getAll();
            request.getSession().setAttribute("users",users);
            response.sendRedirect("jsp_files/userList.jsp");
        }
        else response.sendRedirect("jsp_files/userSuccess.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
