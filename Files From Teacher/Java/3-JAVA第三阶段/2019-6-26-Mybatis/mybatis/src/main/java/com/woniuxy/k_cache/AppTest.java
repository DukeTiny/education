package com.woniuxy.k_cache;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/*
 Mybatis的一级缓存是SqlSession级别的一级缓存，也就是一级缓存不能跨会话。
 Mybatis的一级缓存对于提升系统性能帮助不大，因为SqlSession的生命周期太短。
   尽管如此。一级缓存还是为了提升系统性能！！保证了在一次会话中，相同的结果，不会查询第二次！
   
 
 Mybatis二级缓存默认是关闭着的，为了开启二级缓存，需要在Mybatis的主配置文件中，添加以下配置
 	<settings>
			<!-- 开启二级缓存 -->
	        <setting name="cacheEnabled" value="true"/>
	</settings>
	
	还要在真正需要被二级缓存所管理的类(User)的子配置文件中(UserMapper.xml)，添加一个<cache />
	
 Mybatis的二级缓存是跨会话的！对提升系统性能帮助很大，因为Mybatis的二级缓存是SqlSessionFactory级别的缓存！
 SqlSessionFactory生命周期，往往与整个应用生命周期一致！！
 
 Mybatis的缓存与Hibernate的缓存的区别：
 1. hibernate的一级缓存是为了管理持久化状态的对象的；Mybatis中没有持久化对象的机制！！
 2. hibernate的缓存，是以对象的OID作为键值，对象本身作为值，来存入到一个Map中的；
 
 	s.get(User.class, 11);  -->  11:user
 	s.get(User.class, 12);  -->  12:user
    mybatis的缓存，是以sql语句的id + sql语句本身作为键值的，查询的对象本身作为值，来存入到一个Map中的；
    
*/
public class AppTest {
	@Test
	public void test() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ======================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		User u = mapper.findOne(1);
		User u2 = mapper.findOne(1);
		User u3 = mapper.findOne(1);
		System.out.println(u);
		System.out.println(u2);
		System.out.println(u3);
		// ======================================================
		s.close();
		
		System.out.println("======================================================");
		
		SqlSession s2 = MyBatisUtils.openSession();
		// ======================================================
		UserMapper mapper2 = s2.getMapper(UserMapper.class);
		User u4 = mapper2.findOne(1);
		User u5 = mapper2.findOne(1);
		User u6 = mapper2.findOne(1);
		System.out.println(u4);
		System.out.println(u5);
		System.out.println(u6);
		// ======================================================
		s2.close();
	}
	
	
	// 测试Mybatis缓存中封装的map的键值，是"sql id + sql内容本身"
	// 保证sql id不变，测试sql内容本身变化时，是否会发多个句子
	@Test
	public void test2() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ======================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		Map map = new HashMap();
		map.put("id", 1);
		User user = mapper.findOne2(map);  // "findOne2  select * from user WHERE id = ?"
		map.put("abc", "aaa");
		User user2 = mapper.findOne2(map); // "findOne2  select * from user WHERE id = ? and 1=1" 
		System.out.println(user);
		System.out.println(user2);
		// ======================================================
		s.close();
		
	}
	
	// 测试Mybatis缓存中封装的map的键值，是"sql id + sql内容本身"
	// 保证sql内容本身不变，测试sql id变化时，是否会发多个句子
	@Test
	public void test3() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ======================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		Map map = new HashMap();
		map.put("id", 1);
		User user = mapper.findOne3(map);  // "findOne2  select * from user WHERE id = ?"
		User user2 = mapper.findOne3(map); // "findOne3  select * from user WHERE id = ?" 
		System.out.println(user);
		System.out.println(user2);
		// ======================================================
		s.close();
		
	}
	
	
	// 如何清空一级缓存
	@Test
	public void test4() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ======================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		Map map = new HashMap();
		map.put("id", 1);
		User user = mapper.findOne2(map);    
		// s.clearCache();
		
		// 一旦修改，蛘呱境蓟嶙远蹇找患痘捍妗⒍痘捍妫っ髁薓ybatis没有持久化对象
		user.setName("周生生2");
		mapper.update(user);
		
		User user2 = mapper.findOne2(map);   
		System.out.println(user);
		System.out.println(user2);
		// ======================================================
		s.close();
		
		System.out.println("======================================================");
		
		SqlSession s2 = MyBatisUtils.openSession();
		// ======================================================
		UserMapper mapper2 = s2.getMapper(UserMapper.class);
		User user4 = mapper2.findOne2(map);  
		User user5 = mapper2.findOne2(map); 
		User user6 = mapper2.findOne2(map); 
		System.out.println(user4);
		System.out.println(user5);
		System.out.println(user6);
		// ======================================================
		s2.close();
		
	}
	
	
}