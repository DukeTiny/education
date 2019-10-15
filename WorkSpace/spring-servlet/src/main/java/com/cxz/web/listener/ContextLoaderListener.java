package com.cxz.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoaderListener implements ServletContextListener {
	
	
	
	public void contextInitialized(ServletContextEvent sce)  { 
		System.out.println("init ............");
		ServletContext servletContext = sce.getServletContext();
		String path = servletContext.getInitParameter("contextConfigLoader");
		
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext(path);
		servletContext.setAttribute("ioc", ctx);
    }
	
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    	System.out.println("destroy.......");
    }
    
    
	
}
