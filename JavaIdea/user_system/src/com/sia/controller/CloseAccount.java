package com.sia.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/closeAccount.do")
public class CloseAccount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        if (request.getSession().getAttribute("uname")!=null) {
            request.getSession().removeAttribute("uname");
        }
        if (request.getSession().getAttribute("upwd")!=null) {
            request.getSession().removeAttribute("upwd");
        }
        response.sendRedirect("jsp_files/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
