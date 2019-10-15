package com.woniu.demo;

public class Demo3 {
	//»ñµÃ×Ö·û´®³¤¶È
	public int length(String str){
		char[] cs = str.toCharArray();
		return cs.length;
	}
	//Ìæ»»×Ö·û´®
	public String replace(String str,String oldStr,String newStr){
		//"abcdefg"
		while(str.indexOf(oldStr)!=-1){
			int start = str.indexOf("e");
			int end = start+"e".length();
			String front = str.substring(0, start);
			String back = str.substring(end);
			str = front+newStr+back;
		}
		return str;
	}
	
	public static void main(String[] args) {
		String str = "abcdefeg";
		Demo3 d = new Demo3();
//		int len = d.length(str);
//		System.out.println(len);
		
		str = d.replace(str,"e", "z");
		System.out.println(str);
	}
}
