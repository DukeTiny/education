package com.cxz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cxz.model.Tree;
import com.cxz.model.TreeExample;

public interface TreeMapper {
	
	List<Tree> findTreeByUid(Integer id);
	
	int deleteByPrimaryKey(Integer id);

	int insert(Tree record);

	int insertSelective(Tree record);

	List<Tree> selectByExample(TreeExample example);

	Tree selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Tree record, @Param("example") TreeExample example);

	int updateByExample(@Param("record") Tree record, @Param("example") TreeExample example);

	int updateByPrimaryKeySelective(Tree record);

	int updateByPrimaryKey(Tree record);

	List findTreeWithUid(Integer uid);
	
    long countByExample(TreeExample example);

    int deleteByExample(TreeExample example);
}