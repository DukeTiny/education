package com.woniu.exception;

import java.util.Scanner;

public class ExceptionDemo1 {
	public void getInput(){
		Scanner scan = new Scanner(System.in);
		try{
			System.out.println("请输入一个整数:");
			int n = scan.nextInt();
			System.out.println("数据输入正确");
			scan.close();
			System.exit(0);
		}catch(Exception e){
			System.out.println("数据输入错误");
			getInput();
		}finally{
		
			scan.close();
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(5/0); //数学异常
		
		//数组下标越界
//		int[] nums = new int[4];
//		nums[10] = 0;
		
		//空指针异常
//		ExceptionDemo1 ed = null;
//		ed.toString();
		
		//字符串下标越界
//		String str = "abc";
//		str.substring(5);
		
		//数字格式异常
//		String s = "abc";
//		int i = Integer.parseInt(s);
		
		//类型转换异常
//		ArrayList list = new ArrayList();
//		list.add("abc");
//		
//		Integer i = (Integer) list.get(0);
		
		//输入异常
//		Scanner scan = new Scanner(System.in);
//		System.out.println("请输入一个整数:");
//		int n = scan.nextInt();
		
		ExceptionDemo1 ed = new ExceptionDemo1();
		ed.getInput();
	}
}
