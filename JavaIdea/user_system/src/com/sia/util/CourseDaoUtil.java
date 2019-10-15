package com.sia.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class CourseDaoUtil {
    public static String driver;
    public static String url;
    public static String user;
    public static String password;

    static {
        Properties pro = new Properties();
        try {
            pro.load(CourseDaoUtil.class.getResourceAsStream("configure.properties"));
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeAll(ResultSet rs,PreparedStatement ps, Connection con ){
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }
}
