package com.woniu.demo;

import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		//1�����һ��Ӣ���ַ�����������Сдת��д��
		Scanner scan = new Scanner(System.in);
//		String str = scan.next();
//		str = str.toUpperCase();
//		System.out.println(str);
		//2��ѭ���Ӽ��̻��5���ַ������������Щ�ַ����Ƿ���abc��ͷ��
//		for(int i=1;i<=5;i++){
//			System.out.print("�������"+i+"����:");
//			String str = scan.next();
//			if(str.startsWith("abc")){
//				System.out.println(str+"����abc��ͷ");
//			}else{
//				System.out.println(str+"������abc��ͷ");
//				
//			}
//		}
		//3���Ӽ��̻��һ���ַ��������������
		String str = scan.next();
		char[] cs = str.toCharArray();
		for(int i=0;i<cs.length;i++){
			char c = cs[i];
			cs[i] = (char) (c+1);
		}
		String s = new String(cs);
		System.out.println(s);
//		4����д���� ��jdk�� ȫ����Ϊ��д,���������Ļ,��ȡ�Ӵ���DK�� ���������Ļ
//		toUpperCase();
//		substring();
//		5����д����String�����ַ�����hello�� ��Ϊ ��olleh��.
		
//		6��ȥ��һ���ַ����пո�
//		replace()
//		7������һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ�����
//		toCharArray();
//		8��һ���Ӵ��������г��ֵĴ�����
//		indexOf();
	}

}
