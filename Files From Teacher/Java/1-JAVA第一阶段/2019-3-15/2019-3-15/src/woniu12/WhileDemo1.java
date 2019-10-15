package woniu12;

public class WhileDemo1 {

	public static void main(String[] args) {
//		int i = 1;
//		while(i<=10){
//			System.out.println(i);
//			i++;
//		}
		
		//转换二进制
		//10
		//倒除法
		//用十进制数除以2，将余数获得，商赋给被除数，继续除以2，直到被除数为0.
		int num = 10;
		while(num>0){
			int yu = num % 2;
			
			num = num /2;
		}
	}

}
