package com.cxz.dao.impl;

import com.cxz.dao.IEmpDao;
import com.cxz.dao.base.BaseDaoImpl;
import com.cxz.domain.Emp;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class EmpDaoImpl extends BaseDaoImpl<Emp> implements IEmpDao {
}
