package com.woniu.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomDemo2 {

	public static void main(String[] args) {
		// ���10000��[0,10)��������ʹ��mapͳ��ÿ�����ֳ��ֵĴ�����
		Map<Integer,Integer> map = new HashMap<Integer,Integer>(); // ����map����
		Random rand = new Random(); //ʵ����һ�����������
		//ѭ��10000��
		for(int i=1;i<=10000;i++){
			int num = rand.nextInt(10);	//[0,10)
			Integer j = map.get(num);  //���������ֶ�Ӧ��value
			//�����õ�valueΪnull��˵����һ�����
			if(j==null){
				map.put(num, 1);
			}else{
				map.put(num, j+1);
			}
		}
		
		//������еļ�0-9
		Set<Integer> nums = map.keySet();
		for(Integer i:nums){
			System.out.println(i+":"+map.get(i));
		}
	}

}
