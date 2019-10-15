package woniu12;

import java.util.Scanner;

public class DemoIf {

	public static void main(String[] args) {
		//使用条件结构从键盘输入一个月份，打印输出对应的季节（春3-5、夏6-8、秋9-11、冬12-2）
		
		//先获得用户输入的月份
		Scanner scan = new Scanner(System.in);
//		System.out.print("请输入月份：");
//		int month = scan.nextInt();
		//判断月份所在的季度输出所在的季节
//		if(month>=3&&month<=5){
//			System.out.println("春");
//		}else if(month>=6&&month<=8){
//			System.out.println("夏");
//		}else if(month>=9&&month<=11){
//			System.out.println("秋");
//		}else if(month==12||month==1||month==2){
//			System.out.println("冬");
//		}else{
//			
//		}
		
		//9、输出“你是男人吗？”，回答如果是true，那么输出“原来你是男人呀，呵呵”，
		// 如果回答是：false，那么输出“你的性别难道是女?”。
//		System.out.print("你是男人吗？");
//		boolean isMan = scan.nextBoolean();
//		if(isMan){
//			System.out.print("呵呵");
//		}else{
//			System.out.print("哈哈");
//			
//		}
		
//		7、输入三个数按照从小到大输出。
		System.out.print("请输入第一个数:");
		int num1 = scan.nextInt();
		System.out.print("请输入第2个数:");
		int num2 = scan.nextInt();
		System.out.print("请输入第3个数:");
		int num3 = scan.nextInt();
		//8,3,5
		//3,8,5
		//3,5,8
		
		if(num1>num2){
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if(num1>num3){
			int temp = num1;
			num1 = num3;
			num3 = temp;
		}
		if(num2>num3){
			int temp = num2;
			num2 = num3;
			num3 = temp;
		}
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}

}
