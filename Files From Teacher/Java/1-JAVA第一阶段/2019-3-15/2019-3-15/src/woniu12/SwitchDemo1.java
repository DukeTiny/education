package woniu12;

import java.util.Scanner;

public class SwitchDemo1 {

	public static void main(String[] args) {
		//switch
		//case
		//default
		//break
		Scanner scan = new Scanner(System.in);
		System.out.println("��ӭʹ���й����л���Աϵͳ�������밴1��Ӣ���밴2");
		int select  = scan.nextInt();
//		if(select==1){
//			System.out.println("��ѡ���������");
//		}else if(select==2){
//			System.out.println("��ѡ�����Ӣ��");
//		}
		
		switch(select){
			
			
			default:
				System.out.println("�������ѡ������");
				break;
			case 2:
				System.out.println("��ѡ�����Ӣ��");
				break;
			case 1:
				System.out.println("��ѡ���������");
				break;
		}
	}

}
