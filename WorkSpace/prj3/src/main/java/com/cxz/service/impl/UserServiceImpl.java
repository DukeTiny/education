package com.cxz.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxz.mapper.UserMapper;
import com.cxz.mapper.UserRoleMapper;
import com.cxz.model.User;
import com.cxz.model.UserExample;
import com.cxz.model.UserRoleExample;
import com.cxz.model.UserRoleKey;
import com.cxz.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Resource
	private UserMapper userMapper;
	
	@Resource 
	private UserRoleMapper userRoleMapper;
	
	@Transactional( readOnly = true )
	public User login(User user) {
		return userMapper.login(user);
	}

	
	@Transactional
	public void save(User user,Integer[] rids) {
		userMapper.insert(user);
		if( rids!=null ) {
			UserRoleKey urk = new UserRoleKey();
			urk.setUid(user.getId());
			for (Integer rid : rids) {
				urk.setRid(rid);
				userRoleMapper.insert(urk);
			}
		}
	}

	@Transactional
	public void delete(Integer id) {
		User user = new User();
		user.setId(id);
		user.setDelete(true);
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Transactional
	public List<User> findAll() {
		return userMapper.selectByExample(null);
	}

	@Transactional
	public void update(User user,Integer[] rids){
		userMapper.updateByPrimaryKeySelective(user);
		UserRoleExample ure = new UserRoleExample();
		ure.or().andUidEqualTo( user.getId() );
		userRoleMapper.deleteByExample(ure);
		if( rids!=null ) {
			UserRoleKey urk = new UserRoleKey();
			urk.setUid(user.getId());
			for (Integer rid : rids) {
				urk.setRid(rid); 
				userRoleMapper.insert(urk);
			}
		}
	}

	@Override
	public User findById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}


}
