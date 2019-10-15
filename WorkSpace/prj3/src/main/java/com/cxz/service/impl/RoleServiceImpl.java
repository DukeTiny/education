package com.cxz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxz.mapper.RoleMapper;
import com.cxz.mapper.RoletreeMapper;
import com.cxz.model.Role;
import com.cxz.model.RoletreeExample;
import com.cxz.model.RoletreeKey;
import com.cxz.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService{

	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private RoletreeMapper roletreeMapper;

	@Transactional(readOnly = true)
	public List<Role> findAll() {
		return roleMapper.selectByExample(null);
	}


	@Transactional
	public void save(Role role,String ids) {
		roleMapper.insertSelective(role);
		insertRoleTree(ids,role.getId());
	}

	@Transactional
	public void update( Role role,String ids ) {
		roleMapper.updateByPrimaryKey(role);
		RoletreeExample example = new RoletreeExample();
		example.or().andRidEqualTo(role.getId());
		roletreeMapper.deleteByExample(example);
		insertRoleTree(ids,role.getId());
	}

	@Transactional( readOnly = true )
	public Role findByid(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}
	
	@Transactional
	private void insertRoleTree(String ids,int id) {
		RoletreeKey rtk = new RoletreeKey();
		rtk.setRid(id);
		if( ids!=null && ids.length()>0 ) {
			String[] idArr = ids.split(",");
			for (String string : idArr) {
				rtk.setId( Integer.parseInt(string) );
				roletreeMapper.insertSelective(rtk);
			}
		}
	}

}
