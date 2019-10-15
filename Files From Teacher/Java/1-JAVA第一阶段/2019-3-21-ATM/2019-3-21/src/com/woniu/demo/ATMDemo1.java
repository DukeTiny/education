package com.woniu.demo;

import java.util.Scanner;

public class ATMDemo1 {

	public static void main(String[] args) {
		// 存储银行卡信息 卡号；密码；姓名；余额
		String[][] cards = new String[10][4];
		cards[0] = new String[] { "1001", "123456", "andy", "10000" };
		cards[1] = new String[] { "1002", "123456", "leon", "1000" };
		cards[2] = new String[] { "1003", "123456", "jack", "100000" };
		cards[3] = new String[] { "1004", "123456", "rose", "1" };
		//获得登录卡的下标
		int nowCardIndex = -1;
		Scanner scan = new Scanner(System.in);
		// 用户输入卡号和密码的界面
		System.out.println("**************************");
		System.out.println("*欢迎使用XXX银行ATM系统       *");
		System.out.println("**************************");
		System.out.print("请输入卡号：");
		String cardId = scan.next();
		System.out.print("请输入密码：");
		String cardPwd = scan.next();
		// 判断卡号和密码是否存在
		boolean flag = false;
		for (int i = 0; i < cards.length; i++) {
			if (cardId.equals(cards[i][0]) && cardPwd.equals(cards[i][1])) {
				flag = true;
				nowCardIndex = i;
				break;
			}
		}
		if (flag) {
			// 业务界面：查看余额；存钱；取钱；转账；退卡；
			System.out.println("************");
			System.out.println("*1、存钱       *");
			System.out.println("*2、取钱       *");
			System.out.println("*3、转账       *");
			System.out.println("*4、余额       *");
			System.out.println("*5、退卡       *");
			System.out.println("************");
			int select = scan.nextInt();
			switch (select) {
			case 1:
//				System.out.println("请输入存入金额:");
//				int money = scan.nextInt();
//				int oldMoney = Integer.parseInt(cards[nowCardIndex][3]);
//				cards[nowCardIndex][3] = String.valueOf(oldMoney + money);
//				for (int j = 0; j < cards[nowCardIndex].length; j++) {
//					System.out.print(cards[nowCardIndex][j] + " ");
//				}
//				System.out.println();
				break;
			case 2:
//				System.out.print("请输入要取的金额：");
//				int money2 = scan.nextInt();
//				int oldMoney2 = Integer.parseInt(cards[nowCardIndex][3]);
//				if (money2 <= oldMoney2) {
//					cards[nowCardIndex][3] = String.valueOf(oldMoney2 - money2);
//				} else {
//					System.out.println("余额不足！");
//				}
//				for (int j = 0; j < cards[nowCardIndex].length; j++) {
//					System.out.print(cards[nowCardIndex][j] + " ");
//				}
//				System.out.println();
				break;
			case 3:
//				System.out.println("请输入对方卡号:");
//				String cardId2 = scan.next();
//				System.out.println("请输入转入金额:");
//				int money3 = scan.nextInt();
//				int otherCardIndex = -1;
//				for (int i = 0; i < cards.length; i++) {
//					if (cardId2.equals(cards[i][0])) {
//						otherCardIndex = i;
//						break;
//					}
//				}
//				if(otherCardIndex!=-1){
//					int oldMoney3 = Integer.parseInt(cards[nowCardIndex][3]);
//					cards[nowCardIndex][3] = String.valueOf(oldMoney3 - money3);
//					int oldMoney4 = Integer.parseInt(cards[otherCardIndex][3]);
//					cards[otherCardIndex][3] = String.valueOf(oldMoney4 + money3);
//				}else{
//					System.out.println("账号找不到！");
//				}
//				for (int j = 0; j < cards[nowCardIndex].length; j++) {
//					System.out.print(cards[nowCardIndex][j] + " ");
//				}
				break;
			case 4:
//				for (int j = 0; j < cards[nowCardIndex].length; j++) {
//					System.out.print(cards[nowCardIndex][j] + " ");
//				}
				break;
			case 5:
				
				break;
			}
		} else {
			System.out.println("用户名密码错误！");
		}
	}

}
