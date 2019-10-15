package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.service.IProvinceService;

@RestController
@RequestMapping("/admin/pcz")
public class ProvinceController {
	@Resource
	private IProvinceService provinceServiceImpl;
	
	
	@RequestMapping("/findAll")
	public List findAll() throws Exception {
		return provinceServiceImpl.findAll();
	}
	
}
