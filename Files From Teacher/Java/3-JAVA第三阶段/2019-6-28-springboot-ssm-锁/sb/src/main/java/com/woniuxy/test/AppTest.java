package com.woniuxy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = //
				new AnnotationConfigApplicationContext(RootConfig.class);
		
		
		String[] names = ctx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name + "---" + ctx.getBean(name));
			
		}
	}
	
	
}