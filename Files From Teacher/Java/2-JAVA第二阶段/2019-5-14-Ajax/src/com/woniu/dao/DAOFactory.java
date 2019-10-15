package com.woniu.dao;

public class DAOFactory {
	public static IUserDAO getUserDAO(){
		return new UserDAOImpl();
	}
}
