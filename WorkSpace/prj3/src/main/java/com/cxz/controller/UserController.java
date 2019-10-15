package com.cxz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxz.model.Role;
import com.cxz.model.User;
import com.cxz.service.IRoleService;
import com.cxz.service.IUserService;
import com.cxz.utils.MD5;

@Controller
@RequestMapping("/admin/user/")
public class UserController {

	@Resource
	private IUserService userServiceImpl;
	
	@Resource
	private IRoleService roleServiceImpl;
	
	@RequestMapping("findAll") 
	public String findAll(ModelMap map){
		List<User> users = userServiceImpl.findAll();
		map.put("users",users);
		return "/admin/user/list";
	}
	
	@RequestMapping("goInput") 
	public String goInput(ModelMap map){
		List<Role> roles = roleServiceImpl.findAll();
		map.put("roles",roles);
		return "/admin/user/input";
	}
	
	@RequestMapping("save") 
	public String save(User user,Integer[] rids){
		user.setPassword(MD5.md5s(user.getPassword()));
		userServiceImpl.save(user,rids);
		return "redirect:findAll";
	}
	

	@RequestMapping("update") 
	public String update(User user,Integer[] rids){
		if( user.getPassword()!=null && !user.getPassword().equals("")) {
			user.setPassword(MD5.md5s(user.getPassword()));
		}
		userServiceImpl.update(user, rids);
		return "redirect:findAll";
	}
	
	@RequestMapping("delete") 
	public String delete(Integer uid){
		userServiceImpl.delete(uid);
		return "redirect:findAll";
	} 
	
	@RequestMapping("findById") 
	public String findById(Integer uid,ModelMap map){
		User user = userServiceImpl.findById(uid);
		map.put("user", user);
		return "forward:goInput";
	}
	
}
