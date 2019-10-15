package woniu12;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		//可以从控制台连续输入数字，当输入的数字为0时不可以再输入。
		Scanner scan = new Scanner(System.in);
		int select = -1;
		while(select!=0){
			System.out.print("请输入一个数字");
			select = scan.nextInt();
			if(select==0){
				break;
			}
			System.out.println("您输入的数字是:"+select);
		}
		System.out.println("程序结束");
	}

}
