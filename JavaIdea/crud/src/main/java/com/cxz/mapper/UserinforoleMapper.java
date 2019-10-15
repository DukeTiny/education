package com.cxz.mapper;

import com.cxz.domain.UserinforoleExample;
import com.cxz.domain.UserinforoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserinforoleMapper {

    Integer findIdByName(String roleName);

    long countByExample(UserinforoleExample example);

    int deleteByExample(UserinforoleExample example);

    int deleteByPrimaryKey(UserinforoleKey key);

    int insert(UserinforoleKey record);

    int insertSelective(UserinforoleKey record);

    List<UserinforoleKey> selectByExample(UserinforoleExample example);

    int updateByExampleSelective(@Param("record") UserinforoleKey record, @Param("example") UserinforoleExample example);

    int updateByExample(@Param("record") UserinforoleKey record, @Param("example") UserinforoleExample example);
}