package woniu12;

public class Demo3 {

	public static void main(String[] args) {
		//·ê7¹ý
		for(int i=1;i<=100;i++){
			if(i%7==0||i%10==7||i/10==7){
				System.out.print("¹ý ");
			}else{
				System.out.print(i+" ");
			}
			if(i%10==0){
				System.out.println();
			}
		}

	}

}
