package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Stu;

public interface IStuDAO {
	void save(Stu stu);
	void update(Stu stu);
	void delete(Integer sid);
	Stu findOne(Integer sid);
	List<Stu> findAll();
}
