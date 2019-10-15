package com.woniu.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.util.JdbcUtils;

public class BaseDAO<T> {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	public void update(String sql,Object[] objs,Class c){
		try {
			conn = JdbcUtils.getConn();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1, objs[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.closeConn(null, ps, conn);
		}
	}
	public List<T> select(String sql,Object[] objs,Class c){
		List<T> courses = new ArrayList<T>();
		try {
			conn = JdbcUtils.getConn();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1, objs[i]);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				T t = (T) c.newInstance();
				Method[] ms = c.getDeclaredMethods();
				for(Method m:ms){
					String methodName = m.getName();
					if(methodName.startsWith("set")){
						String feildName = methodName.substring(3);
						m.invoke(t, rs.getString(feildName));
					}
				}
				courses.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.closeConn(null, ps, conn);
		}
		return courses;
	}
}
