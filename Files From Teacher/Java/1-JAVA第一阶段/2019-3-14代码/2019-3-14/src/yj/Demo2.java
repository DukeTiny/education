package yj;

import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		//����û�����ķ���
		Scanner s =new Scanner(System.in);
		System.out.print("�����������");
		int score = s.nextInt();
		//�жϷ�����������Ӧ����ʾ
		if(score>=85&&score<=100){
			System.out.println("����");
		}else if(score>=60&&score<85){
			System.out.println("����");
		}else if(score<60&&score>=0){
			System.out.println("������");
		}else{
			System.out.println("����������ݳ�����Χ��");
		}
	}

}
