package com.woniu.demo;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BigDecimalDemo {

	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal("0.3");
		System.out.println(bd);
		
		NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
		String str = moneyFormat.format(bd);
		System.out.println(str);
		
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		String str2 = percentFormat.format(bd);
		System.out.println(str2);
		
		BigDecimal bd2 = new BigDecimal("0.1");
		BigDecimal bd3 = bd.add(bd2);
		System.out.println(bd3);
		bd3 = bd.subtract(bd2);
		System.out.println(bd3);
		bd3 = bd.subtract(bd2);
		System.out.println(bd3);
		bd3 = bd.multiply(bd2);
		System.out.println(bd3);
		bd3 = bd.divide(bd2);
		System.out.println(bd3);
	}

}
