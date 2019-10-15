package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.model.Log;
import com.woniu.model.PageBean;
import com.woniu.service.ILogService;

@Controller
@RequestMapping("/admin/log")
public class LogController {
	@Resource
	private ILogService logServiceImpl;
	
	
	@RequestMapping("/findAll")
	public String findAll(Log log,PageBean page,ModelMap map) throws Exception {
		List list = logServiceImpl.findAll(log, page);
		map.put("list", list);
		map.put("page", page);
		map.put("log", log);
		return "/admin/log/list";
	}
}
