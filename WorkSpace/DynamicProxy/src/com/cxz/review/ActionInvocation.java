package com.cxz.review;

import java.lang.reflect.Method;

public class ActionInvocation {
	
	private Method method;
	private Object target;
	private Object[] args;
	
	
	public ActionInvocation(Method method,Object target,Object[] args) {
		this.method = method;
		this.target = target;
		this.args = args;;
	}
	
	
	public Object invoke() throws Exception{
		Object r = method.invoke(target,args);
		return r;
	}
	
	
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
	
	
}
