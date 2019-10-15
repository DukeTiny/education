package com.woniuxy.g_finally;

import org.junit.Test;

public class AppTest {
	
	public int f1() {
		try {
			int[] a = new int[10];
			a[999] = 1;
			return 5;
		} catch (Exception e) {
			String str = null;
			System.out.println(str.charAt(0));
			return 6;
		} finally {
			// 在finally中，如果有返回值或抛出异常，则
			// try或catch中的返回值或异常丢失
			return 7;  
			// System.out.println(8/0);
		}
	}
	
	public int f2() {
		int a;
		try {
			a = 10;
			return a;  // return 10;
		} catch (Exception e) {
			a = 20;
			return a;
		} finally {
			a = 30;
		}
	}
	
	// 10  30  
	
	@Test
	public void test() throws Exception {
		System.out.println(f2());
	}
}
