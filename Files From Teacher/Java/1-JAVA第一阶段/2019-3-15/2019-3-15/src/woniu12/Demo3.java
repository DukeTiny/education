package woniu12;

public class Demo3 {

	public static void main(String[] args) {
		//��7��
		for(int i=1;i<=100;i++){
			if(i%7==0||i%10==7||i/10==7){
				System.out.print("�� ");
			}else{
				System.out.print(i+" ");
			}
			if(i%10==0){
				System.out.println();
			}
		}

	}

}
