package com.woniu.demo;

import java.util.Vector;

public class OnlineUser {
	static Vector users = new Vector();
	/**
	 * 添加在线用户
	 * @param uname
	 */
	public static void addUser(String uname){
		users.addElement(uname);
	}
	/**
	 * 移出在线用户
	 * @param uname
	 */
	public static void removeUser(String uname){
		users.removeElement(uname);
	}
	/**
	 * 获得在线用户的人数
	 * @return
	 */
	public static int getOnlineNum(){
		return users.size();
	}
	/**
	 * 获得所有在线用户
	 * @return
	 */
	public static Vector getOnlinUsers(){
		return users;
	}
}
