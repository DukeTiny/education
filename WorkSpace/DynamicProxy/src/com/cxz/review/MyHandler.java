package com.cxz.review;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
	
	private Object target;
	private Interceptor interceptor;
	
	public MyHandler(Object target,Interceptor interceptor) {
		this.target = target;
		this.interceptor = interceptor;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		ActionInvocation invocation = new ActionInvocation(method,target,args);
		Object r = interceptor.intercept(invocation);
		return r;
	}

}
