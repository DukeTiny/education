package com.woniu.demo;

public class StringDemo1 {

	public static void main(String[] args) {
		//�����ַ�������
//		String str = new String("����ɵ��,�����ɵ��");
		//�滻�ַ��� replace();
//		str = str.replace("ɵ��", "**");
//		System.out.println(str);
		//����ַ����ĳ���
//		int len = str.length();
//		System.out.println(len);
		
		//��ȡ�ַ��� substring
//		String temp = str.substring(5);
//		System.out.println(temp);
		
//		String temp = str.substring(5, 8);
//		System.out.println(temp);
		
		//indexOf()
		//������һ���ַ���������a���ֵĴ�����
		String str = "sasafdjaisafwqa";
		int count = 0 ;
		int index = 0;
		
		while(str.indexOf("a",index)!=-1){
			count++;
			index=str.indexOf("a", index);
			index = index + 1;
		}
		System.out.println(count);
	}

}
