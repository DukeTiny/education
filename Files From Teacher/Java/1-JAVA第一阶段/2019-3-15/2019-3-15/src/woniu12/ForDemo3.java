package woniu12;

public class ForDemo3 {

	public static void main(String[] args) {
//		for(int i=65;i<91;i++){
//			System.out.println((char)i);
//		}
		
//		for(char c='a';c<='z';c++){
//			System.out.println(c);
//		}
		
//		int i = 1;
//		for(System.out.println(1);i<3;System.out.println(3)){
//			System.out.println(2);
//			i++;
//		}
		//12323
		
		for(int i=1;i<=100;i++){
			if(i%2==1){
				continue;
				//break;
			}
			System.out.println(i);
		}
	}

}
