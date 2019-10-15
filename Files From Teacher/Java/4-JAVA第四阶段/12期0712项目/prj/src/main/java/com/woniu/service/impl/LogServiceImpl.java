package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.mapper.LogMapper;
import com.woniu.model.Log;
import com.woniu.model.LogExample;
import com.woniu.model.LogExample.Criteria;
import com.woniu.model.PageBean;
import com.woniu.service.ILogService;

@Service
public class LogServiceImpl implements ILogService{
	@Resource
	private LogMapper logMapper;
	
	@Transactional(readOnly=true)
	public List findAll(Log log,PageBean page) {
		// TODO Auto-generated method stub
		
		LogExample example = new LogExample();
		Criteria c = example.createCriteria();
		if(log!=null&&log.getUname()!=null&&!log.getUname().equals(""))
			c.andUnameEqualTo(log.getUname());
		if(log!=null&&log.getAction()!=null&&!log.getAction().equals(""))
			c.andActionEqualTo(log.getAction());
		
		List list = logMapper.selectByExample(example, new RowBounds(page.getOffset(), page.getLimit()));
		
		int count = logMapper.countByExample(example);
		
		page.setCount(count);
		
		return list;
	}

}
