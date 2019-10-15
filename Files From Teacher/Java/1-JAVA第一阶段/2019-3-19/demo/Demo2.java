package com.woniu.demo;

import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		//押大小  
		int money = 1000;
		//随机三个骰子1-6
		int num1 = (int)(Math.random()*6)+1;
		int num2 = (int)(Math.random()*6)+1;
		int num3 = (int)(Math.random()*6)+1;
		//提示用户押大还是押小
		Scanner scan = new Scanner(System.in);
		System.out.print("1、押大；2、押小");
		int userSel = scan.nextInt();
		System.out.print("请输入下注金额");
		int userMoney = scan.nextInt();
		int sum = num1+num2+num3;
		if(userSel==1){
			if(sum<=9){
				System.out.println(num1+"，"+num2+"，"+num3+"，开小，你输了");
				money-=userMoney;
			}else{
				System.out.println(num1+"，"+num2+"，"+num3+"，开大，你赢了");
				money+=userMoney;
			}
		}else{
			if(sum<=9){
				System.out.println(num1+"，"+num2+"，"+num3+"，开小，你赢了");
				money+=userMoney;
			}else{
				System.out.println(num1+"，"+num2+"，"+num3+"，开大，你输了");
				money-=userMoney;
			}
		}
		System.out.println("您的余额："+money);
		

	}

}
