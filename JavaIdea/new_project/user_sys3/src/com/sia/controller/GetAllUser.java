package com.sia.controller;

import com.sia.bean.PageNum;
import com.sia.bean.User;
import com.sia.service.BeanFactory;
import com.sia.service.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getAllUser.do")
public class GetAllUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageNum pn = (PageNum) request.getSession().getAttribute("pn");
        if( pn==null ){
            pn = BeanFactory.getPageNumService();
            pn.setMaxRows( 3 );
            pn.setPageNum( 1 );
            pn.setTotalPages(-1);
        }
        Integer pageNum = pn.getPageNum();
        String s = request.getParameter("n");
        if( s!=null ) {
            if (s.equals("1")) pn.setPageNum(1);
            else if (s.equals("2")) pn.setPageNum(pageNum == 1 ? 1 : pageNum - 1);
            else if (s.equals("3")) pn.setPageNum(pageNum.equals(pn.getTotalPages())?pn.getTotalPages():pageNum + 1);
            else if (s.equals("4")) pn.setPageNum(pn.getTotalPages());
        }
        List<User> users = DaoFactory.getUserService().getAll( pn );
        request.getSession().setAttribute("pn",pn);
        request.getSession().setAttribute("users",users);
        response.sendRedirect("userList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
