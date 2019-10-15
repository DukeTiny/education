package com.cxz.d;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

interface Interceptor {
	Object init();
	Object destroy();
	Object intercept(Method method,Object target,Object[] parameters)throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}

class A implements Interceptor{

	public Object init() {
		return null;
	}

	public Object destroy() {
		return null;
	}
	
	/*
	 * 老师写的该方法中，可以对method.invoke加执行条件，
	 * 可以控制是否对该方法进行放行，如if(a<0),则执行method.invoke,else则没有，或者什么都不做。
	 * 对method是否执行的可操作性比较强。
	 */

	public Object intercept(Method method, Object target, Object[] parameters) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("开始了");
		Object r = method.invoke(target,parameters);
		System.out.println("结束了");
		return r;
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
		interceptor.intercept(method,target,args);
		return 1;
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
		proxy.add(1,2);
	}
}
