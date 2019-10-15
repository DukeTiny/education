package com.woniuxy.b_reflect;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {

	public static Object request2bean(HttpServletRequest request, Class clazz) {
		Object obj=null;
		try {
			 obj= clazz.newInstance();
			 
			 Field[] fields = clazz.getDeclaredFields();
			 for (Field f : fields) {
				 f.setAccessible(true);
				 String fname = f.getName();
				 String value = request.getParameter(fname);
				 if(value != null && value.trim().length() > 0) {
					 if(f.getType() == Integer.class) {
						 f.set(obj, Integer.parseInt(value));
					 } else if(f.getType() == String.class) {
						 f.set(obj, value);
					 } 
				 } 
			}
			 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return obj;
	}
	
}
