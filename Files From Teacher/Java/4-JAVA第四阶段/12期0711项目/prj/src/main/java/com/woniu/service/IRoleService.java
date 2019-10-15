package com.woniu.service;

import java.util.List;

import com.woniu.model.Role;
import com.woniu.model.Userinfo;

public interface IRoleService {
	public List findAll();
	public void save(Role role,String ids);
	public void update(Role role,String ids);
	public Role findById(Integer rid);
}
