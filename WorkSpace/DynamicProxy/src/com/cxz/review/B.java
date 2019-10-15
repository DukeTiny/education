package com.cxz.review;

public class B implements Interceptor {

	public void init() {}

	public void destroy() {}

	public Object intercept(ActionInvocation invocation) throws Exception {
		System.out.println("BBBBBBBBBBBBBBBBBBBB");
		Object r = invocation.invoke();
		System.out.println("BBBBBBBBBBBBBBBBBBBB");
		return r;
	}

}
