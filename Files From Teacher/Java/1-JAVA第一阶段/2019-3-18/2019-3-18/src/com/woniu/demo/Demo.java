package com.woniu.demo;

public class Demo {

	public static void main(String[] args) {
		//������һ���ַ���������a���ֵĴ�����
		//String indexOf(String targetStr,int fromIndex);
		//�ҵ�targetStr��ԭ���д�fromIndex��ʼ��һ�γ��ֵ�λ�á�
		String str = "erewafsadfasfwe";
		int count = 0;
		//ÿ���ҵ�a��λ��
		int index = 0;
		//��ʼ���ҵ�λ��
		int fromIndex = 0;
		while(str.indexOf("a",fromIndex)!=-1){
			count++;
			index = str.indexOf("a",fromIndex);
			fromIndex = index + 1;
		}
		System.out.println(count);
	}

}
