package com.woniu.demo;

public class Demo {
	// �������������������ġ�
	public int getMax(int num1,int num2,int num3) {
		int max = num3;
		if (num1 > num2 && num1 > num3) {
			max = num1;
		} else if (num2 > num1 && num2 > num3) {
			max = num2;
		}
		return max;
	}
	
	//�������������ֵ
	public int getMax(int[] nums){
		int max = nums[0];
		for(int i=1;i<nums.length;i++){
			if(max<nums[i]){
				max = nums[i];
			}
		}
		return max;
	}
}
