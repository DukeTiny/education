package com.woniu.service;

import java.util.List;

import com.woniu.model.Log;
import com.woniu.model.PageBean;
import com.woniu.model.Student;

public interface IStudentService {
	public List findAll(PageBean page);
	public void save(Student student);
	public void update(Student student);
	public void delete(Student student);
	public void deleteBatch(String[] stids);
	public Student findById(Integer stid);
}
