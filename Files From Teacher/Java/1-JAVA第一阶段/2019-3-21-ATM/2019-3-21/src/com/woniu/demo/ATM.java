package com.woniu.demo;

import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		//声明数组存放卡的信息
		String[][] cards = {
				{"1001","123456","Andy","1000"},
				{"1002","123456","Jack","10000"},
				{"1003","123456","Leon","100"}
		};
		//声明登录界面
		System.out.println("******************");
		System.out.println("******************");
		System.out.println("******************");
		Scanner scan = new Scanner(System.in);
		System.out.print("卡号：");
		String cardId = scan.next();
		System.out.println("密码：");
		String cardPwd = scan.next();
		//获得登录信息与数组中的卡进行比对
		int nowCardIndex = -1;   //声明登录卡的下标
		for(int i=0;i<cards.length;i++){
			String cardId2 = cards[i][0];
			String cardPwd2 = cards[i][1];
			if(cardId.equals(cardId2)&&cardPwd.equals(cardPwd2)){
				nowCardIndex = i;
				break;
			}
		}
		if(nowCardIndex!=-1){
			int select = 0;
			while(select!=5){
				//如果卡号密码正确进入二级操作界面，否则提示卡号密码错误
				System.out.println("******************");
				System.out.println("*1、存；2、取；3、转；4、查；5、退；*");
				System.out.println("******************");
				select = scan.nextInt();
				switch(select){
				case 1:
					System.out.print("请输入存入的金额：");
					int money = scan.nextInt();
					int oldMoney = Integer.parseInt(cards[nowCardIndex][3]);
					cards[nowCardIndex][3] = String.valueOf(oldMoney+money);
					System.out.println(cards[nowCardIndex][2]+"的余额是:"+cards[nowCardIndex][3]+"元");
					break;
				case 2:
					System.out.print("请输入取出的金额：");
					int money2 = scan.nextInt();
					int oldMoney2 = Integer.parseInt(cards[nowCardIndex][3]);
					if(money2<=oldMoney2){
						cards[nowCardIndex][3] = String.valueOf(oldMoney2-money2);
					}else{
						System.out.println("余额不足！");
					}
					System.out.println(cards[nowCardIndex][2]+"的余额是:"+cards[nowCardIndex][3]+"元");
					break;
				case 3:
					System.out.print("请输入转入的卡号：");
					String cardId3 = scan.next();
					System.out.print("请输入转入的金额：");
					int money3 = scan.nextInt();
					int otherCardIndex = -1;
					for(int i=0;i<cards.length;i++){
						String cardId2 = cards[i][0];
						if(cardId3.equals(cardId2)){
							otherCardIndex = i;
							break;
						}
					}
					if(otherCardIndex!=-1){
						int oldMoney3 = Integer.parseInt(cards[nowCardIndex][3]);
						int oldMoney4 = Integer.parseInt(cards[otherCardIndex][3]);
						if(money3<=oldMoney3){
							cards[nowCardIndex][3] = String.valueOf(oldMoney3-money3);
							cards[otherCardIndex][3] = String.valueOf(oldMoney4+money3);
						}else{
							System.out.println("余额不足！");
						}
					}else{
						System.out.println("转入的账号不存在！");
					}
					System.out.println(cards[nowCardIndex][2]+"的余额是:"+cards[nowCardIndex][3]+"元");
					break;
				case 4:
					System.out.println(cards[nowCardIndex][2]+"的余额是:"+cards[nowCardIndex][3]+"元");
					break;
				case 5:
					System.out.println("欢迎下次再来！");
					break;
				}
			}
		}else{
			System.out.println("卡号密码错误！");
		}
		
	}
}
