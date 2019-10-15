package com.woniuxy.a;

import org.junit.Test;

public class AppTest {

	@Test
	public void test() throws Exception {
		ICalc c = new CalcImpl();
		c.add(3, 7);
		c.sub(3, 7);
		c.mul(3, 7);
		c.div(3, 7);
	}
	
}
