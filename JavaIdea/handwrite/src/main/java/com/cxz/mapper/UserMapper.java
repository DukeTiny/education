package com.cxz.mapper;

import com.cxz.domain.User;

import java.io.Serializable;
import java.util.List;

public interface UserMapper {

    void save(User user);
    void update(User user);
    void delete(Serializable id);
    List<User> find();
    Integer findId(String username);

}
