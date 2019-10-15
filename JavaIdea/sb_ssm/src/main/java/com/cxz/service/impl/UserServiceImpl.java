package com.cxz.service.impl;

import com.cxz.dao.UserMapper;
import com.cxz.entity.User;
import com.cxz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public void save(User user) {
        mapper.save(user);
    }
}
