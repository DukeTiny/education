package com.woniu.demo;

public class MyStringTest {

	public static void main(String[] args) {
		String str = "����ɵ�ӣ������ɵ��";
		String oldStr = "ɵ��";
		String newStr = "**";
		MyString ms = new MyString();
		String temp = ms.replace(str, oldStr, newStr);
		System.out.println(temp);
	}

}
