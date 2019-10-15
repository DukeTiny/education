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

@WebServlet("/changeUserStatus.do")
public class ChangeUserStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = (String)request.getSession().getAttribute("uname");
        String upwd = (String)request.getSession().getAttribute("upwd");
        IUserDao ud = new UserDaoImpl();
        User user = ud.getLoginUser(uname,upwd);
        String status = user.getUstatus().equalsIgnoreCase("normal")?user.Frezzy_STATUS:user.NORMAL_STATUS;
        user.setUstatus(status);
        ud.update(user);
        List<User> users = ud.getAll();
        request.getSession().setAttribute("users",users);
        response.sendRedirect("jsp_files/userList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
