package com.woniu.demo;

import java.lang.reflect.Method;

import com.woniu.bean.Course;

public class Demo1 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//·´Éä»úÖÆ
//		Class
//		Method
//		Feild
		Class c = Course.class;
		//Course couse = new Course();
		Course course = (Course) c.newInstance();
		Course course2 = (Course) c.newInstance();
		Method[] methods = c.getDeclaredMethods();
		for(Method m:methods){
			String methodName = m.getName();  //setCno
			String feild = methodName.substring(3);
			if(methodName.startsWith("set")){
				System.out.println(m.getName());
				//course.setCname();
				//course.setCno();
				//course.setTno();
				m.invoke(course, rs.getString(feild));
			}
		}
	}

}
