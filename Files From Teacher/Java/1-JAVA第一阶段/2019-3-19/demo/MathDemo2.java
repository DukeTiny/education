package com.woniu.demo;

public class MathDemo2 {

	public static void main(String[] args) {
		//随机数(>=0,<1)
//		double d = Math.random();
//		System.out.println(d);
		
		//随机一个1-10的整数
//		int i = (int)(Math.random()*10)+1;
//		System.out.println(i);
		
		//随机一个1000以内50的倍数
//		int j = ((int)(Math.random()*(1000/50))+1)*50;
//		System.out.println(j);
		
		//随机一个1000-2000的数字
		int k = ((int)(Math.random()*1001))+1000;
		System.out.println(k);
	}

}
