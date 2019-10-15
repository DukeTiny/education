package com.woniuxy.k_cache;

import java.util.Map;

public interface UserMapper {
	User findOne(Integer id);
	User findOne2(Map map);
	User findOne3(Map map);
	void update(User user);
}
