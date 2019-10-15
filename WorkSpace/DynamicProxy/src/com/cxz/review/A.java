package com.cxz.review;

public class A implements Interceptor {

	@Override
	public void init() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public Object intercept(ActionInvocation invocation) throws Exception{
		System.out.println("AAAAAAAAAAAAAAAAAAAA");
		Object r = invocation.invoke();
		System.out.println("AAAAAAAAAAAAAAAAAAAA");
		return r;
	}

}
