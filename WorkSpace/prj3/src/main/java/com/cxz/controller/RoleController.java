package com.cxz.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxz.model.Log;
import com.cxz.model.Page;
import com.cxz.model.Role;
import com.cxz.model.RoletreeKey;
import com.cxz.model.Tree;
import com.cxz.service.IRoleService;
import com.cxz.service.ITreeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/admin/role")
public class RoleController {
	
	@Resource
	private IRoleService roleServiceImpl;
	
	@Resource
	private ITreeService treeServiceImpl;
	
	@RequestMapping("/findAll")
	public String findAll( Log log,Page page,ModelMap map ) {
		List<Role> roles = roleServiceImpl.findAll();
		map.put("roles",roles);
		return "/admin/role/list";
	}
	
	@RequestMapping("/save")
	public String save(Role role,String ids ) {
		roleServiceImpl.save(role, ids);
		return "redirect:findAll";
	}
	
	@RequestMapping("/update")
	public String update(Role role,String ids) {
		roleServiceImpl.update(role,ids);
		return "redirect:findAll";
	}
	
	@RequestMapping("/findById")
	public String findById( Integer id,ModelMap map) {
		Role role = roleServiceImpl.findByid(id);
		map.put("role", role);
		return "forward:goInput";
	}
	
	@RequestMapping("/goInput")
	public String goInput(ModelMap map) {
		List<Tree> trees = treeServiceImpl.findAll();
		ObjectMapper om = new ObjectMapper();
		String treeString = null;
		try {
			treeString = om.writeValueAsString(trees);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		map.put("trees",treeString);
		return "/admin/role/input";
	}

}
