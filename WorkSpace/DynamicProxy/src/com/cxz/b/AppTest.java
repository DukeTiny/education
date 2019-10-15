package com.cxz.b;


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
public class AppTest {
	
	
	@Test
	public void test() throws Exception {
		ClassLoader cl = AppTest.class.getClassLoader();
		InvocationHandler myHandler = new MyHandler(new CalcImpl());
		ICalc proxy = (ICalc) Proxy.newProxyInstance(cl,CalcImpl.class.getInterfaces(),myHandler);
		proxy.add(1,2);
		proxy.divide(1,2);
		proxy.subtract(1,2);
		proxy.multiply(1,2);
	}
}
