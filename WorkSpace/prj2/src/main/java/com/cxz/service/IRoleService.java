package com.cxz.service;

import java.util.List;

import com.cxz.model.Role;

public interface IRoleService {

	void save(Role role,String ids);
	List<Role> findAll();
	void update(Role role,String ids);
	Role findByid(Integer id);
}
