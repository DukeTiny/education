package com.woniu.service;

import java.util.List;

import com.woniu.model.Userinfo;

public interface IUserinfoService {
	public Userinfo login(Userinfo userinfo);
	public List findAll();
	public void save(Userinfo userinfo,Integer[] rids);
	public void delete(Integer uid);
	public void update(Userinfo userinfo,Integer[] rids);
	public Userinfo findById(Integer uid);
}
