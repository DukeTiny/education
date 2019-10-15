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

@WebServlet("/userLogin.do")
public class UserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
            IUserDao ud = new UserDaoImpl();
            User user = ud.getLoginUser(uname,upwd);
            if ( user!=null ) {
                request.getSession().setAttribute("user",user);
                if( user.getUrole().equals("普通用户")) response.sendRedirect("jsp_files/userSuccess.jsp");
                else response.sendRedirect("jsp_files/managerSuccess.jsp");
            }
            else response.sendRedirect("jsp_files/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
