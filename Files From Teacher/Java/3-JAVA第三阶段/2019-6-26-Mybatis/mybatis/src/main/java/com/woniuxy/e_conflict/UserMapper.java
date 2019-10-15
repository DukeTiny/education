package com.woniuxy.e_conflict;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	List<User> findAll();
	List<User> findSome(Map map);
	List<User> findAll2();
}
