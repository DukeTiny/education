package com.woniuxy.l_lazyload;

public interface DeptMapper {
	Dept findOne(Integer did);
	void save(Dept dept);
}
