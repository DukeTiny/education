package com.cxz.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cxz.model.Tree;
import com.cxz.model.User;

@Component
@Aspect
public class AuthorityAop {

	@Around( "execution(* com.cxz.controller.*.*(..))" )
	public Object check(ProceedingJoinPoint p) throws Throwable {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		HttpServletResponse response = requestAttributes.getResponse();
		String url = request.getServletPath();
		if ( url.equals("/login")) {
			Object r = p.proceed();
			return r;
		} else {
			if( url.indexOf("/")!=-1) {
				url = url.substring(url.indexOf("/",1)+1,url.lastIndexOf("/"));
			}
			User user = (User)request.getSession().getAttribute("user");
			List<Tree> trees = user.getTrees();
			Set<String> fileSet = new HashSet<String>();
			for (Tree tree : trees) {
				if( tree.getFile()!=null ) {
					String file = tree.getFile().substring(0,tree.getFile().lastIndexOf("/"));
					fileSet.add(file);
				}
			}
			if( fileSet.contains(url) ) {
				return p.proceed();
			}
			else return null;
			
		}
	}
}
