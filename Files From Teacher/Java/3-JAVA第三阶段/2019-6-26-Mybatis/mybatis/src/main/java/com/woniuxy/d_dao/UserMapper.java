package com.woniuxy.d_dao;

import java.util.List;
import java.util.Map;

/*
 该接口的名字，必须与UserMapper.xml的名字相同，当然这个相同不包括后缀
 所以有UserMapper.xml配置文件，我们就要创建一个名字为UserMapper.java的接口源文件

该接口的方法必须与UserMapper.xml配置文件中语句相对应：
1. 方法名必须与语句的id相同
2. 方法的参数必须与语句的parameterType一致。
3. 方法的返回类型必须与语句的resultType一致。

不但对接口有要求，对UserMapper.xml文件也有要求:
要求UserMapper.xml中的mapper元素的namespace属性的值，必须与UserMapper接口的全类名（不带后缀java）
*/
public interface UserMapper {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	User findOne(Integer id);
	List<User> findAll();
	
	List<User> findSomeByMoneyRange(Map map);
	User findByName(String name);
}
