package com.woniu.demo;

import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		//Ѻ��С  
		int money = 1000;
		//�����������1-6
		int num1 = (int)(Math.random()*6)+1;
		int num2 = (int)(Math.random()*6)+1;
		int num3 = (int)(Math.random()*6)+1;
		//��ʾ�û�Ѻ����ѺС
		Scanner scan = new Scanner(System.in);
		System.out.print("1��Ѻ��2��ѺС");
		int userSel = scan.nextInt();
		System.out.print("��������ע���");
		int userMoney = scan.nextInt();
		int sum = num1+num2+num3;
		if(userSel==1){
			if(sum<=9){
				System.out.println(num1+"��"+num2+"��"+num3+"����С��������");
				money-=userMoney;
			}else{
				System.out.println(num1+"��"+num2+"��"+num3+"��������Ӯ��");
				money+=userMoney;
			}
		}else{
			if(sum<=9){
				System.out.println(num1+"��"+num2+"��"+num3+"����С����Ӯ��");
				money+=userMoney;
			}else{
				System.out.println(num1+"��"+num2+"��"+num3+"������������");
				money-=userMoney;
			}
		}
		System.out.println("������"+money);
		

	}

}
