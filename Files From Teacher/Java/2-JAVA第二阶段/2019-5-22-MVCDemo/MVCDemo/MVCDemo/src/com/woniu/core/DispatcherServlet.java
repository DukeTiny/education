package com.woniu.core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	Map map = new HashMap();
  
    public DispatcherServlet() {
      
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������action
		String reqAction = request.getServletPath();
		//���url��Ӧ�Ķ���
		Object target = map.get(reqAction);
		String methodName = "execute";
		if(request.getParameter("method")!=null){
			methodName = request.getParameter("method");
		}
		Class c = target.getClass();
		Method[] ms = c.getDeclaredMethods();
		for(Method m:ms){
			if(methodName.equals(m.getName())){
				Object[] params = new Object[m.getParameterCount()];
				Object[] paramValues = new Object[params.length];
				LocalVariableTableParameterNameDiscoverer dircoverer = new LocalVariableTableParameterNameDiscoverer();
				String[] strs = dircoverer.getParameterNames(m);
				for(int i=0;i<strs.length;i++){
					params[i] = strs[i];
					paramValues[i] = request.getParameter(strs[i]);
					System.out.println(params[i]+"="+paramValues[i]);
				}
				//��û����������ͺͰ�װ��
				//���request��response��session��application��out
				//��װ�����
				try {
					m.invoke(target, paramValues);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("��ܳ�ʼ����ʼ");
		//ɨ�������ÿ�����ȡ���ٽ�����ע���ȡ��
		URL url = DispatcherServlet.class.getResource("/");
		String targetDir = url.toString().substring(6);
		String pack = "com.woniu.action";
		String packDir = pack.replace(".", "\\");
		File dir = new File(targetDir+packDir);
		File[] classes = dir.listFiles();
		for(File c:classes){
			String className = c.getName();
			className = className.replace(".class", "");
			try {
				Class c2 = Class.forName(pack+"."+className);
				Object obj = c2.newInstance();
				UrlMapping urlMapping = (UrlMapping) c2.getAnnotation(UrlMapping.class);
				String urlVal = urlMapping.value();
				map.put(urlVal, obj);
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
		System.out.println("��ܳ�ʼ������");
	}

}
