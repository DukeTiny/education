package com.woniu.core;

import java.lang.annotation.Annotation;

public class Demo {

	public static void main(String[] args) {
		Class c = Stu.class;
		Annotation[] as = c.getAnnotations();
		for(Annotation a:as){
			System.out.println(a);
		}

	}

}
