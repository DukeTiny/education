package yj;

import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�����������ķ�����");
		int score = scan.nextInt();
		if(score>=60){
			System.out.println("��ϲ�㣬�㼰���ˡ�");
		}else{
			System.out.println("��̫���ˣ�������");
		}
	}
}
