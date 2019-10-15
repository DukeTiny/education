package com.woniuxy.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.woniuxy.dao.IDeptDao;
import com.woniuxy.domain.Dept;

@Component
public class DeptDaoImpl implements IDeptDao {

	@Autowired
	private SessionFactory sf;
	
	private Session getSession() {
		// 获取与当前线程绑定的session，如果没有，则创建一个，存入线程。
		// 要使用sf.getCurrentSession();就必须加一个配置：
		// <prop key="hibernate.current_session_context_class">thread</prop>
		// 但是，在使用spring的声明式事务时：@Transactional，就不能加以上配置了，因为框架已经配置过了！
		return sf.getCurrentSession();
	}
	
	@Override
	public void save(Dept d) {
		getSession().save(d);
	}

}
