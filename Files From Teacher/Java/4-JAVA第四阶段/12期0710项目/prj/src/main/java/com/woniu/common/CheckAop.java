package com.woniu.common;

import java.util.List;

import javax.xml.ws.Response;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.model.Tree;
import com.woniu.model.Userinfo;

@Aspect
@Component
public class CheckAop {
	@Around("execution(* com.woniu.controller.*.*(..))")
	public Object check(ProceedingJoinPoint p) throws Throwable {
		boolean issuccess = false;
		//request怎么来
		ServletRequestAttributes srq = 
		(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		
		//1 获取当前的请求路径
		String url = srq.getRequest().getServletPath();
		if(url.equals("/login")) {//登录
			Object obj = p.proceed();
			return obj;
		}else {
			//把请求地址最后一个/后面的代码去了
			if(url.indexOf("/")!=-1) {
				url = url.substring(0, url.lastIndexOf("/"));
				url = url.replace("/admin/", "");
			}
			
			System.out.println("=================>"+url);
			
			//2
			Userinfo info = (Userinfo)srq.getRequest().getSession().getAttribute("info");
			List<Tree> list = info.getTrees();
			for (Tree tree : list) {
				if(tree.getFile()!=null) {
					String temp = tree.getFile().substring(0,tree.getFile().lastIndexOf("/"));
					System.out.println(temp+"    "+url);
					if(temp.equals(url)) {
						issuccess = true;
						break;
					}
				}
			}
			
			if(issuccess) {
				Object obj = p.proceed();
				return obj;
			}else {
				//ModelAndView mv = new ModelAndView();
				//mv.setViewName("redirect:../index.jsp");
				return "redirect:../../index.jsp";
			}
		}
	}
}
