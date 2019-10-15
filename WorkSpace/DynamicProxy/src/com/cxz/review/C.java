package com.cxz.review;

public class C implements Interceptor {

	public void init() {}

	public void destroy() {}

	public Object intercept(ActionInvocation invocation) throws Exception {
		System.out.println("CCCCCCCCCCCCCCCCCCC");
		Object r = invocation.invoke();
		System.out.println("CCCCCCCCCCCCCCCCCCC");
		return r;
	}

}
