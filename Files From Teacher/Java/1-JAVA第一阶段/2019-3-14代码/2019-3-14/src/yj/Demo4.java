package yj;

import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args) {
		//�Ӽ��̻����������������ġ�
		Scanner scan = new Scanner(System.in);
		System.out.print("�������1������");
		int num1 = scan.nextInt();
		System.out.print("�������2������");
		int num2 = scan.nextInt();
		System.out.print("�������3������");
		int num3 = scan.nextInt();
		System.out.print("��������");
		if(num1>=num2&&num1>=num3){
			System.out.println(num1);
		}else if(num2>=num1&&num2>=num3){
			System.out.println(num2);
		}else if(num3>=num1&&num3>=num2){
			System.out.println(num3);
		}

	}

}
