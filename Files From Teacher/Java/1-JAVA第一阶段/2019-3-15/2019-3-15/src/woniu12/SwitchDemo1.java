package woniu12;

import java.util.Scanner;

public class SwitchDemo1 {

	public static void main(String[] args) {
		//switch
		//case
		//default
		//break
		Scanner scan = new Scanner(System.in);
		System.out.println("欢迎使用中国银行话务员系统：中文请按1，英文请按2");
		int select  = scan.nextInt();
//		if(select==1){
//			System.out.println("您选择的是中文");
//		}else if(select==2){
//			System.out.println("您选择的是英文");
//		}
		
		switch(select){
			
			
			default:
				System.out.println("您输入的选项有误！");
				break;
			case 2:
				System.out.println("您选择的是英文");
				break;
			case 1:
				System.out.println("您选择的是中文");
				break;
		}
	}

}
