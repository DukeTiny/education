package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.model.Userinfo;
import com.woniu.service.IRoleService;
import com.woniu.service.IUserinfoService;
import com.woniu.tools.MD5;

@Controller
@RequestMapping("/admin/userinfo/")
public class UserinfoController {
	@Resource
	private IUserinfoService userinfoServiceImpl;
	
	@Resource
	private IRoleService roleServiceImpl;
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map) {
		List list = userinfoServiceImpl.findAll();
		map.put("list", list);
		return "/admin/userinfo/list";
	}
	
	@RequestMapping("save")
	public String save(Userinfo info,Integer[] rids) {
		info.setUpass(MD5.md5s(info.getUpass()));
		userinfoServiceImpl.save(info, rids);
		return "redirect:findAll";
	}
	
	@RequestMapping("update")
	public String update(Userinfo info,Integer[] rids) {
		if(info.getUpass()!=null)
			info.setUpass(MD5.md5s(info.getUpass()));
		userinfoServiceImpl.update(info, rids);
		return "redirect:findAll";
	}
	
	@RequestMapping("findById")
	public String findById(Integer uid,ModelMap map) {
		Userinfo info = userinfoServiceImpl.findById(uid);
		map.put("info", info);
		return "forward:goInput";
	}
	
	@RequestMapping("delete")
	public String delete(Integer uid) {
		userinfoServiceImpl.delete(uid);
		return "redirect:findAll";
	}
	
	@RequestMapping("goInput")
	public String goInput(ModelMap map) {
		List list = roleServiceImpl.findAll();
		map.put("roles", list);
		return "/admin/userinfo/input";
	}
}
