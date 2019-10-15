package com.woniu.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionDemo {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("张飞");
		list.add("吕布");
		list.add("张辽");
		list.add("关羽");
		list.add("周瑜");
		list.add("太史慈");
		list.add("典韦");
		list.add("许褚");
		list.add("马超");
		
		
		Set set1 = new HashSet();
		//随机数变量
		int x = 9;
		//每个集必须存够三个武将
		while(set1.size()<3){
			//随机list的下标
			int n1 = (int)(Math.random()*x);
			//获取list中的武将名
			String name = (String) list.get(n1);
			//将获取的武将名放入set中，如果放置成功，将该武将名从list中移除，随机数-1
			if(set1.add(name)){
				list.remove(name);
				x--;
			}
		}
		Set set2 = new HashSet();
		while(set2.size()<3){
			int n1 = (int)(Math.random()*x);
			String name = (String) list.get(n1);
			if(set2.add(name)){
				list.remove(name);
				x--;
			}
		}
		Set set3 = new HashSet();
		while(set3.size()<3){
			int n1 = (int)(Math.random()*x);
			String name = (String) list.get(n1);
			if(set3.add(name)){
				list.remove(name);
				x--;
			}
		}
		
		//声明势力map
		Map map = new HashMap();
		//将势力名称和所属武将分别放入key和value
		map.put("魏", set1);
		map.put("蜀", set2);
		map.put("吴", set3);
		
		//获得map的势力set
		Set s = map.keySet();
		Iterator it = s.iterator();
		while(it.hasNext()){
			//取出势力名也就是key
			String countryName = (String) it.next();
			System.out.println(countryName+":");
			//通过key获得武将set
			Set tempSet = (Set) map.get(countryName);
			Iterator it2 = tempSet.iterator();
			//循环取出武将名
			while(it2.hasNext()){
				String name = (String) it2.next();
				System.out.print(name+"、");
			}
			System.out.println();
		}
	}

}
