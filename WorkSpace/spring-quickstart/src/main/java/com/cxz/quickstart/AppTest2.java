package com.cxz.quickstart;


import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AppTest2 {

	
	@Test
	public void testName() throws Exception {
		CalcImpl calc = new CalcImpl();
		
		Enhancer en = new Enhancer();
		en.setSuperclass(calc.getClass());
		en.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("AAAAAAAAAAAAAAA");
				Object r = proxy.invokeSuper(obj, args);
//				Object r = method.invoke(calc, args);
				System.out.println("BBBBBBBBBBBBBBB");
				return r;
			}
		});
		CalcImpl c = (CalcImpl)en.create();
		c.add(1, 2);
	}
	
}
