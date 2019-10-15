package com.woniu.dao;

public class DAOFactory {
	public static IStuDAO getStuDAO(){
		return new StuDAOImpl();
	}
}
