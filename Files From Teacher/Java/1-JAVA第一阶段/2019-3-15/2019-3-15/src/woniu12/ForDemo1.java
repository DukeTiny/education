package woniu12;

public class ForDemo1 {

	public static void main(String[] args) {
//		for(int i=1;i<=100;i++){
//			System.out.println(i);
//		}
		
//		for(int i=10;i>=1;i--){
//			System.out.println(i);
//		}

		//���1-100������
//		for(int i=1;i<=100;i++){
//			if(i%2==1){
//				System.out.println(i);
//			}
//		}
		
		//���1-100��������
//		int sum = 0;
//		for(int i=1;i<=100;i++){
//			if(i%2==1){
//				sum+=i;
//			}
//		}
//		System.out.println(sum);
		
		//��15�Ľ׳�    15!
		long jc = 1;
		for(int i=1;i<=15;i++){
			jc*=i;
		}
		System.out.println(jc);
	}

}
