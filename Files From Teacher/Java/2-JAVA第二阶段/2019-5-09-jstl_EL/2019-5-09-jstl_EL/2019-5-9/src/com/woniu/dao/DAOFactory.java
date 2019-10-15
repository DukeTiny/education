package com.woniu.dao;

public class DAOFactory {
	/**
	 * 
	 * @return
	 */
	public static IUserDAO getUserDAO(){
		return new UserDAOImpl();
	}
	
}
