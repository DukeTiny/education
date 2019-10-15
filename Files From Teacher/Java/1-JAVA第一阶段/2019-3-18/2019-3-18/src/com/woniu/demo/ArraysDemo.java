package com.woniu.demo;

public class ArraysDemo {

	public static void main(String[] args) {
		int[] nums = new int[60];
		System.out.println(nums[20]);
//		int[][] nums2 = new int[6][10];
		int[][] nums2 = {{1,2,3},{4,5},{6,7,8,9}};
//		nums2[0] = new int[]{4,5,6,7};
//		nums2[1] = new int[]{1,2,3};
		//		0		1		2		3
		//0		4		5		6		7
		//1		1		2		3
		//null

		for(int i=0;i<nums2.length;i++){
			for(int j=0;j<nums2[i].length;j++){
				System.out.print(nums2[i][j]+" ");
			}
			System.out.println();
		}

		
	}

}
