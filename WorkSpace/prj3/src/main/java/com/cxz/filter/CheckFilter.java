package com.cxz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName = "checkFilter",urlPatterns = "/admin/*")
public class CheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest r = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		Object user = r.getSession().getAttribute("user");
		if(user==null) {
			String path = r.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
			resp.sendRedirect(basePath+"/index.jsp");
		}
		else {
			chain.doFilter(request, response);
		}
		
	}

}

