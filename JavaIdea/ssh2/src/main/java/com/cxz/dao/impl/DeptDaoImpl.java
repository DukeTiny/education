package com.cxz.dao.impl;

import com.cxz.dao.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import com.cxz.dao.IDeptDao;
import com.cxz.domain.Dept;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class DeptDaoImpl extends BaseDaoImpl<Dept> implements IDeptDao {

}
