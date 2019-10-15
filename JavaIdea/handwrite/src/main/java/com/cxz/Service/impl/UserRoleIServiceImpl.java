package com.cxz.Service.impl;

import com.cxz.Service.IUserRoleService;
import com.cxz.domain.User_Role_Key;
import com.cxz.mapper.User_Role_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRoleIServiceImpl implements IUserRoleService {

    @Autowired
    private User_Role_Mapper urm;

    @Override
    public void save(User_Role_Key urk) {
        urm.save(urk);
    }
}
