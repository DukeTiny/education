package com.woniu.demo;

public class MyString {
	public String replace(String str,String oldStr,String newStr){
		//str = "����ɵ��,�����ɵ��"
		//oldStr = "ɵ��"
		//newStr = "**"
		//��
		//��ȡ
		//�滻
		
//		String a = "����";
//		String b = ",�����ɵ��";
//		String c = a+"**"+b;
		
		//indexOf()
		int index = str.indexOf("ɵ��");
		String a = str.substring(0,index);
		String b = str.substring(index+oldStr.length());
		String temp = a+newStr+b;
		return temp;
	}
}
