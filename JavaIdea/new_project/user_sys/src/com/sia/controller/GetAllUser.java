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
import java.util.List;

@WebServlet("/getAllUser.do")
public class GetAllUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = (List<User>) request.getSession().getAttribute("users");
        users = DaoFactory.getUserService().getAll();
        request.getSession().setAttribute("users",users);
        PageNum pn = (PageNum) request.getSession().getAttribute("pn");
        Integer pageNum = pn==null?null:pn.getPageNum();
        if( pn==null ) {
            pn = BeanFactory.getPageNumService();
            pn.setMaxRows(3);
            int num = users.size() / pn.getMaxRows();
            pn.setPageNum( pageNum = 1 );
            pn.setTotalPages(users.size() % pn.getMaxRows() == 0 ? num : num + 1);
            request.getSession().setAttribute("pn",pn);
        }
        String s = request.getParameter("n");
        if( s!=null ) {
            if (s.equals("1")) pn.setPageNum(1);
            else if (s.equals("2")) pn.setPageNum( pageNum == 1 ? 1 : pageNum - 1);
            else if (s.equals("3")) pn.setPageNum( pageNum.equals( pn.getTotalPages() )?pn.getTotalPages():pageNum + 1);
            else if (s.equals("4")) pn.setPageNum( pn.getTotalPages() );
        }
        response.sendRedirect("userList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
