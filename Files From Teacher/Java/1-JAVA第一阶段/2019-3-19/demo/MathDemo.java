package com.woniu.demo;

public class MathDemo {

	public static void main(String[] args) {
		//�����һ�������ĵڶ������η�
		int d = (int) Math.pow(2, 3);
		System.out.println(d);
		
		int two = 1101;
		//1*2��0�η�+0*2��һ�η�+1*2��2�η�+1*2�����η�
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
