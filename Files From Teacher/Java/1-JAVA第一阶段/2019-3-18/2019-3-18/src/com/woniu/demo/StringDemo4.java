package com.woniu.demo;

public class StringDemo4 {

	public static void main(String[] args) {
		String str = "abCdE";
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
		//�Ƚ��ַ���תΪ�ֽ�����
		byte[] bs = str.getBytes();
		//ѭ������ÿ���ֽ�
		for(int i=0;i<bs.length;i++){
//			//�жϸ��ֽ��Ƿ�ΪСд��ĸ
//			if(bs[i]>=97&&bs[i]<=122){
//				//���ΪСд��ĸ������ֵתΪ��д��
//				bs[i] = (byte) (bs[i]-32);
//			}
			if(bs[i]>=65&&bs[i]<=90){
				//���ΪСд��ĸ������ֵתΪ��д��
				bs[i] = (byte) (bs[i]+32);
			}
		}
		for(byte b:bs){
			System.out.print((char)b);
		}	
	}

}
