package com.woniu.demo;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		//石头剪子布
		//用户输入石头剪刀布
		Scanner scan = new Scanner(System.in);
		String user = "";
		while(!user.equals("exit")){
			System.out.print("请输入石头剪刀布");
			user = scan.nextLine();
			//电脑随机石头剪刀布
			int computer = (int)(Math.random()*3);//0.石头1.剪刀2.布
			//判断输赢
			switch(computer){
				case 0:
					if(user.equals("石头")){
						System.out.println("用户出石头，电脑出石头，平");
					}else if(user.equals("剪刀")){
						System.out.println("用户出剪刀，电脑出石头，电脑胜");
					}else if(user.equals("布")){
						System.out.println("用户出布，电脑出石头，用户胜");
					}
					break;
				case 1:
					if(user.equals("石头")){
						System.out.println("用户出石头，电脑出剪刀，用户胜");
					}else if(user.equals("剪刀")){
						System.out.println("用户出剪刀，电脑出剪刀，平");
					}else if(user.equals("布")){
						System.out.println("用户出布，电脑出剪刀，电脑胜");
					}
					break;
				case 2:
					if(user.equals("石头")){
						System.out.println("用户出石头，电脑出布，电脑胜");
					}else if(user.equals("剪刀")){
						System.out.println("用户出剪刀，电脑出布，用户胜");
					}else if(user.equals("布")){
						System.out.println("用户出布，电脑出布，平");
					}
					break;
			}
		}
	}

}
