package com.woniuxy.b;

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

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName()+"开始，参数是：" + Arrays.toString(args));
		
		for (Object obj : args) {
			if(obj instanceof Integer) {
				Integer i = (Integer) obj;
				if(i < 1) {
					throw new RuntimeException("参数必须大于0");
				}
			}
		}
		
		// 放行，这里就是调用真正的目标方法，真实方法
		Object r = null;
		r = method.invoke(target, args);  
		System.out.println(method.getName()+"结束，结果是：" + r);

		return r;
	}
	
}

public class AppTest {
	
	@Test
	public void test() throws Exception {
		 ICalc c = new CalcImpl();
		 
		// 利用动态代理，创建一个代理对象.
		// 利用动态代理，创建代理对象时，需要传入3个参数
		
		// 第一个参数：ClassLoader，是类加载器
		/*
		 	类加载器的作用就是用来加载类的。当我们实例化一个类的对象时，类加载器一定会先把该类的字节码加载到内存中。
		 	然后在用内存中的字节码来生成类的实例。
		 	下面的代码虽然没有使用构造器来创建对象，而是使用动态代理这么一种“不正常”的方式来创建对象的。但是就是是不正常的方式
		 	创建对象，也仍然需要类加载器来加载字节码到内存中。
		*/
		ClassLoader cl = AppTest.class.getClassLoader(); 
		
		
		// 第二个参数：Class[] 字节码数组
		/*
		 	下面的代码，是用来创建代理对象的，创建代理对象之前，jvm会在内存中动态地生成一个类字节码，这个字节码表示的类会自动实现
		 	第二个参数中的接口.
		*/
		Class[] interfaces = new Class[] {ICalc.class};
		
		// 第三个参数：InvocationHandler
		/*
		 	每次对代理对象任何方法的调用，都不会调用真正的方法，而是统统进入InvocationHandler的invoke方法中！
		*/
		MyHandler mh = new MyHandler(c);
		
		ICalc proxy = (ICalc)Proxy.newProxyInstance(cl, interfaces, mh);
		
		Object obj = proxy.add(1, -2);
		System.out.println(obj);
		
		
	}
}
