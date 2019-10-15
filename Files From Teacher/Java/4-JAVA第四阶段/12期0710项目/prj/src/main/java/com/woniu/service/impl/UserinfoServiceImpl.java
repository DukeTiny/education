package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.mapper.UserinfoMapper;
import com.woniu.mapper.UserinforoleMapper;
import com.woniu.model.Userinfo;
import com.woniu.model.UserinforoleExample;
import com.woniu.model.UserinforoleKey;
import com.woniu.service.IUserinfoService;

@Service
public class UserinfoServiceImpl implements IUserinfoService {
	@Resource
	private UserinfoMapper userinfoMapper;
	@Resource
	private UserinforoleMapper userinforoleMapper;

	@Transactional(readOnly = true)
	public Userinfo login(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return userinfoMapper.login(userinfo);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return userinfoMapper.selectByExample(null);
	}

	@Override
	@Transactional
	public void save(Userinfo userinfo, Integer[] rids) {
		// TODO Auto-generated method stub
		// 增加用户
		userinfoMapper.insert(userinfo);
		// 增加角色关系
		if (rids != null)
			for (int i = 0; i < rids.length; i++) {
				UserinforoleKey key = new UserinforoleKey();
				key.setUid(userinfo.getUid());
				key.setRid(rids[i]);
				userinforoleMapper.insert(key);
			}
	}

	@Override
	@Transactional
	public void delete(Integer uid) {
		// TODO Auto-generated method stub
		Userinfo info = new Userinfo();
		info.setUid(uid);
		info.setIsdelete(true);
		userinfoMapper.updateByPrimaryKeySelective(info);
	}

	@Override
	@Transactional
	public void update(Userinfo userinfo, Integer[] rids) {
		// TODO Auto-generated method stub
		// 增加用户
		userinfoMapper.updateByPrimaryKeySelective(userinfo);
		//删除角色关系
		UserinforoleExample example = new UserinforoleExample();
		example.createCriteria().andUidEqualTo(userinfo.getUid());
		userinforoleMapper.deleteByExample(example);
		// 增加角色关系
		if (rids != null)
			for (int i = 0; i < rids.length; i++) {
				UserinforoleKey key = new UserinforoleKey();
				key.setUid(userinfo.getUid());
				key.setRid(rids[i]);
				userinforoleMapper.insert(key);
			}

	}

	@Override
	@Transactional(readOnly=true)
	public Userinfo findById(Integer uid) {
		// TODO Auto-generated method stub
		return userinfoMapper.selectByPrimaryKey(uid);
	}

}
