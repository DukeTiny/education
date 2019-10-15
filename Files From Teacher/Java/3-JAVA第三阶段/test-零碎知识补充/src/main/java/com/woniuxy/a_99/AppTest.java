package com.woniuxy.a_99;

import org.junit.Test;

public class AppTest {
	@Test
	public void test99() throws Exception {
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i*j+ "\t");
			}
			System.out.println();
		}
		
	}
}
