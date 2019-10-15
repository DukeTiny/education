package com.cxz.review;

public interface Interceptor {
	
	void init();
	void destroy();
	Object intercept(ActionInvocation invocation) throws Exception;
	
}
