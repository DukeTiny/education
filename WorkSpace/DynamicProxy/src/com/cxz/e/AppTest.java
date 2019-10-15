package com.cxz.e;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

interface Interceptor {
	Object init();
	Object destroy();
	Object intercept(Method method,Object target,Object[] parameters) throws Exception;
}

class A implements Interceptor {
	public Object init() {
		return null;
	}
	public Object destroy() {
		return null;
	}

	@Override
	public Object intercept(Method method, Object target, Object[] parameters) throws Exception {
		System.out.println("#1111111111111111");
		Object r = method.invoke(target,parameters);
		System.out.println("@1111111111111111");
		return r;
	}
}

class B implements Interceptor {
	public Object init() {
		return null;
	}
	public Object destroy() {
		return null;
	}
	public Object intercept(Method method, Object target, Object[] parameters) throws Exception {
		System.out.println("#222222222222222222222");
		Object r = method.invoke(target,parameters);
		System.out.println("@222222222222222222222");
		return r;
	}
}


class C implements Interceptor {
	public Object init() {
		return null;
	}
	public Object destroy() {
		return null;
	}
	public Object intercept(Method method, Object target, Object[] parameters) throws Exception {
		System.out.println("#3333333333333333333333");
		Object r = method.invoke(target,parameters);
		System.out.println("@3333333333333333333333");
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
		return interceptor.intercept(method,target,args);
	}

}

class MyProxy {
	
	private BufferedReader br;
	private Object getProxy(Object target,Interceptor interceptor) {
		ClassLoader cl = target.getClass().getClassLoader();
		InvocationHandler myHandler = new MyHandler(target,interceptor);
		return Proxy.newProxyInstance(cl,CalcImpl.class.getInterfaces(),myHandler);
	}
	public Object getProxy(Object proxy) throws Exception{
		List<Interceptor> interceptors = new ArrayList<>();
		Reader reader = new FileReader("src/com/cxz/e/interceptor.txt");
		br = new BufferedReader(reader);
		String line = null;
		while((line = br.readLine())!=null) {
			Interceptor interceptor = (Interceptor)(Class.forName(line).newInstance());
			interceptors.add(interceptor);
		}
		for( int i=interceptors.size()-1; i>=0; i-- ) {
			proxy = getProxy(proxy,interceptors.get(i));
		}
		return proxy;
	}
	
}
public class AppTest {
		
	@Test
	public void test() throws Exception {
		MyProxy mp = new MyProxy();
		ICalc calc = new CalcImpl();
		ICalc proxy = (ICalc)mp.getProxy(calc);
		Object r = proxy.add(3,4);
		System.out.println(r);
	}
}
