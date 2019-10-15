package com.cxz.review;

public class AppTest {
	
	
	public static void main(String[] args) throws Exception {
		IUserDao dao = new UserDaoImpl();
		Myproxy mp = new Myproxy();
		IUserDao proxy = (IUserDao) mp.getProxy(dao);
		proxy.save( new User());
		proxy.update( new User());
		proxy.delete(1);
	}
	

}
