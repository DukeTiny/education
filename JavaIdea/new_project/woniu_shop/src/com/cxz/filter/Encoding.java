package com.cxz.filter;

import com.cxz.bean.UserInformation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class Encoding implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        UserInformation user = (UserInformation)request.getSession().getAttribute("loginUser");
        String url = request.getRequestURI();
        String type = url.substring(url.lastIndexOf(".")+1);
        if( user!=null || url.lastIndexOf("login.html")!=-1||url.lastIndexOf("login.do")!=-1||type.equals("png")||type.equals("jpg")){
            chain.doFilter(req, resp);
        }
        else {
            response.sendRedirect("login.html");
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
