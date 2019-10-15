package com.cxz.mapper;

import com.cxz.model.User;
import com.cxz.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.cxz.model.UserWithBLOBs;

public interface UserMapper {
	

	User login(User user);

	long countByExample(UserExample example);
	
	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Integer id);
	
	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);
	
	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}