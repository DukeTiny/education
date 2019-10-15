package com.cxz.d2;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

interface Interceptor {
	void init();
	void destroy();
	void intercept();
}

class A implements Interceptor{
	
	/*
	 * 我自己写的该方法中，method的方法是肯定会放行的，但是呢，有时候是不能够放行的，
	 * 所以该方法的可操作性比较差。
	 */

	public void init() {
		System.out.println("方法开始了 ");
	}

	public void destroy() {
		System.out.println("方法结束了");
	}

	public void intercept() {
	}
	
}


class MyHandler implements InvocationHandler {

	private Object target;
	private Interceptor interceptor;
	
	
	public MyHandler(Object target,Interceptor interceptor) {
		this.target = target;
		this.interceptor = interceptor;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		interceptor.init();
		Object r = method.invoke(target,args);
		interceptor.destroy();
		System.out.println("==========================");
		return r;
	}

}

class MyProxy {
	
	public Object getProxy(Object target,Interceptor interceptor) {
		ClassLoader cl = target.getClass().getClassLoader();
		InvocationHandler myHandler = new MyHandler(target,interceptor);
		return Proxy.newProxyInstance(cl,CalcImpl.class.getInterfaces(),myHandler);
	}
	
}
public class AppTest {
		
	@Test
	public void test() throws Exception {
		MyProxy mp = new MyProxy();
		ICalc calc = new CalcImpl();
		A a = new A();
		ICalc proxy = (ICalc)mp.getProxy(calc,a);
		Object r = proxy.add(2,3); 
		System.out.println(r);
	}
}
