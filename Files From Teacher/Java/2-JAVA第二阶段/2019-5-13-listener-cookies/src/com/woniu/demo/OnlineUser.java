package com.woniu.demo;

import java.util.Vector;

public class OnlineUser {
	static Vector users = new Vector();
	/**
	 * ��������û�
	 * @param uname
	 */
	public static void addUser(String uname){
		users.addElement(uname);
	}
	/**
	 * �Ƴ������û�
	 * @param uname
	 */
	public static void removeUser(String uname){
		users.removeElement(uname);
	}
	/**
	 * ��������û�������
	 * @return
	 */
	public static int getOnlineNum(){
		return users.size();
	}
	/**
	 * ������������û�
	 * @return
	 */
	public static Vector getOnlinUsers(){
		return users;
	}
}
