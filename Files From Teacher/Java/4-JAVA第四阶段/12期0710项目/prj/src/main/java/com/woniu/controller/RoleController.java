package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.model.Role;
import com.woniu.service.IRoleService;
import com.woniu.service.ITreeService;

@Controller
@RequestMapping("/admin/role/")
public class RoleController {
	@Resource
	private IRoleService roleServiceImpl;
	@Resource
	private ITreeService treeServiceImpl;
	
	@RequestMapping("findAll")
	public String findAll(ModelMap map) {
		List list = roleServiceImpl.findAll();
		map.put("list", list);
		return "/admin/role/list";
	}
	
	@RequestMapping("save")
	public String save(Role role,String ids) {
		roleServiceImpl.save(role,ids);
		return "redirect:findAll";
	}
	
	@RequestMapping("update")
	public String update(Role role,String ids) {
		roleServiceImpl.update(role,ids);
		return "redirect:findAll";
	}
	
	@RequestMapping("findById")
	public String findById(Integer rid,ModelMap map) {
		Role role = roleServiceImpl.findById(rid);
		map.put("role", role);
		//找出当前role所具有的权限
		return "forward:goInput";
	}
	
	@RequestMapping("goInput")
	public String goInput(ModelMap map) throws JsonProcessingException {
		List trees = treeServiceImpl.findAll();
		ObjectMapper mapper =  new ObjectMapper();
		String json = mapper.writeValueAsString(trees).toString();
		map.put("json", json);
		return "/admin/role/input";
	}
}
