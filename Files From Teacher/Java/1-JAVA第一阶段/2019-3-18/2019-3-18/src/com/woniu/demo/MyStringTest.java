package com.woniu.demo;

public class MyStringTest {

	public static void main(String[] args) {
		String str = "你是傻子，你就是傻子";
		String oldStr = "傻子";
		String newStr = "**";
		MyString ms = new MyString();
		String temp = ms.replace(str, oldStr, newStr);
		System.out.println(temp);
	}

}
