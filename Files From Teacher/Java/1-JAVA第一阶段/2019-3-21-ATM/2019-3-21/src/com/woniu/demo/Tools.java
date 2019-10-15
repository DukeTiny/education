package com.woniu.demo;

public class Tools {
	/**
	 * ������תʮ����
	 * @param two
	 * @return
	 */
	public int twoToTen(String two){
		int ten = 0;
		for(int i=0;i<two.length();i++){
			char c = two.charAt(i);
			int temp = c - 48;
			ten = (int) (ten + temp*Math.pow(2, two.length()-1-i));
		}
		return ten;
	}
	
	/**
	 * �˽���תʮ����
	 * @param eight
	 * @return
	 */
	public int eightToTen(String eight){
		int ten = 0;
		for(int i=0;i<eight.length();i++){
			char c = eight.charAt(i);
			int temp = c - 48;
			ten = (int) (ten + temp*Math.pow(8, eight.length()-1-i));
		}
		return ten;
	}
	
	/**
	 * ʮ������תʮ����
	 * @param sixteen
	 * @return
	 */
	public int sixteenToTen(String sixteen){
		int ten = 0;
		for(int i=0;i<sixteen.length();i++){
			char c = sixteen.charAt(i);
			if(c>='A'&&c<='F'){
				int temp = c - 55;
				ten = (int) (ten + temp*Math.pow(16, sixteen.length()-1-i));
			}else{
				int temp = c - 48;
				ten = (int) (ten + temp*Math.pow(16, sixteen.length()-1-i));
			}
		}
		return ten;
	}
	
	/**
	 * n����ת����10����
	 * @param n
	 * @param num
	 * @return
	 */
	public int nToTen(int n,String num){
		int ten = 0;
		for(int i=0;i<num.length();i++){
			char c = num.charAt(i);
			if(c>='A'&&c<='F'){
				int temp = c - 55;
				ten = (int) (ten + temp*Math.pow(n, num.length()-1-i));
			}else{
				int temp = c - 48;
				ten = (int) (ten + temp*Math.pow(n, num.length()-1-i));
			}
		}
		return ten;
	}

	/**
	 * ʮת��
	 * @param ten
	 * @return
	 */
	public String tenToTwo(int ten){
		//������
		String two = "";
		while(ten>0){
			int yu = ten % 2;
			two = yu + two;
			ten = ten / 2;
		}
		return two;
	}
	
	/**
	 * ʮת��
	 * @param ten
	 * @return
	 */
	public String tenToEight(int ten){
		String eight = "";
		while(ten>0){
			int yu = ten % 8;
			eight = yu + eight;
			ten/=8;
		}
		return eight;
	}

	/**
	 * ʮתʮ��
	 * @param ten
	 * @return
	 */
	public String tenToSixteen(int ten){
		String sixteen = "";
		while(ten>0){
			int yu = ten % 16;
			sixteen = (yu>9?(char)(yu+55):(char)(yu+48)) + sixteen;
			ten /= 16;
		}
		return sixteen;
	}

	/**
	 * ʮתn
	 * @param ten
	 * @param n
	 * @return
	 */
	public String tenToN(int ten,int n){
		String nStr = "";
		while(ten>0){
			int yu = ten % n;
			nStr = (yu>9?(char)(yu+55):(char)(yu+48)) + nStr;
			ten = ten / n;
		}
		return nStr;
	}

	public String eightToTwo(String eight){
		int ten = this.eightToTen(eight);
		String two = this.tenToTwo(ten);
		return two;
	}
}
