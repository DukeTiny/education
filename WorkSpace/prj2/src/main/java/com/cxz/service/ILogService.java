package com.cxz.service;

import java.util.List;

import com.cxz.model.Log;
import com.cxz.model.Page;

public interface ILogService {

	public List<Log> findAll( Log log,Page page );
	
}
