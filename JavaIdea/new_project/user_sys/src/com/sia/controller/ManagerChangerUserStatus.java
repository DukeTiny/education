package com.sia.controller;

import com.sia.bean.User;
import com.sia.service.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/managerChangerUserStatus.do")
public class ManagerChangerUserStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt( request.getParameter("uid" ) );
        User user = DaoFactory.getUserService().getOne(uid);
        user.setUstatus( user.getUstatus().equalsIgnoreCase("Normal")?"Freezed":"Normal" );
        DaoFactory.getUserService().update(user);
        response.sendRedirect("getAllUser.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
