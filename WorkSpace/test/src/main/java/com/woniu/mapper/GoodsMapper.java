package com.woniu.mapper;

import com.woniu.model.Goods;
import com.woniu.model.GoodsExample;
import java.util.List;

public interface GoodsMapper {

	long countByExample(GoodsExample example);
	int deleteByExample(GoodsExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(Goods record);

	int insertSelective(Goods record);

	List<Goods> selectByExample(GoodsExample example);

	Goods selectByPrimaryKey(Integer id);

	int updateByExampleSelective( Goods record,GoodsExample example);

	int updateByExample(Goods record,GoodsExample example);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKey(Goods record);
}