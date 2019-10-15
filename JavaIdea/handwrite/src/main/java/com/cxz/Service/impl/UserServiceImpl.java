package com.cxz.Service.impl;

import com.cxz.Service.IUserService;
import com.cxz.domain.User;
import com.cxz.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public List<User> find() {
        return null;
    }

    @Override
    public Integer findId(String username) {
        return userMapper.findId(username);
    }
}
