package com.woniu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.mapper.UserinfoMapper;
import com.woniu.model.Userinfo;
import com.woniu.service.IUserinfoService;

@Service
public class UserinfoServiceImpl implements IUserinfoService{
	@Resource
	private UserinfoMapper userinfoMapper;
	
	@Transactional(readOnly=true)
	public Userinfo login(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return userinfoMapper.login(userinfo);
	}

}
