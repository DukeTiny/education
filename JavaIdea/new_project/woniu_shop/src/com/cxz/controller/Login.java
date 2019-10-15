package com.cxz.controller;

import com.cxz.bean.UserInformation;
import com.cxz.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method==null) {
            String username = request.getParameter("username");
            String pwd = request.getParameter("password");
            UserInformation user = ServiceFactory.getUserInfoService().findByNameAndPWD(username, pwd);
            if (user != null) {
                request.getSession().setAttribute("loginUser", user);
                response.sendRedirect("iFrame.jsp");
            } else response.sendRedirect("login.html");
        }
        else {
            request.getSession().removeAttribute("loginUser");
            response.sendRedirect("login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
