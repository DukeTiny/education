package com.woniu.demo;

public class Tools2 {
	//���һ��������Լ��
	public void getYueShu(int num){
		for(int i=1;i<=num/2;i++){
			if(num%i==0){
				System.out.println(i);
			}
		}
	}
	
	//����������Ĺ�Լ��
	public void getYueShu(int num1,int num2){
		for(int i=1;i<=(num1>num2?num2:num1);i++){
			if(num2%i==0&&num1%i==0){
				System.out.println(i);
			}
		}
	}
	
	//��������������Լ��
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
		
		//շת�����
		//10 	15
		//����������������
		//��������������
		//������Ϊ0ʱ������Ϊ���Լ��
		while(num2!=0){
			int yu = num1 % num2;
			num1 = num2;
			num2 = yu;
		}
		System.out.println(num1);
	}
}
