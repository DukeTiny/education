package com.woniu.demo;

import java.util.Scanner;

public class ATM {
	Scanner scan = new Scanner(System.in);
	ATMTools atmTools = new ATMTools();
	public void showMain(){
		System.out.println("********************");
		System.out.println("*��ӭʹ��XXX����ϵͳ*");
		System.out.println("*1��ע�᣻2����¼*");
		System.out.println("********************");
		int select = scan.nextInt();
		switch(select){
			case 1:
				regUI();
				break;
			case 2:
				break;
		}
	}
	
	public void regUI(){
		System.out.print("������ע��Ŀ��ţ�");
		String cardId = scan.next();
		System.out.print("������ע������룺");
		String cardPwd = scan.next();
		System.out.print("������ע���������");
		String name = scan.next();
		System.out.print("������ע�����");
		String money = scan.next();
		atmTools.reg(cardId, cardPwd, name, money);
		atmTools.showCard(cardId);
	}
	
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.showMain();
	}

}
