package com.woniu.demo;

public class MathDemo {

	public static void main(String[] args) {
		//计算第一个参数的第二参数次方
		int d = (int) Math.pow(2, 3);
		System.out.println(d);
		
		int two = 1101;
		//1*2的0次方+0*2的一次方+1*2的2次方+1*2的三次方
		int sum = 0;
		int count = 0;
		while(two!=0){
			int yu = two%10;
			sum+=yu*Math.pow(2, count++);
			two/=10;
		}
		System.out.println(sum);
	}

}
