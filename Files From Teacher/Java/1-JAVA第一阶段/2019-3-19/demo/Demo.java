package com.woniu.demo;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		//ʯͷ���Ӳ�
		//�û�����ʯͷ������
		Scanner scan = new Scanner(System.in);
		String user = "";
		while(!user.equals("exit")){
			System.out.print("������ʯͷ������");
			user = scan.nextLine();
			//�������ʯͷ������
			int computer = (int)(Math.random()*3);//0.ʯͷ1.����2.��
			//�ж���Ӯ
			switch(computer){
				case 0:
					if(user.equals("ʯͷ")){
						System.out.println("�û���ʯͷ�����Գ�ʯͷ��ƽ");
					}else if(user.equals("����")){
						System.out.println("�û������������Գ�ʯͷ������ʤ");
					}else if(user.equals("��")){
						System.out.println("�û����������Գ�ʯͷ���û�ʤ");
					}
					break;
				case 1:
					if(user.equals("ʯͷ")){
						System.out.println("�û���ʯͷ�����Գ��������û�ʤ");
					}else if(user.equals("����")){
						System.out.println("�û������������Գ�������ƽ");
					}else if(user.equals("��")){
						System.out.println("�û����������Գ�����������ʤ");
					}
					break;
				case 2:
					if(user.equals("ʯͷ")){
						System.out.println("�û���ʯͷ�����Գ���������ʤ");
					}else if(user.equals("����")){
						System.out.println("�û������������Գ������û�ʤ");
					}else if(user.equals("��")){
						System.out.println("�û����������Գ�����ƽ");
					}
					break;
			}
		}
	}

}
