package woniu12;

public class For2Demo1 {

	public static void main(String[] args) {
		//������
//		for(int j=1;j<=9;j++){
//			//������
//			for(int i=1;i<=j;i++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//�žų˷���
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				//1*1=1
				System.out.print(i+"*"+j+"="+(i*j)+" ");
			}
			System.out.println();
		}
	}

}
