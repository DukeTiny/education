package com.cxz.service.impl;

import com.cxz.dao.base.BaseDaoImpl;
import com.cxz.domain.Emp;
import com.cxz.service.IEmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpServiceImpl extends BaseDaoImpl<Emp> implements IEmpService {

}
