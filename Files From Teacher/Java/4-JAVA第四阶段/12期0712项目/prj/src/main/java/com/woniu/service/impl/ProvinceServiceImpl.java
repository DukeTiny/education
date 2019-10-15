package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.mapper.ProvinceMapper;
import com.woniu.model.LogExample;
import com.woniu.model.LogExample.Criteria;
import com.woniu.service.IProvinceService;

@Service
public class ProvinceServiceImpl implements IProvinceService{
	@Resource
	private ProvinceMapper provinceMapper;
	
	@Transactional(readOnly=true)
	public List findAll() {
		// TODO Auto-generated method stub
		return provinceMapper.selectByExample(null);
	}

}
