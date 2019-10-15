package com.woniuxy.a;

public class CalcImpl implements ICalc {

	private void begin(String methodName, int a, int b) {
		System.out.println(methodName+" method begin£¬args are£º" + a + "," + b);
	}
	
	private void end(String methodName, int r) {
		System.out.println(methodName+"method end£¬result is£º" + r);
	}
	
	@Override
	public int add(int a, int b) {
		begin("add", a, b);
		int r = a + b;
		System.out.println("CalcImpl.add()");
		end("add", r);
		return r;
	}

	@Override
	public int sub(int a, int b) {
		begin("sub", a, b);
		int r = a - b;
		System.out.println("CalcImpl.sub()");
		end("sub", r);
		return r;
	}

	@Override
	public int mul(int a, int b) {
		begin("mul", a, b);
		int r = a * b;
		System.out.println("CalcImpl.mul()");
		end("mul", r);
		return r;
	}

	@Override
	public int div(int a, int b) {
		begin("div", a, b);
		int r = a / b;
		System.out.println("CalcImpl.div()");
		end("div", r);
		return r;
	}




}
