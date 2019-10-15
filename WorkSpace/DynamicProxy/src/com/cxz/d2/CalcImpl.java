package com.cxz.d2;

public class CalcImpl implements ICalc {
	
	
	public int add(int a, int b) {
		System.out.println("CalcImpl.add()");
		int r = a+b;
		return r;
	}

	public int subtract(int a, int b) {
		System.out.println("CalcImpl.subtract()");
		int r = a-b;
		return r;
	}

	public int divide(int a, int b) {
		System.out.println("CalcImpl.divide()");
		int r = a/b;
		return r;
	}

	public int multiply(int a, int b) {
		System.out.println("CalcImpl.multiply()");
		int r = a*b;
		return r;
	}

	

}
