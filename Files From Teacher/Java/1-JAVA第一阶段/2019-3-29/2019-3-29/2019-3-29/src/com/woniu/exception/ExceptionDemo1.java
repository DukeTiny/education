package com.woniu.exception;

import java.util.Scanner;

public class ExceptionDemo1 {
	public void getInput(){
		Scanner scan = new Scanner(System.in);
		try{
			System.out.println("������һ������:");
			int n = scan.nextInt();
			System.out.println("����������ȷ");
			scan.close();
			System.exit(0);
		}catch(Exception e){
			System.out.println("�����������");
			getInput();
		}finally{
		
			scan.close();
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(5/0); //��ѧ�쳣
		
		//�����±�Խ��
//		int[] nums = new int[4];
//		nums[10] = 0;
		
		//��ָ���쳣
//		ExceptionDemo1 ed = null;
//		ed.toString();
		
		//�ַ����±�Խ��
//		String str = "abc";
//		str.substring(5);
		
		//���ָ�ʽ�쳣
//		String s = "abc";
//		int i = Integer.parseInt(s);
		
		//����ת���쳣
//		ArrayList list = new ArrayList();
//		list.add("abc");
//		
//		Integer i = (Integer) list.get(0);
		
		//�����쳣
//		Scanner scan = new Scanner(System.in);
//		System.out.println("������һ������:");
//		int n = scan.nextInt();
		
		ExceptionDemo1 ed = new ExceptionDemo1();
		ed.getInput();
	}
}
