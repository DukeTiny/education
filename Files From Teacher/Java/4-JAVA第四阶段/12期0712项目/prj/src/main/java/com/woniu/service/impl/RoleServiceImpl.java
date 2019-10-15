package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.mapper.RoleMapper;
import com.woniu.mapper.RoletreeMapper;
import com.woniu.model.Role;
import com.woniu.model.RoletreeExample;
import com.woniu.model.RoletreeKey;
import com.woniu.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private RoletreeMapper roletreeMapper;

	@Transactional(readOnly = true)
	public List findAll() {
		// TODO Auto-generated method stub
		return roleMapper.selectByExample(null);
	}

	@Override
	public void save(Role role, String ids) {
		// TODO Auto-generated method stub
		// 插入角色
		roleMapper.insert(role);
		// 插入关系表 roletree
		if (ids != null && ids.length() > 0) {
			String[] idarr = ids.split(",");
			for (String id : idarr) {
				RoletreeKey key = new RoletreeKey();
				key.setRid(role.getRid());
				key.setId(Integer.parseInt(id));
				roletreeMapper.insert(key);
			}
		}
	}

	@Override
	public void update(Role role,String ids) {
		// TODO Auto-generated method stub
		roleMapper.updateByPrimaryKey(role);
		
		//先删除掉关系表中的数据
		RoletreeExample example = new RoletreeExample();
		example.createCriteria().andRidEqualTo(role.getRid());
		roletreeMapper.deleteByExample(example);
		
		// 插入关系表 roletree
		if (ids != null && ids.length() > 0) {
			String[] idarr = ids.split(",");
			for (String id : idarr) {
				RoletreeKey key = new RoletreeKey();
				key.setRid(role.getRid());
				key.setId(Integer.parseInt(id));
				roletreeMapper.insert(key);
			}
		}
	}

	@Override
	public Role findById(Integer rid) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(rid);
	}

}
