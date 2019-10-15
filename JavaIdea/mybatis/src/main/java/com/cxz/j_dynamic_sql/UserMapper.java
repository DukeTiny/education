package com.cxz.j_dynamic_sql;

import java.util.List;

public interface UserMapper {
    User find(UserExample ue);
    User find2(UserExample ue);
    User find3(UserExample ue);
    List<User> find4(UserExample ue);
    void update(User user);
}
