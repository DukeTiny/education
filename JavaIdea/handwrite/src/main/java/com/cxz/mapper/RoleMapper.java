package com.cxz.mapper;

import com.cxz.domain.Role;

import java.io.Serializable;
import java.util.List;

public interface RoleMapper {

    void save(Role role);
    void update(Role role);
    void delete(Serializable id);
    Integer findId(String name);
    List<Role> find();

}
