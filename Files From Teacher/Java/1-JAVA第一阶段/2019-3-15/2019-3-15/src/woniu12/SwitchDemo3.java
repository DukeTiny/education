package woniu12;

import java.util.Scanner;

public class SwitchDemo3 {

	public static void main(String[] args) {
		//��������գ�����ǵ���ĵڼ��졣
		Scanner scan = new Scanner(System.in);
		System.out.print("�꣺");
		int year = scan.nextInt();
		System.out.print("�£�");
		int month = scan.nextInt();
		System.out.print("�գ�");
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
