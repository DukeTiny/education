package com.cxz.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

public class BaseDaoUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static String table;
    static {
        Properties pro = new Properties();
        try {
            pro.load(BaseDaoUtil.class.getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = pro.getProperty("driver");
        url = pro.getProperty("url");
        user = pro.getProperty("user");
        password = pro.getProperty("password");
        table = pro.getProperty("table");
    }

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName(driver);
            String[] tableArr = table.split(":");
            con = DriverManager.getConnection(url,user,password);
            for(String tableName:tableArr){
                StringBuilder sb = new StringBuilder("package com.cxz.po;\r\n\r\n");
                File file = new File("src/com/cxz/po/");
                if( !file.exists() ) file.mkdirs();
                String firstLetter = tableName.substring(0,1);
                String className = firstLetter+tableName.substring(1);
                sb.append("public class ").append(className).append(" {\r\n");
                ps = con.prepareStatement("SELECT * FROM `"+ tableName +"`");
                ResultSetMetaData rsmd = ps.executeQuery().getMetaData();
                int cols = rsmd.getColumnCount();
                for( int i=1; i<cols; i++ ){
                    String typeName = rsmd.getColumnTypeName(i);
                    switch (typeName) {
                        case "INT":
                            typeName = "Integer";
                            break;
                        case "VARCHAR":
                        case "CHAR":
                        case "TEXT":
                            typeName = "String";
                            break;
                        case "DATETIME":
                        case "TIMESTAMP":
                        case "DATE":
                            typeName = "Date";
                            break;
                    }
                    StringBuilder colName = new StringBuilder(rsmd.getColumnName(i));
                    StringBuilder upperColName = new StringBuilder(rsmd.getColumnName(i));
                    upperColName.setCharAt(0,(String.valueOf(colName.charAt(0)).toUpperCase()).charAt(0));
                    sb.append("    private ").append(typeName).append(" ").append(colName).append(";\r\n");
                    sb.append("\r\n");
                    sb.append("    public void set").append(colName).append(" (").append(typeName).append(" ").append(typeName.toLowerCase());
                    sb.append(") { \r\n");
                    sb.append("        this.").append(colName).append(" = ").append(typeName.toLowerCase()).append(";\r\n");
                    sb.append("    }\r\n\r\n");
                    sb.append("    public ").append(typeName).append(" get").append(upperColName).append("(){\r\n");
                    sb.append("        return this.").append(colName).append(";\r\n");
                    sb.append("    }\r\n");
                    sb.append("\r\n");
                }
                sb.append("}");
                PrintWriter pw = new PrintWriter(new File("src/com/cxz/po/"+className+".java"));
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }

        } catch (SQLException | FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void closeAll(ResultSet rs, PreparedStatement ps, Connection con ){
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }
}
