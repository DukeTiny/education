package com.woniu.demo;

public class MathDemo2 {

	public static void main(String[] args) {
		//�����(>=0,<1)
//		double d = Math.random();
//		System.out.println(d);
		
		//���һ��1-10������
//		int i = (int)(Math.random()*10)+1;
//		System.out.println(i);
		
		//���һ��1000����50�ı���
//		int j = ((int)(Math.random()*(1000/50))+1)*50;
//		System.out.println(j);
		
		//���һ��1000-2000������
		int k = ((int)(Math.random()*1001))+1000;
		System.out.println(k);
	}

}
