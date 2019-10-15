package com.woniuxy.f_$;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	void save(User user);
	
	List<User> findAllByColumnDesc(Map map);
}
