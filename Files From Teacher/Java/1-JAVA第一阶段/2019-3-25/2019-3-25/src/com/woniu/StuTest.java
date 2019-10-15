package com.woniu.demo3.d1;

public class StuTest {
	public static void main(String[] args) {
		Stu s1 = new Stu();
		Stu s2 = new Stu();
		Stu.str = "abc";
		System.out.println(s1.str);
		System.out.println(s2.str);
		
	}
}
