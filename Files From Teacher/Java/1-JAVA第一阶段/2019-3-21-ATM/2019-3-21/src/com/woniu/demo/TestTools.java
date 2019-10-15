package com.woniu.demo;

import java.util.Scanner;

public class TestTools {

	public static void main(String[] args) {
		//获得一个二进制数
		Scanner scan = new Scanner(System.in);
//		System.out.print("请输入一个进制:");
//		int n = scan.nextInt();
		System.out.print("请输入一个数:");
		String numStr = scan.next();
		
		
		Tools tools = new Tools();
//		int ten = tools.nToTen(n,numStr);
//		System.out.println(ten);
		
		int ten = Integer.parseInt(numStr);
		String two = tools.tenToTwo(ten);
		System.out.println(two);
		
//		Integer i = 10;
//		Integer.parseInt(s);
//		System.out.println(i+11);
	}

}
