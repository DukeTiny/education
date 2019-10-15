package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.mapper.RoleMapper;
import com.woniu.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService{
	@Resource
	private RoleMapper roleMapper;
	
	@Transactional(readOnly=true)
	public List findAll() {
		// TODO Auto-generated method stub
		return roleMapper.selectByExample(null);
	}

}
