package woniu12;

import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		//��������һ��������С��10λ��������һ���ж���λ��
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.print("���֣�"+num);
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
		System.out.println("��λ����"+count);
	}

}
