package com.woniu.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomDemo2 {

	public static void main(String[] args) {
		// 随机10000次[0,10)的整数，使用map统计每种数字出现的次数。
		Map<Integer,Integer> map = new HashMap<Integer,Integer>(); // 生成map对象
		Random rand = new Random(); //实例化一个随机数对象
		//循环10000次
		for(int i=1;i<=10000;i++){
			int num = rand.nextInt(10);	//[0,10)
			Integer j = map.get(num);  //获得随机数字对应的value
			//如果获得的value为null，说明第一次添加
			if(j==null){
				map.put(num, 1);
			}else{
				map.put(num, j+1);
			}
		}
		
		//获得所有的键0-9
		Set<Integer> nums = map.keySet();
		for(Integer i:nums){
			System.out.println(i+":"+map.get(i));
		}
	}

}
