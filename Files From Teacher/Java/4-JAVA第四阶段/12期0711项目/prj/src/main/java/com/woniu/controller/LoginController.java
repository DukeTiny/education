package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.model.Userinfo;
import com.woniu.service.ITreeService;
import com.woniu.service.IUserinfoService;
import com.woniu.tools.MD5;

@Controller
public class LoginController {
	@Resource
	private IUserinfoService userinfoServiceImpl;
	
	
	@RequestMapping("/login")
	public String login(Userinfo info,ModelMap map,HttpSession session) throws Exception {
		if(info.getUpass()!=null)
			info.setUpass(MD5.md5s(info.getUpass()));
		info = userinfoServiceImpl.login(info);
		if(info==null) {
			map.put("error", "用户名密码不正确");
			return "index";
		}else {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(info.getTrees());
			session.setAttribute("json", json);
			session.setAttribute("info", info);
			return "redirect:/admin/index.jsp";
		}
	}
}
