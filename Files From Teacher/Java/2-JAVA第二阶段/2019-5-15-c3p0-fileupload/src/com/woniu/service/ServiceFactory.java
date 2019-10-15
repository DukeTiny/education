package com.woniu.service;

public class ServiceFactory {
	public static IStuService getStuService(){
		return new StuServiceImpl();
	}
}
