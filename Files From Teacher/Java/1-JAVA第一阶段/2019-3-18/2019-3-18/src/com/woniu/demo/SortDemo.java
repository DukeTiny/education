package com.woniu.demo;

public class SortDemo {

	public static void main(String[] args) {
//		int[] nums = new int[10];
//		int[] nums2 = new int[]{1,3,4,5,6};
		int[] nums3 = {23,12,17,15,22};
		//12,23,17,15,22
		//12,17,23,15,22
		//12,15,23,17,22
		//12,15,17,23,22
		//12,15,17,22,23
		
		//ÅÅĞò
		for(int i=0;i<nums3.length-1;i++){
			for(int j=i+1;j<nums3.length;j++){
				if(nums3[i]>nums3[j]){
					int temp = nums3[i];
					nums3[i] = nums3[j];
					nums3[j] = temp;
				}
			}
		}
		//Êä³öÅÅĞò½á¹û
		for(int num:nums3){
			System.out.println(num);
		}
	}

}
