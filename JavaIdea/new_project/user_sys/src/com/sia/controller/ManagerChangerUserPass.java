package com.sia.controller;

import com.sia.bean.User;
import com.sia.service.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/managerChangerUserPass.do")
public class ManagerChangerUserPass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt( request.getParameter("uid" ) );
        String newPwd = request.getParameter("newPwd" );
        String repeatNewPwd = request.getParameter("repeatNewPwd");
        if ( newPwd.equals(repeatNewPwd) ){
            User user = DaoFactory.getUserService().getOne(uid);
            user.setUpwd( repeatNewPwd );
            DaoFactory.getUserService().update(user);
        }
        response.sendRedirect("userList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
