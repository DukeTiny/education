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

@WebServlet("/userReg.do")
public class UserReg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserDao ud = new UserDaoImpl();
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        User user = new User(uname,upwd);
        ud.add(user);
        response.sendRedirect("jsp_files/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
