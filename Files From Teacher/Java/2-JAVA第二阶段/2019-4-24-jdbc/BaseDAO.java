package com.woniu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.jdbc.bean.Course;
import com.woniu.util.JdbcUtils;

public class BaseDAO {
	static Connection conn;
	static PreparedStatement stat;
	static ResultSet rs;
	public static void update(String sql,Object[] objs){
		try {
			conn = JdbcUtils.getConn();
			stat = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				stat.setObject(i+1,objs[i]);
			}
			stat.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.closeConn(null,stat,conn);
		}
	}
	public static List<Course> select(String sql,Object[] objs){
		List<Course> cList = new ArrayList<Course>();
		try {
			conn = JdbcUtils.getConn();
			stat = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				stat.setObject(i+1, objs[i]);
			}
			rs = stat.executeQuery();
			while(rs.next()){
				Course c = new Course();
				c.setCname(rs.getString("cname"));
				c.setCno(rs.getString("cno"));
				c.setTno(rs.getString("tno"));
				cList.add(c);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.closeConn(null,stat,conn);
		}
		return cList;
	}
}
