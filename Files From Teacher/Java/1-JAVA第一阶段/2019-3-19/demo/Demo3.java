package com.woniu.demo;

import java.util.Date;
import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		//���������գ�����ǵ���ĵڼ���
		//�Ȼ��ָ�����ڡ�
		Scanner scan = new Scanner(System.in);
		System.out.print("��������:");
		int year = scan.nextInt();
		System.out.print("��������:");
		int month = scan.nextInt();
		System.out.print("��������:");
		int date = scan.nextInt();
		
		Date d1 = new Date(year-1900,month-1,date);
		Date d2 = new Date(year-1900,0,0);
		System.out.println(d2);
		long cha = d1.getTime()-d2.getTime();
		long d = cha/1000/60/60/24;
		System.out.println(d);
	}

}
