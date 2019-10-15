package com.woniuxy.dao.impl;

import org.springframework.stereotype.Repository;

import com.woniuxy.dao.IUserDao;
import com.woniuxy.dao.base.BaseDaoImpl;
import com.woniuxy.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
}
