package woniu12;

import java.util.Scanner;

public class SwitchDemo2 {

	public static void main(String[] args) {
		//		12、输入一个年月，输出该月有多少天。
//		if(month==1||3||5||7||8||10||12){
//			System.out.println("31");
//		}else if(month==4||6||9||11){
//			System.out.println("30'");
//		}else if(month==2){
//			if(year%4==0&&year%100!=0||year%400==0){
//				System.out.println(29);
//			}else{
//				System.out.println(28);
//			}
//		}
		//先获得年月
		Scanner scan = new Scanner(System.in);
		System.out.print("年：");
		int year = scan.nextInt();
		System.out.print("月：");
		int month = scan.nextInt();
		switch(month){
			case 1:
			case 3:
			case 5:	
			case 7:
			case 8:	
			case 10:
			case 12:
				System.out.println(31);
				break;
			case 2:
				if(year%4==0&&year%100!=0||year%400==0){
					System.out.println(29);
				}else{
					System.out.println(28);
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println(30);
				break;
			
		}
	}

}
