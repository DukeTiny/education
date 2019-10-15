package com.woniuxy.d_dao;

import java.util.List;
import java.util.Map;

/*
 �ýӿڵ����֣�������UserMapper.xml��������ͬ����Ȼ�����ͬ��������׺
 ������UserMapper.xml�����ļ������Ǿ�Ҫ����һ������ΪUserMapper.java�Ľӿ�Դ�ļ�

�ýӿڵķ���������UserMapper.xml�����ļ���������Ӧ��
1. ����������������id��ͬ
2. �����Ĳ�������������parameterTypeһ�¡�
3. �����ķ������ͱ���������resultTypeһ�¡�

�����Խӿ���Ҫ�󣬶�UserMapper.xml�ļ�Ҳ��Ҫ��:
Ҫ��UserMapper.xml�е�mapperԪ�ص�namespace���Ե�ֵ��������UserMapper�ӿڵ�ȫ������������׺java��
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
