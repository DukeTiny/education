package com.sia.java.practise.jdbc_prac.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ClassDaoUtil {
    static String iDriver;
    static String url;
    static String username;
    static String pass;

    static {
        Properties pro = new Properties();
        try {
            pro.load( ClassDaoUtil.class.getResourceAsStream("util.properties"));
            iDriver = pro.getProperty("iDriver");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            pass = pro.getProperty("pass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName( iDriver );
//        Class c = com.mysql.jdbc.Driver.class;
//        Driver driver = (Driver) c.newInstance();
        Connection con = DriverManager.getConnection(url,username,pass);
        return con;

    }

    public static void closeAll(Statement state, ResultSet rs,Connection con) throws SQLException {
        if( rs!=null ) rs.close();
        if( state!=null ) state.close();
        if( con!=null ) con.close();
    }
}
