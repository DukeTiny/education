package yj;

import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入张三的分数：");
		int score = scan.nextInt();
		if(score>=60){
			System.out.println("恭喜你，你及格了。");
		}else{
			System.out.println("你太菜了，不及格。");
		}
	}
}
