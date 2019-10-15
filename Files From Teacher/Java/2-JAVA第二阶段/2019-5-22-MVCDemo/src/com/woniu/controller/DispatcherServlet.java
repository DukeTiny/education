package com.woniu.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //声明一个map对象，用来存入注解中的url和对应类对象
	//"stuAction" stuAction的对象
	//"empAction" empAction的对象
	Map urlAndObject = new HashMap();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("in init..."); 
		URL url = DispatcherServlet.class.getResource("/");
		String pack = "com.woniu.action";
		String packDir = pack.replace(".", "\\");
		String targetDir = url.toString().substring(6);
		File dir = new File(targetDir+packDir);
		File[] classes = dir.listFiles();
		if(classes!=null){
			for(File c:classes){
				//StuAction.class
				String className = c.getName();
				className = className.substring(0,className.indexOf("."));
				try {
					//使用反射机制获得一个类的Class实例
					Class c2 = Class.forName(pack+"."+className);
					//获得action类中的注解
					Controller controller = (Controller)c2.getAnnotation(Controller.class);
					//key是url ,value是类对象
					System.out.println(controller.value());
					//在map中进行对应
					urlAndObject.put(controller.value(), c2.newInstance());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}
	
	

}
