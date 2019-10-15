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
//        generateDAO();
        generateService();
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
    private static void generateDAO(){
        try {
            String[] tableArr = table.split(":");
            for(String tableName:tableArr){
                StringBuilder sb = new StringBuilder("package com.cxz.dao;\r\n\r\n");
                StringBuilder sb1 = new StringBuilder("package com.cxz.dao;\r\n\r\n");
                File file = new File("src/com/cxz/dao/");
                if( !file.exists() ) file.mkdirs();
                String firstLetter = tableName.substring(0,1).toUpperCase();
                String className = firstLetter+tableName.substring(1);
                sb.append("public interface I").append(className).append("DAO").append(" {\r\n");
                sb1.append("public class ").append(className).append("DAOImpl").append(" implements ");
                sb1.append("I").append(className).append("DAO {\r\n\r\n");
                sb1.append("    private GenerateSQL gs = new GenerateSQL(").append(className).append(".class,\"");
                sb1.append(tableName).append("\");\r\n\r\n");
                sb1.append("    private BaseDao<").append(className).append("> bd = new BaseDao<>();\r\n\r\n");
                for( int i=0; i<5; i++ ){
                    switch (i){
                        case 0:
                            sb.append("    void add(").append(className).append(" ").append( tableName ).append(");\r\n");
                            sb1.append("    public void add(").append(className).append(" ").append( tableName ).append(") {\r\n");
                            sb1.append("        String sql = ").append("gs.insert();\r\n");
                            sb1.append("        Object[] objs = ").append("GenerateObjArray.insert(").append(tableName).append(");\r\n");
                            sb1.append("        bd.doSomething(").append("sql,objs);\r\n    }\r\n");
                            break;
                        case 1:
                            sb.append("    void update(").append(className).append(" ").append( tableName ).append(");\r\n");
                            sb1.append("    public void update(").append(className).append(" ").append( tableName ).append(") {\r\n");
                            sb1.append("        String sql = ").append("gs.update();\r\n");
                            sb1.append("        Object[] objs = ").append("GenerateObjArray.update(").append(tableName).append(");\r\n");
                            sb1.append("        bd.doSomething(").append("sql,objs);\r\n    }\r\n");
                            break;
                        case 2:
                            sb.append("    void del(").append("Integer id").append(");\r\n");
                            sb1.append("    public void del(Integer id) {\r\n");
                            sb1.append("        String sql = ").append("gs.del();\r\n");
                            sb1.append("        Object[] objs = ").append("GenerateObjArray.del(id);\r\n");
                            sb1.append("        bd.doSomething(").append("sql,objs);\r\n    }\r\n");
                            break;
                        case 3:
                            sb.append(className).append(" getOne(Integer id);\r\n");
                            sb1.append("   public ").append(className).append(" getOne(Integer id) {\r\n");
                            sb1.append("        String sql = ").append("gs.findOne();\r\n");
                            sb1.append("        Object[] objs = ").append("GenerateObjArray.findOne(id);\r\n");
                            sb1.append("        List<").append(className).append("> ").append(tableName).append("s = bd.getSomething(").append("sql,objs,").append(className).append(".class);\r\n");
                            sb1.append("        return ").append(tableName).append("s.size() == 0?null:").append(tableName).append("s.get(0);\r\n    }\r\n");

                            break;
                        case 4:
                            sb.append("    List<").append(className).append("> getAll();\r\n");
                            sb1.append("    public ").append("List<").append(className).append("> getAll() {\r\n");
                            sb1.append("        String sql = ").append("gs.findAll();\r\n");
                            sb1.append("        Object[] objs = ").append("GenerateObjArray.findAll();\r\n");
                            sb1.append("        return bd.getSomething(").append("sql,objs,").append(className).append(".class);\r\n    }\r\n");
                            break;
                    }
                }
                sb.append("}");
                sb1.append("}");
                PrintWriter pw = new PrintWriter(new File("src/com/cxz/dao/I"+className+"DAO.java"));
                pw.write(sb.toString());
                pw.flush();
                pw = new PrintWriter(new File("src/com/cxz/dao/"+className+"DAOImpl.java"));
                pw.write(sb1.toString());
                pw.flush();
                pw.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void generateService(){
        try {
            String[] tableArr = table.split(":");
            for(String tableName:tableArr){
                StringBuilder sb = new StringBuilder("package com.cxz.service;\r\n\r\n");
                StringBuilder sb1 = new StringBuilder("package com.cxz.service;\r\n\r\n");
                File file = new File("src/com/cxz/service/");
                if( !file.exists() ) file.mkdirs();
                String firstLetter = tableName.substring(0,1).toUpperCase();
                String className = firstLetter+tableName.substring(1);
                sb.append("public interface I").append(className).append("Service").append(" {\r\n");
                sb1.append("public class ").append(className).append("ServiceImpl").append(" implements ");
                sb1.append("I").append(className).append("Service {\r\n\r\n");
                for( int i=0; i<5; i++ ){
                    switch (i){
                        case 0:
                            sb.append(" \n   void add(").append(className).append(" ").append( tableName ).append(");\r\n");
                            sb1.append("\n    public void add(").append(className).append(" ").append( tableName ).append(") {\r\n");
                            sb1.append("        DAOFactory.get").append(className).append("DAOImpl().add(").append(tableName).append(");\r\n");
                            sb1.append("    }\r\n");
                            break;
                        case 1:
                            sb.append("\n    void update(").append(className).append(" ").append( tableName ).append(");\r\n");
                            sb1.append("\n    public void update(").append(className).append(" ").append( tableName ).append(") {\r\n");
                            sb1.append("        DAOFactory.get").append(className).append("DAOImpl().update(").append(tableName).append(");\r\n");
                            sb1.append("    }\r\n");
                            break;
                        case 2:
                            sb.append("\n    void del(").append("Integer id").append(");\r\n");
                            sb1.append("\n    public void del(Integer id) {\r\n");
                            sb1.append("        DAOFactory.get").append(className).append("DAOImpl().del(id);\r\n");
                            sb1.append("    }\r\n");
                            break;
                        case 3:
                            sb.append("\n    ").append(className).append(" getOne(Integer id);\r\n");
                            sb1.append("\n    public ").append(className).append(" getOne(Integer id) {\r\n");
                            sb1.append("        return ").append(" DAOFactory.get").append(className).append("DAOImpl().getOne(id);\r\n");
                            sb1.append("    }\r\n");
                            break;
                        case 4:
                            sb.append("\r\n    List<").append(className).append("> getAll();\r\n");
                            sb1.append("\r\n    public ").append("List<").append(className).append("> getAll() {\r\n");
                            sb1.append("        return ").append(" DAOFactory.get").append(className).append("DAOImpl().getAll();\r\n");
                            sb1.append("    }\r\n");
                            break;
                    }
                }
                sb.append("}");
                sb1.append("}");
                PrintWriter pw = new PrintWriter(new File("src/com/cxz/service/I"+className+"Service.java"));
                pw.write(sb.toString());
                pw.flush();
                pw = new PrintWriter(new File("src/com/cxz/service/"+className+"ServiceImpl.java"));
                pw.write(sb1.toString());
                pw.flush();
                pw.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void generatePO(){
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
                String[] strs = new String[10];
                for( int i=1; i<=cols; i++ ){
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
                        case "DECIMAL":
                            typeName = "Double";
                            break;
                    }
                    StringBuilder colName = new StringBuilder(rsmd.getColumnName(i));
                    StringBuilder upperColName = new StringBuilder(rsmd.getColumnName(i));
                    upperColName.setCharAt(0,(String.valueOf(upperColName.charAt(0)).toUpperCase()).charAt(0));
                    sb.append("    private ").append(typeName).append(" ").append(colName).append(";\r\n");
                    sb.append("\r\n");
                    sb.append("    public void set").append(upperColName).append(" (").append(typeName).append(" ").append(typeName.toLowerCase());
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
        } finally {
            closeAll(null,ps,con);
        }
    }
}
