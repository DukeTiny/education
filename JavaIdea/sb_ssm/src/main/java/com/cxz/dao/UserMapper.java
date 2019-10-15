package com.cxz.dao;


import com.cxz.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void save(User user);
}
