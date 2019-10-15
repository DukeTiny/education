package com.cxz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxz.mapper.LogMapper;
import com.cxz.model.Log;
import com.cxz.model.LogExample;
import com.cxz.model.LogExample.Criteria;
import com.cxz.model.Page;
import com.cxz.service.ILogService;

@Service
public class LogServiceImpl implements ILogService{

	@Resource
	private LogMapper logMapper;
	
	@Transactional( readOnly = true )
	public List<Log> findAll(Log log, Page page) {
        System.out.println(page.getNowPage());
        System.out.println(page.getLimit());
		LogExample le = new LogExample();
		Criteria c = le.createCriteria();
		if( log!=null ) {
		    if(log.getUname()!=null && !log.getUname().equals("") ){
			    c.andUnameLike( log.getUname() );
            }
            else if( log.getAction()!=null && !log.getUname().equals("") ){
                c.andUnameLike( log.getAction() );
            }
		}
		List<Log> logs = logMapper.selectByExample(le, new RowBounds( page.getOffset(),page.getLimit() ));
		page.setRowCount((int)(logMapper.countByExample(le)));
		return logs;
	}
	

}
