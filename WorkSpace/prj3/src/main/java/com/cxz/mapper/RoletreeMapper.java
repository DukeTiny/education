package com.cxz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cxz.model.RoletreeExample;
import com.cxz.model.RoletreeKey;

public interface RoletreeMapper {
	
	List<RoletreeKey> findByRid(Integer id);
	long countByExample(RoletreeExample example);
	int deleteByExample(RoletreeExample example);
	int deleteByPrimaryKey(RoletreeKey key);
	int insert(RoletreeKey record);
	int insertSelective(RoletreeKey record);
	List<RoletreeKey> selectByExample(RoletreeExample example);
	int updateByExampleSelective(@Param("record") RoletreeKey record, @Param("example") RoletreeExample example);
	int updateByExample(@Param("record") RoletreeKey record, @Param("example") RoletreeExample example);
}