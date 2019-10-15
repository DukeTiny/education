package com.woniu.util;

import java.sql.*;
import java.io.IOException;
import java.util.Properties;

public class DAOUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    static {
        Properties pro = new Properties();
        try {
            pro.load( DAOUtil.class.getResourceAsStream("config.properties"));
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getCon(){
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeAll(ResultSet rs, PreparedStatement ps, Connection con){
        try {
            if ( rs!=null ) rs.close();
            if ( ps!=null ) ps.close();
            if ( con!=null ) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

