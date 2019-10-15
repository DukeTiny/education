package com.woniuxy.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoaderListener implements ServletContextListener {
	// 在web应用被部署时，就执行， 该方法的价值在于，在整个web应用生命周期之间，只执行一次！
	public void contextInitialized(ServletContextEvent sce)  { 
		
		ServletContext application = sce.getServletContext();
		
		String path = application.getInitParameter("contextConfigLocation");
		
		
		// 创建spring ioc容器
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext(path);
		// 把创建好的spring ioc容器存入application范围中
		application.setAttribute("ioc", ctx);
	}

	// 在web应用被卸载时，就执行
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("web destory...");
    }
	
}
