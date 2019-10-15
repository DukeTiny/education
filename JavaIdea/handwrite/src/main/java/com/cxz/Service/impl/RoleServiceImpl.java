package com.cxz.Service.impl;

import com.cxz.Service.IRoleService;
import com.cxz.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Integer find(String name) {
        return roleMapper.findId(name);
    }
}
