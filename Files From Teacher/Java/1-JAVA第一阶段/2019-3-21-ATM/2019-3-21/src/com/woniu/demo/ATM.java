package com.woniu.demo;

import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		//���������ſ�����Ϣ
		String[][] cards = {
				{"1001","123456","Andy","1000"},
				{"1002","123456","Jack","10000"},
				{"1003","123456","Leon","100"}
		};
		//������¼����
		System.out.println("******************");
		System.out.println("******************");
		System.out.println("******************");
		Scanner scan = new Scanner(System.in);
		System.out.print("���ţ�");
		String cardId = scan.next();
		System.out.println("���룺");
		String cardPwd = scan.next();
		//��õ�¼��Ϣ�������еĿ����бȶ�
		int nowCardIndex = -1;   //������¼�����±�
		for(int i=0;i<cards.length;i++){
			String cardId2 = cards[i][0];
			String cardPwd2 = cards[i][1];
			if(cardId.equals(cardId2)&&cardPwd.equals(cardPwd2)){
				nowCardIndex = i;
				break;
			}
		}
		if(nowCardIndex!=-1){
			int select = 0;
			while(select!=5){
				//�������������ȷ��������������棬������ʾ�����������
				System.out.println("******************");
				System.out.println("*1���棻2��ȡ��3��ת��4���飻5���ˣ�*");
				System.out.println("******************");
				select = scan.nextInt();
				switch(select){
				case 1:
					System.out.print("���������Ľ�");
					int money = scan.nextInt();
					int oldMoney = Integer.parseInt(cards[nowCardIndex][3]);
					cards[nowCardIndex][3] = String.valueOf(oldMoney+money);
					System.out.println(cards[nowCardIndex][2]+"�������:"+cards[nowCardIndex][3]+"Ԫ");
					break;
				case 2:
					System.out.print("������ȡ���Ľ�");
					int money2 = scan.nextInt();
					int oldMoney2 = Integer.parseInt(cards[nowCardIndex][3]);
					if(money2<=oldMoney2){
						cards[nowCardIndex][3] = String.valueOf(oldMoney2-money2);
					}else{
						System.out.println("���㣡");
					}
					System.out.println(cards[nowCardIndex][2]+"�������:"+cards[nowCardIndex][3]+"Ԫ");
					break;
				case 3:
					System.out.print("������ת��Ŀ��ţ�");
					String cardId3 = scan.next();
					System.out.print("������ת��Ľ�");
					int money3 = scan.nextInt();
					int otherCardIndex = -1;
					for(int i=0;i<cards.length;i++){
						String cardId2 = cards[i][0];
						if(cardId3.equals(cardId2)){
							otherCardIndex = i;
							break;
						}
					}
					if(otherCardIndex!=-1){
						int oldMoney3 = Integer.parseInt(cards[nowCardIndex][3]);
						int oldMoney4 = Integer.parseInt(cards[otherCardIndex][3]);
						if(money3<=oldMoney3){
							cards[nowCardIndex][3] = String.valueOf(oldMoney3-money3);
							cards[otherCardIndex][3] = String.valueOf(oldMoney4+money3);
						}else{
							System.out.println("���㣡");
						}
					}else{
						System.out.println("ת����˺Ų����ڣ�");
					}
					System.out.println(cards[nowCardIndex][2]+"�������:"+cards[nowCardIndex][3]+"Ԫ");
					break;
				case 4:
					System.out.println(cards[nowCardIndex][2]+"�������:"+cards[nowCardIndex][3]+"Ԫ");
					break;
				case 5:
					System.out.println("��ӭ�´�������");
					break;
				}
			}
		}else{
			System.out.println("�����������");
		}
		
	}
}
