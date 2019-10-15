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

@WebServlet("/changePass.do")
public class ChangePass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPwd = request.getParameter("oldUpwd");
        String upwd = request.getParameter("upwd");
        String repeatUpwd = request.getParameter("repeatUpwd");
        User user = (User)request.getSession().getAttribute("user");
        if( user.getUpwd().equals(oldPwd) && upwd.equals(repeatUpwd) ){
            IUserDao ud = new UserDaoImpl();
            user.setUpwd( repeatUpwd );
            ud.update(user);
            response.sendRedirect("closeAccount.do");
        }
        else response.sendRedirect("jsp_files/userSuccess.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
