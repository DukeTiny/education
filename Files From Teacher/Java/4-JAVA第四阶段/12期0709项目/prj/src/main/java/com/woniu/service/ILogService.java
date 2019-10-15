package com.woniu.service;

import java.util.List;

import com.woniu.model.Log;
import com.woniu.model.PageBean;

public interface ILogService {
	public List findAll(Log log,PageBean page);
}
