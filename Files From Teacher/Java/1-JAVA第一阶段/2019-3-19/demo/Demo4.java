package com.woniu.demo;

import java.util.Date;
import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args) {
		//给出年月，输出当月有多少天
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入年:");
		int year = scan.nextInt();
		System.out.print("请输入月:");
		int month = scan.nextInt();
		
		Date d= new Date(year-1900,month,0);
		System.out.println(d.getDate());
		
	}

}
