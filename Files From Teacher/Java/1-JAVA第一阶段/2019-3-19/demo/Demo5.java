package com.woniu.demo;

import java.util.Calendar;

public class Demo5 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
//		c.set(Calendar.YEAR, 2012);
//		int year = c.get(Calendar.YEAR);
		c.add(Calendar.YEAR, +1);
		System.out.println(c.getTime());

	}

}
