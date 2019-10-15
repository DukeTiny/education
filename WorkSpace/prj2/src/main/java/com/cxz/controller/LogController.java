package com.cxz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("/findAll2")
	public @ResponseBody Map<String,Object> findAll2( Log log,Page page,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String,Object> map = new HashMap<>();
		List<Log> logs = logServiceImpl.findAll(log, page);
		map.put("logs",logs);
		map.put("page",page);
		map.put("log",log);
		return map;
	}

}
