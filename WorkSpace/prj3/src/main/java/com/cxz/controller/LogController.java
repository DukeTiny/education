package com.cxz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxz.model.Log;
import com.cxz.model.Page;
import com.cxz.service.ILogService;

@Controller
@RequestMapping("/admin/log")
public class LogController {
	
	@Resource
	private ILogService logServiceImpl;
	
	
	@RequestMapping("/findAll")
	public String findAll( Log log,Page page,ModelMap map ) {
		List<Log> logs = logServiceImpl.findAll(log, page);
		map.put("logs",logs);
		map.put("page",page);
		map.put("log",log);
		return "/admin/log/list";
	}

}
