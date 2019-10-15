package com.sia.controller;

import com.sia.bean.User;
import com.sia.service.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doLogin.do")
public class DoLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        User user = DaoFactory.getUserService().login(uname,upwd);
        if ( user!=null ){
            request.getSession().setAttribute("user",user);
            if( user.getUrole().equals("普通用户") ) response.sendRedirect("userLogin.jsp");
            else response.sendRedirect("managerLogin.jsp");
        }
        else response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
