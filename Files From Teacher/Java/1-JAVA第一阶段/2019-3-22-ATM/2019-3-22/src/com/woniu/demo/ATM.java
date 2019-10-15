package com.woniu.demo;

import java.util.Scanner;

public class ATM {
	Scanner scan = new Scanner(System.in);
	ATMTools atmTools = new ATMTools();
	public void showMain(){
		System.out.println("********************");
		System.out.println("*欢迎使用XXX银行系统*");
		System.out.println("*1、注册；2、登录*");
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
		System.out.print("请输入注册的卡号：");
		String cardId = scan.next();
		System.out.print("请输入注册的密码：");
		String cardPwd = scan.next();
		System.out.print("请输入注册的姓名：");
		String name = scan.next();
		System.out.print("请输入注册的余额：");
		String money = scan.next();
		atmTools.reg(cardId, cardPwd, name, money);
		atmTools.showCard(cardId);
	}
	
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.showMain();
	}

}
