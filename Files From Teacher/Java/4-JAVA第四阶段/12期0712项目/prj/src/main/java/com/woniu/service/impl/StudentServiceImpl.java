package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.mapper.StudentMapper;
import com.woniu.model.PageBean;
import com.woniu.model.Student;
import com.woniu.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	@Resource
	private StudentMapper studentMapper;

	@Override
	public List findAll(PageBean page) {
		// TODO Auto-generated method stub
		List list = studentMapper.selectByExample(null,new RowBounds(page.getOffset(), page.getLimit()));
		page.setCount(studentMapper.countByExample(null));
		return list;
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentMapper.insert(student);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentMapper.updateByPrimaryKey(student);
		
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		studentMapper.deleteByPrimaryKey(student.getStid());
	}

	@Override
	public Student findById(Integer stid) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(stid);
	}

	@Override
	public void deleteBatch(String[] stids) {
		// TODO Auto-generated method stub
		studentMapper.deleteBatch(stids);
	}
}
