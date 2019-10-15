package com.woniuxy.e;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 d包中的问题是: 只能使用一个拦截器，不能套多层拦截器。
*/

class ActionInvocation {
	private Method method;
	private Object target;
	private Object[] args;
	public ActionInvocation(Method method, Object target, Object[] args) {
		super();
		this.method = method;
		this.target = target;
		this.args = args;
	}
	
	public Object invoke() throws Exception {
		return method.invoke(target, args);
	}
}


interface Interceptor {
	void init();
	void destory();
	Object intercept(ActionInvocation invocation) throws Exception;
}

class MyHandler implements InvocationHandler {

	private Object target;
	private Interceptor interceptor;
	
	public MyHandler(Object target, Interceptor interceptor) {
		this.target = target;
		this.interceptor = interceptor;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object r = interceptor.intercept(new ActionInvocation(method, target, args));  // new B().intercept()
		return r;
	}
}



class MyProxy {
	
	public Object getProxy(Object target, Interceptor interceptor) {
		ClassLoader cl = MyProxy.class.getClassLoader(); 
		Class[] interfaces = target.getClass().getInterfaces();  // ICalc
		MyHandler mh = new MyHandler(target, interceptor);
		Object proxy = Proxy.newProxyInstance(cl, interfaces, mh);
		return proxy;
	}
	
	
	public Object getProxy(Object proxy)throws Exception {
		
		List<Interceptor> interceptors = new ArrayList<>();	
		
		Reader in = new FileReader("src/main/resources/foo.txt");
		BufferedReader br = new BufferedReader(in);
		
		String line = null;
		
		while((line = br.readLine()) != null) {
			interceptors.add((Interceptor) Class.forName(line).newInstance());
		}
		
		for (int i = interceptors.size() - 1; i >= 0; i--) {
			proxy = (ICalc) getProxy(proxy, interceptors.get(i));
		}

		return proxy;
	}
}

// ====================================================================================


class A implements Interceptor {

	@Override
	public void init() {
	}
	@Override
	public void destory() {
	}

	@Override
	public Object intercept(ActionInvocation invocation)  throws Exception {
		System.out.println("111111111111111111111111111a");
		Object r = invocation.invoke();
		System.out.println("222222222222222222222222222b");
		return r;
	}
}


class B implements Interceptor {

	@Override
	public void init() {
	}

	@Override
	public void destory() {
	}

	@Override
	public Object intercept(ActionInvocation invocation) throws Exception {
		System.out.println("AAAAAAAAAAAAAAAAA");
		Object r = invocation.invoke();
		System.out.println("BBBBBBBBBBBBBBBBB");
		return r;
	}
	
}

class C implements Interceptor {

	@Override
	public void init() {
	}

	@Override
	public void destory() {
	}

	@Override
	public Object intercept(ActionInvocation invocation) throws Exception {
		System.out.println("##############################");
		Object r = invocation.invoke();
		System.out.println("******************************");
		return r;
	}
	
}

public class AppTest {
	
	@Test
	public void test() throws Exception {
		// 创建目标对象
		ICalc target = new CalcImpl();
		// 创建工具类，工具类用于创建代理对象
		MyProxy mp = new MyProxy();
		ICalc proxy = (ICalc) mp.getProxy(target);
		proxy.add(1, 11);
		

	}
}

