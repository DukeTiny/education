package com.woniu.demo;

public class StringDemo3 {

	public static void main(String[] args) {
		//ģ��һ��toCharArray()�Ĺ���
		//���ַ���ת�����ַ�����
		//charAt();�����±��ȡ�ַ����ж�Ӧ���ַ�
		String str = "abcde";
		//����һ���ַ����飬����Ϊ�ַ�������
		char[] cs = new char[str.length()];
		//ѭ������ַ�����ÿ���ַ�
		for(int i=0;i<cs.length;i++){
			char c = str.charAt(i);
			//�������������
			cs[i] = c;
		}
		
	}

}
