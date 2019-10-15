package woniu12;

public class ForDemo2 {

	public static void main(String[] args) {
		//计算10的二进制数
		//1010
		int j = 1;
		int sum = 0;
		for(int i=4;i>0;i/=2){
			int yu = i % 2;
			sum+=yu*j;
			j*=10;
			
		}
		System.out.println(sum);

	}

}
