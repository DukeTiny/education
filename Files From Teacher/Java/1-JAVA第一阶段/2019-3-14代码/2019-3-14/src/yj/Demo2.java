package yj;

import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		//获得用户输入的分数
		Scanner s =new Scanner(System.in);
		System.out.print("请输入分数：");
		int score = s.nextInt();
		//判断分数，给出相应的提示
		if(score>=85&&score<=100){
			System.out.println("优秀");
		}else if(score>=60&&score<85){
			System.out.println("及格");
		}else if(score<60&&score>=0){
			System.out.println("不及格");
		}else{
			System.out.println("您输入的数据超出范围。");
		}
	}

}
