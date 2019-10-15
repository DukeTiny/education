package com.cxz.util;

import java.sql.*;

public class JdbcUtils {
    static {
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/maven?useSSL=false&characterEncoding=utf-8";
        String user = "root";
        String password = "wh809919";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void free(ResultSet rs,PreparedStatement ps,Connection con){
        try {
            if( rs!=null ) rs.close();
        } catch (Exception e ){
           throw new RuntimeException();
        } finally {
            try {
                if( ps!=null ) ps.close();
            } catch (Exception e) {
                throw  new RuntimeException();
            } finally {
                try {
                    if( con!=null ) con.close();
                } catch (Exception e){
                    throw new RuntimeException();
                }
            }
        }
    }
}
