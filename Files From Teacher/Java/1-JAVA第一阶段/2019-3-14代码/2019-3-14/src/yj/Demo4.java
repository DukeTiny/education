package yj;

import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args) {
		//从键盘获得三个数，输出最大的。
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入第1个数：");
		int num1 = scan.nextInt();
		System.out.print("请输入第2个数：");
		int num2 = scan.nextInt();
		System.out.print("请输入第3个数：");
		int num3 = scan.nextInt();
		System.out.print("最大的数是");
		if(num1>=num2&&num1>=num3){
			System.out.println(num1);
		}else if(num2>=num1&&num2>=num3){
			System.out.println(num2);
		}else if(num3>=num1&&num3>=num2){
			System.out.println(num3);
		}

	}

}
