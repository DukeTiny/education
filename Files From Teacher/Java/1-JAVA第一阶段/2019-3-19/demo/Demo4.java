package com.woniu.demo;

import java.util.Date;
import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args) {
		//�������£���������ж�����
		Scanner scan = new Scanner(System.in);
		System.out.print("��������:");
		int year = scan.nextInt();
		System.out.print("��������:");
		int month = scan.nextInt();
		
		Date d= new Date(year-1900,month,0);
		System.out.println(d.getDate());
		
	}

}
