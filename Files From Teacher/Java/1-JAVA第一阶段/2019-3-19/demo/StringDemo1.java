package com.woniu.demo;

public class StringDemo1 {

	public static void main(String[] args) {
		String str = "abc";
		String str2 = new String("abc");
		byte[] bs = new byte[10];
		String str3 = new String(bs);
		char[] cs = new char[10];
		String str4 = new String(cs);
		
		//����ַ�������
		int len = str.length();
		System.out.println(len);
		//�ַ������ݱȽ�
		boolean flag = str.equals(str2);
		boolean flag5 = str.equalsIgnoreCase(str2);
		System.out.println(flag);
		//�Ƚϵ�ַ
		boolean flag2 = str==str2;
		System.out.println(flag2);
		//����ַ�����
		char[] cs2 = str.toCharArray();
		//����ֽ�����
		byte[] bs2 = str.getBytes();
		//����Ӵ���ԭ���е�һ�γ��ֵ�λ��
		int index = str.indexOf("bc");
		//����Ӵ���ԭ�������һ�γ��ֵ�λ��
		int endIndex = str.lastIndexOf("bc");
		//�ж�ԭ���Ƿ����Ӵ���ʼ
		boolean flag3 = str.startsWith("ab");
		//�ж�ԭ���Ƿ����Ӵ�����
		boolean flag4 = str.endsWith("bb");
		//�滻�ַ���
		str = str.replace("a", "z");
		//��ȡ�ַ���
		String temp = str.substring(1);
		//ת��д
		String temp1 = str.toUpperCase();
		//תСд
		String temp2 = str.toLowerCase();
		//�����±��ȡָ�����ַ�
		char c = str.charAt(0);
	}

}
