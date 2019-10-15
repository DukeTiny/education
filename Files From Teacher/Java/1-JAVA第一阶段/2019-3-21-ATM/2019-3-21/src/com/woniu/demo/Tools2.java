package com.woniu.demo;

public class Tools2 {
	//获得一个数所有约数
	public void getYueShu(int num){
		for(int i=1;i<=num/2;i++){
			if(num%i==0){
				System.out.println(i);
			}
		}
	}
	
	//获得两个数的公约数
	public void getYueShu(int num1,int num2){
		for(int i=1;i<=(num1>num2?num2:num1);i++){
			if(num2%i==0&&num1%i==0){
				System.out.println(i);
			}
		}
	}
	
	//获得两个数的最大公约数
	public void getMaxYueShu(int num1,int num2){
//		int gys = 1;
//		for(int i=1;i<=(num1>num2?num2:num1);i++){
//			if(num2%i==0&&num1%i==0){
//				gys = i;
//			}
//		}
//		System.out.println(gys);
		
//		for(int i=(num1>num2?num2:num1);i>=1;i--){
//			if(num2%i==0&&num1%i==0){
//				System.out.println(i);
//				break;
//			}
//		}
		
		//辗转相除法
		//10 	15
		//将除数赋给被除数
		//将余数赋给除数
		//当余数为0时，除数为最大公约数
		while(num2!=0){
			int yu = num1 % num2;
			num1 = num2;
			num2 = yu;
		}
		System.out.println(num1);
	}
}
