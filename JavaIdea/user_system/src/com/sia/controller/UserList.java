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

@WebServlet("/userList.do")
public class UserList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserDao ud = new UserDaoImpl();
        List<User> users = ud.getAll();
        request.getSession().setAttribute("users",users);
        response.sendRedirect("jsp_files/userList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
