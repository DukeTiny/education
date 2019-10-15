package com.cxz.service;

import com.cxz.mapper.StudentDao;
import com.cxz.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StuServiceImpl implements IStuService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student findById(Integer sid) {
        return studentDao.selectByPrimaryKey(sid);
    }

}
