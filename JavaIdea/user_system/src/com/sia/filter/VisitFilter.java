package com.sia.filter;

import com.sia.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "VisitFilter")
public class VisitFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        User user = (User) request.getSession().getAttribute("user");
        String uri= request.getRequestURI();
        if( user!=null || uri.endsWith("login.jsp") || uri.endsWith("userLogin.do") || uri.endsWith("reg.jsp") || uri.endsWith("userReg.do")) {
            chain.doFilter(req, resp);
        }
        else {
            response.sendRedirect("jsp_files/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
