package com.woniu.demo;

public class MathDemo3 {
	public static void main(String[] args) {
		//取绝对值
		int i = Math.abs(-12);
		System.out.println(i);
		
		//开方
		double d = Math.sqrt(2);
		System.out.println(d);
		
		//圆周率
		System.out.println(Math.PI);
		
		//取小于等于本数的最大整数
		double d1 = Math.floor(3.45);
		System.out.println(d1);
		
		//取大于等于本数的最小整数
		double d2 = Math.ceil(3.45);
		System.out.println(d2);
		
		//四舍五入
		int d3 = Math.round(3.5f);
		System.out.println(d3);
	}
}
