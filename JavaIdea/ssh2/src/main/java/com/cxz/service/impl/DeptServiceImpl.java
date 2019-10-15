package com.cxz.service.impl;

import com.cxz.dao.base.BaseDaoImpl;

import com.cxz.domain.Dept;
import com.cxz.service.IDeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DeptServiceImpl extends BaseDaoImpl<Dept> implements IDeptService {

}
