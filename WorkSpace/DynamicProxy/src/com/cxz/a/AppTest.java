package com.cxz.a;


import org.junit.Test;

public class AppTest {
	
	@Test
	public void test() throws Exception {
		ICalc calc = new CalcImpl();
		calc.add(1,2);
		System.out.println("================================");
		calc.divide(1,2);
		System.out.println("================================");
		calc.subtract(1,2);
		System.out.println("================================");
		calc.multiply(1,2);
	}
	
}
