package com.woniuxy.d;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.junit.Test;

/*
 c���е������ǣ���������������飬�������߾����ģ�Ӧ�����û�����
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

public class AppTest {
	
	@Test
	public void test() throws Exception {
		// ����Ŀ�����
		ICalc c = new CalcImpl();
		// ���������࣬���������ڴ����������
		MyProxy mp = new MyProxy();
		// ʹ�ù������������������
		ICalc proxy = (ICalc) mp.getProxy(c, new B());
		proxy.add(1, 2);
	}
}

