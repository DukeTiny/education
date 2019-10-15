package com.woniu.core;

import java.lang.annotation.Annotation;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class c = Class.forName("com.woniu.action.StuAction");
		Annotation[] as = c.getAnnotations();
		for(Annotation a:as){
			System.out.println(a.annotationType().getFields().length);
		}
	}
}
