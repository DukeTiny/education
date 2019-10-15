package com.cxz.a;

public class CalcImpl implements ICalc {
	
	
	private void begin(String methodName,int a,int b) {
		System.out.println( methodName + "方法开始，" + "参数为" + a + "," + b );
	}
	
	private void end(String methodName,int result) {
		System.out.println( methodName + "结束，"+"结果为："+result);
	}
	
	public int add(int a, int b) {
		begin("add",a,b);
		int r = a+b;
		System.out.println("CalcImpl.add()");
		end("add",r);
		return r;
	}

	public int subtract(int a, int b) {
		begin("subtract",a,b);
		int r = a-b;
		System.out.println("CalcImpl.substract()");
		end("subtract",r);
		return r;
	}

	public int divide(int a, int b) {
		begin("divide",a,b);
		int r = a/b;
		System.out.println("CalcImpl.divide()");
		end("divide",r);
		return r;
	}

	public int multiply(int a, int b) {
		begin("multiply",a,b);
		int r = a*b;
		System.out.println("CalcImpl.mutiply()");
		end("multiply",r);
		return r;
	}

	

}
