package woniu12;

import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		//任意输入一个整数（小于10位），求它一共有多少位。
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.print("数字："+num);
		//12345		
		//1234
		//123
		//12
		//1
		//0
		int count = 0;
		while(num>0){
			count++;
			num=num/10;
		}
		System.out.println("的位数是"+count);
	}

}
