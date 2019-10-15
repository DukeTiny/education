package woniu12;

import java.util.Scanner;

public class SwitchDemo3 {

	public static void main(String[] args) {
		//获得年月日，输出是当年的第几天。
		Scanner scan = new Scanner(System.in);
		System.out.print("年：");
		int year = scan.nextInt();
		System.out.print("月：");
		int month = scan.nextInt();
		System.out.print("日：");
		int date = scan.nextInt();
		switch(month-1){
			case 11:
				date+=30;
			case 10:
				date+=31;
			case 9:
				date+=30;
			case 8:
				date+=31;
			case 7:
				date+=31;
			case 6:
				date+=30;
			case 5:
				date+=31;
			case 4:
				date+=30;
			case 3:
				date+=31;
			case 2:
				date+=28;
			case 1:
				date+=31;
		}
		System.out.println(date);

	}

}
