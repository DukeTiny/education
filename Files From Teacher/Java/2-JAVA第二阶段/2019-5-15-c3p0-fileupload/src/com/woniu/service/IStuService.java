package com.woniu.service;

import java.util.List;

import com.woniu.bean.Stu;

public interface IStuService {

	void addStu(Stu stu);

	List<Stu> getAllStus();

	void delStu(int parseInt);

	Stu getStuBySid(int parseInt);

	void editStu(Stu stu);


}
