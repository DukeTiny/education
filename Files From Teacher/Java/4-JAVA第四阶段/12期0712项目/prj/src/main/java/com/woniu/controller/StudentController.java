package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.model.Message;
import com.woniu.model.PageBean;
import com.woniu.model.Student;
import com.woniu.service.IStudentService;

@RestController
@RequestMapping("/admin/student")
public class StudentController {
	@Resource
	private IStudentService studentServiceImpl;
	
	@RequestMapping("/save")
	public Message save(Student student) throws InterruptedException {
		Message msg = null; 
		try {
			studentServiceImpl.save(student);
			msg = new Message(true, "学生增加成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "学生增加失败"+e);
			throw new RuntimeException(e);
		}finally {
			return msg;
		}
	}
	@RequestMapping("/update")
	public Message update(Student student) throws InterruptedException {
		Message msg = null; 
		try {
			studentServiceImpl.update(student);
			msg = new Message(true, "学生update成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "学生update失败"+e);
			throw new RuntimeException(e);
		}finally {
			return msg;
		}
	}
	
	@RequestMapping("/findAll")
	public Map findAll(PageBean page,HttpServletRequest req) throws InterruptedException {
		Map m = req.getParameterMap();
		List list = studentServiceImpl.findAll(page);
		Map map = new HashMap();
		map.put("total", page.getCount());
		map.put("rows", list);
		return map;
	}
	@RequestMapping("/findById")
	public Student findById(Integer stid) throws InterruptedException {
		Student student = studentServiceImpl.findById(stid);
		return student;
	}
	@RequestMapping("/delete")
	public Message delete(Student student) throws InterruptedException {
		Message msg = null; 
		try {
			studentServiceImpl.delete(student);
			msg = new Message(true, "学生删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "学生删除失败"+e);
			throw new RuntimeException(e);
		}finally {
			return msg;
		}
	}
	@RequestMapping("/deleteBatch")
	public Message deleteBatch(String ids) throws InterruptedException {
		Message msg = null; 
		try {
			String[] idarrs = ids.split(",");
			studentServiceImpl.deleteBatch(idarrs);
			msg = new Message(true, "学生批量删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "学生批量删除失败"+e);
			throw new RuntimeException(e);
		}finally {
			return msg;
		}
	}
}
