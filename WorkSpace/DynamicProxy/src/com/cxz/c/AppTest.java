package com.cxz.c;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.junit.Test;



class MyHandler implements InvocationHandler {

	private Object target;
	
	
	
	public MyHandler(Object target) {
		this.target = target;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName() + "()方法开始，参数为：" + Arrays.toString(args));
		Object r = method.invoke(target,args);
		System.out.println(method.getName() + "()方法结束，结果为：" + r);
		System.out.println("=========================================");
		return 1;
	}

}

class MyProxy {
	
	public Object getProxy(Object target) {
		ClassLoader cl = target.getClass().getClassLoader();
		InvocationHandler myHandler = new MyHandler(target);
		return Proxy.newProxyInstance(cl,CalcImpl.class.getInterfaces(),myHandler);
	}
	
}
public class AppTest {
		
	@Test
	public void test() throws Exception {
		MyProxy mp = new MyProxy();
		ICalc calc = new CalcImpl();
		ICalc proxy = (ICalc)mp.getProxy(calc);
		proxy.add(1,2);
	}
}
