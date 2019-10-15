package com.cxz.singleton.a;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	
	@Test
	public void testName() throws Exception {
		T t = new T();
		
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(t);
			t1.start();
		}
	}
	
	
	@Test
	public void testName2() throws Exception {
		
	}
}
