package yj;

import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		//设定卡的信息
		int cardPwd = 123456;
		int cardMoney = 500;
		//获得银行卡密码
		System.out.println("欢迎使用宇宙银行ATM机");
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入您的密码：");
		int userPwd = scan.nextInt();
		//判断密码是否正确，正确进入atm界面，否则结束操作。
		if(cardPwd==userPwd){
			//判断用户存还是取，进入对应界面
			System.out.print("您是要存还是取，选1存，选2取：");
			int select = scan.nextInt();
			if(select==1){
				System.out.print("请输入您要存入的金额:");
				int money = scan.nextInt();
				System.out.println("您存入"+money+"元后，余额为"+(cardMoney+money)+"元");
			}else if(select==2){
				//获得用户输入金额
				//判断金额是否合法
				System.out.print("请输入您要取出的金额:");
				int money = scan.nextInt();
				if(money<=cardMoney){
					System.out.println("您取出"+money+"元后，余额为"+(cardMoney-money)+"元");
				}else{
					System.out.println("余额不足。");
				}
			}else{
				System.out.println("操作有误，结束操作");
			}
			
		}else{
			System.out.println("密码错误，请联系银行管理人员。");
		}
	}

}
