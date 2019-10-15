package com.cxz.Service;

import com.cxz.domain.User;

import java.io.Serializable;
import java.util.List;

public interface IUserService {

    void save(User user);
    void update(User user);
    void delete(Serializable id);
    List<User> find();
    Integer findId(String username);

}
