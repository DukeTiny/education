package woniu12;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		//���Դӿ���̨�����������֣������������Ϊ0ʱ�����������롣
		Scanner scan = new Scanner(System.in);
		int select = -1;
		while(select!=0){
			System.out.print("������һ������");
			select = scan.nextInt();
			if(select==0){
				break;
			}
			System.out.println("�������������:"+select);
		}
		System.out.println("�������");
	}

}
