package com.woniu.demo;

//java.lang
public class StringDemo2 {

	public static void main(String[] args) {
		String str = "���";
		//���ַ���ת���ַ�����
//		char[] cs = str.toCharArray();
//		for(char c:cs){
//			System.out.println(c);
//		}
		//���ַ���ת���ֽ�����
		byte[] bs = str.getBytes();
		for(byte b:bs){
			System.out.println(b);
		}
	}

}
