package com.cxz.e_conflict;

import java.util.List;

public interface UserMapper {

    void save(User user);
    void update(User user);
    void delete(Integer id);
    List<User> findAll();
    User findOne(Integer id);

}
