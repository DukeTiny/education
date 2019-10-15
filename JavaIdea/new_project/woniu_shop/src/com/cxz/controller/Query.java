package com.cxz.controller;

import com.cxz.bean.PageBean;
import com.cxz.bean.Product;
import com.cxz.bean.UserInformation;
import com.cxz.service.ServiceFactory;
import com.mysql.cj.xdevapi.JsonArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/query.do")
public class Query extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userRole = ((UserInformation)request.getSession().getAttribute("loginUser")).getUserRole();
        String info = request.getParameter("search");
        switch ( userRole ){
            case "管理员":
                queryAll(request,response,info);
                break;
            case "普通用户":
                queryOnSale(request,response,info);
                break;
        }
    }

    private void queryOnSale(HttpServletRequest request, HttpServletResponse response, String info) {
        List<Product> products = ServiceFactory.getProductService().findByStatus(info);
        PageBean pb = new PageBean();
    }

    private void queryAll(HttpServletRequest request, HttpServletResponse response, String info) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
