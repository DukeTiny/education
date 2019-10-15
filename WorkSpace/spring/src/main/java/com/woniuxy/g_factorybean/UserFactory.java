package com.woniuxy.g_factorybean;

import org.springframework.beans.factory.FactoryBean;

public class UserFactory implements FactoryBean<User>  {

	public User getObject() throws Exception {
		User u = new User();
		u.setId(111);
		u.setName("abc");
		return u;
	}

	public Class<?> getObjectType() {
		return null;
	}

	public boolean isSingleton() {
		return false;
	}

	
	
	
}