package com.woniu.demo;

import java.util.Scanner;

public class ATMDemo1 {

	public static void main(String[] args) {
		// �洢���п���Ϣ ���ţ����룻���������
		String[][] cards = new String[10][4];
		cards[0] = new String[] { "1001", "123456", "andy", "10000" };
		cards[1] = new String[] { "1002", "123456", "leon", "1000" };
		cards[2] = new String[] { "1003", "123456", "jack", "100000" };
		cards[3] = new String[] { "1004", "123456", "rose", "1" };
		//��õ�¼�����±�
		int nowCardIndex = -1;
		Scanner scan = new Scanner(System.in);
		// �û����뿨�ź�����Ľ���
		System.out.println("**************************");
		System.out.println("*��ӭʹ��XXX����ATMϵͳ       *");
		System.out.println("**************************");
		System.out.print("�����뿨�ţ�");
		String cardId = scan.next();
		System.out.print("���������룺");
		String cardPwd = scan.next();
		// �жϿ��ź������Ƿ����
		boolean flag = false;
		for (int i = 0; i < cards.length; i++) {
			if (cardId.equals(cards[i][0]) && cardPwd.equals(cards[i][1])) {
				flag = true;
				nowCardIndex = i;
				break;
			}
		}
		if (flag) {
			// ҵ����棺�鿴����Ǯ��ȡǮ��ת�ˣ��˿���
			System.out.println("************");
			System.out.println("*1����Ǯ       *");
			System.out.println("*2��ȡǮ       *");
			System.out.println("*3��ת��       *");
			System.out.println("*4�����       *");
			System.out.println("*5���˿�       *");
			System.out.println("************");
			int select = scan.nextInt();
			switch (select) {
			case 1:
//				System.out.println("�����������:");
//				int money = scan.nextInt();
//				int oldMoney = Integer.parseInt(cards[nowCardIndex][3]);
//				cards[nowCardIndex][3] = String.valueOf(oldMoney + money);
//				for (int j = 0; j < cards[nowCardIndex].length; j++) {
//					System.out.print(cards[nowCardIndex][j] + " ");
//				}
//				System.out.println();
				break;
			case 2:
//				System.out.print("������Ҫȡ�Ľ�");
//				int money2 = scan.nextInt();
//				int oldMoney2 = Integer.parseInt(cards[nowCardIndex][3]);
//				if (money2 <= oldMoney2) {
//					cards[nowCardIndex][3] = String.valueOf(oldMoney2 - money2);
//				} else {
//					System.out.println("���㣡");
//				}
//				for (int j = 0; j < cards[nowCardIndex].length; j++) {
//					System.out.print(cards[nowCardIndex][j] + " ");
//				}
//				System.out.println();
				break;
			case 3:
//				System.out.println("������Է�����:");
//				String cardId2 = scan.next();
//				System.out.println("������ת����:");
//				int money3 = scan.nextInt();
//				int otherCardIndex = -1;
//				for (int i = 0; i < cards.length; i++) {
//					if (cardId2.equals(cards[i][0])) {
//						otherCardIndex = i;
//						break;
//					}
//				}
//				if(otherCardIndex!=-1){
//					int oldMoney3 = Integer.parseInt(cards[nowCardIndex][3]);
//					cards[nowCardIndex][3] = String.valueOf(oldMoney3 - money3);
//					int oldMoney4 = Integer.parseInt(cards[otherCardIndex][3]);
//					cards[otherCardIndex][3] = String.valueOf(oldMoney4 + money3);
//				}else{
//					System.out.println("�˺��Ҳ�����");
//				}
//				for (int j = 0; j < cards[nowCardIndex].length; j++) {
//					System.out.print(cards[nowCardIndex][j] + " ");
//				}
				break;
			case 4:
//				for (int j = 0; j < cards[nowCardIndex].length; j++) {
//					System.out.print(cards[nowCardIndex][j] + " ");
//				}
				break;
			case 5:
				
				break;
			}
		} else {
			System.out.println("�û����������");
		}
	}

}
