package com.woniu.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	static String driver;
	static String url;
	static String user;
	static String password;
	static Connection conn;
	static String table;
	static{
		Properties pro = new Properties();
		try {
			pro.load(JdbcUtils.class.getResourceAsStream("db.properties"));
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			table = pro.getProperty("table");
			Class.forName(driver);
			createVO();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws SQLException{
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	public static void createVO(){
		String pack = "com.woniu.po";
		pack = pack.replace(".", "\\");
		File dirPack = new File("src"+File.separator+pack);
		System.out.println(dirPack.getAbsolutePath()+"+++++");
		if(!dirPack.exists()){
			dirPack.mkdirs();
		}
		table = turnFirstChar(table);
		File targetFile = new File(dirPack,table+".java");
		System.out.println(targetFile.getAbsolutePath()+"---------");
		StringBuffer strB = new StringBuffer();
		strB.append("package com.woniu.po;\r\n");
		strB.append("public class "+table+"{\r\n");
		try {
//			Connection conn = getConn();
//			Statement stat = conn.createStatement();
//			ResultSet rs = stat.executeQuery("select * from "+table);
//			ResultSetMetaData  rsmd = rs.getMetaData(); //获得每个列的名字和类型
			
			//结果集的信息
			ResultSetMetaData rsmd = getConn().createStatement().executeQuery("select * from "+table).getMetaData();
			//循环出指定表的每个列
			for(int i=1;i<=rsmd.getColumnCount();i++){
				//获得列类型的名字 int varchar
				System.out.println(rsmd.getColumnTypeName(i));
				//deptno dname loc
				String fieldName = rsmd.getColumnName(i).toLowerCase();
				switch(rsmd.getColumnTypeName(i)){
					case "INT":
						//private Integer deptno
						strB.append("private Integer "+fieldName+";\r\n");
						//public void setDeptno(Integer deptno){
						//	this.deptno=deptno;
						//}
						strB.append("public void set"+turnFirstChar(fieldName)+"(Integer "+fieldName+"){\r\n this."+fieldName+"="+fieldName+";\r\n}\r\n");
						strB.append("public Integer get"+turnFirstChar(fieldName)+"(){\r\n return this."+fieldName+";\r\n}\r\n");
						break;
					case "VARCHAR":
						strB.append("private String "+fieldName+";\r\n");
						strB.append("public void set"+turnFirstChar(fieldName)+"(String "+fieldName+"){\r\n this."+fieldName+"="+fieldName+";\r\n}\r\n");
						strB.append("public String get"+turnFirstChar(fieldName)+"(){\r\n return this."+fieldName+";\r\n}\r\n");
						break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		strB.append("}");
		try {
			FileWriter fw = new FileWriter(targetFile);
			fw.write(strB.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String turnFirstChar(String str){
		//dept
		char[] cs = str.toCharArray();
		if(cs[0]>=97){
			cs[0]-=32;
		}
		str = new String(cs);
		return str;
	}
	public static void closeConn(ResultSet rs,Statement stat,Connection conn){
		try {
			if(rs!=null){
					rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(111);
	}
}
