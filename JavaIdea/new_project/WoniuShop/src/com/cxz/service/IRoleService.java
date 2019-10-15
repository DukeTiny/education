package com.cxz.service;

import com.cxz.po.Role;

import java.util.List;

public interface IRoleService {
 
   void add(Role role);

    void update(Role role,String pk_name);

    void del(Integer id);

    Role getOne(Integer id);

    List<Role> getAll();
}