package com.cxz.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxz.model.Tree;
import com.cxz.model.User;
import com.cxz.service.IUserService;
import com.cxz.utils.MD5;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LoginController {
	
	@Resource
	private IUserService userServiceImpl;
	
	private List<Tree> trees ;
	
	@RequestMapping("login")
	public String login( User user,ModelMap map,HttpSession session ) throws JsonProcessingException {
		if( user.getPassword()!=null ) {
			user.setPassword(MD5.md5s(user.getPassword()));
		}
		user = userServiceImpl.login(user);
		
		if( user==null ) {
			map.put("error","用户名密码不正确");
			return "redirect:/index.html";   
		} 
		else {
//			ObjectMapper om = new ObjectMapper();
//			String json = om.writeValueAsString(user.getTrees());
//			session.setAttribute("json", json);
			session.setAttribute("user",user);
			this.trees = user.getTrees();
			System.out.println("aaa");
			return "redirect:/admin/index.html";
		}
	}
	
	@RequestMapping("getTree")
	public List<Tree> getTree(){
		System.out.println("sssss");
		return trees;
	}

}
