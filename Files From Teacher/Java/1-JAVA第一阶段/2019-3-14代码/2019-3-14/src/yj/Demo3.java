package yj;

import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		//�趨������Ϣ
		int cardPwd = 123456;
		int cardMoney = 500;
		//������п�����
		System.out.println("��ӭʹ����������ATM��");
		Scanner scan = new Scanner(System.in);
		System.out.print("�������������룺");
		int userPwd = scan.nextInt();
		//�ж������Ƿ���ȷ����ȷ����atm���棬�������������
		if(cardPwd==userPwd){
			//�ж��û��滹��ȡ�������Ӧ����
			System.out.print("����Ҫ�滹��ȡ��ѡ1�棬ѡ2ȡ��");
			int select = scan.nextInt();
			if(select==1){
				System.out.print("��������Ҫ����Ľ��:");
				int money = scan.nextInt();
				System.out.println("������"+money+"Ԫ�����Ϊ"+(cardMoney+money)+"Ԫ");
			}else if(select==2){
				//����û�������
				//�жϽ���Ƿ�Ϸ�
				System.out.print("��������Ҫȡ���Ľ��:");
				int money = scan.nextInt();
				if(money<=cardMoney){
					System.out.println("��ȡ��"+money+"Ԫ�����Ϊ"+(cardMoney-money)+"Ԫ");
				}else{
					System.out.println("���㡣");
				}
			}else{
				System.out.println("�������󣬽�������");
			}
			
		}else{
			System.out.println("�����������ϵ���й�����Ա��");
		}
	}

}
