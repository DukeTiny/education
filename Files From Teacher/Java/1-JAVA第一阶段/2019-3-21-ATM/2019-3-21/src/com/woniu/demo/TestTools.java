package com.woniu.demo;

import java.util.Scanner;

public class TestTools {

	public static void main(String[] args) {
		//���һ����������
		Scanner scan = new Scanner(System.in);
//		System.out.print("������һ������:");
//		int n = scan.nextInt();
		System.out.print("������һ����:");
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
