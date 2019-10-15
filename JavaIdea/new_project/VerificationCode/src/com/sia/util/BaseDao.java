package com.sia.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {
    private ComboPooledDataSource dataSource = new ComboPooledDataSource();
    private PreparedStatement ps;
    private Connection con;
    private static boolean done=false;
    private ResultSet rs;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        BaseDao.done = done;
    }

    public void doSomething(String sql,Object[] objects){
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(sql);
            for ( int i=0; i<objects.length; i++ ){
                ps.setObject(i+1,objects[i]);
            }
            done = ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConn(rs,ps,con);
        }
    }

    public List<T> getSomething(String sql,Object[] objects,Class<T> c){
        List<T> list = new ArrayList<>();
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(sql);
            for ( int i=0; i<objects.length; i++ ){
                ps.setObject(i+1,objects[i]);
            }
            rs = ps.executeQuery();
            while ( rs.next() ){
                T t = c.newInstance();
                Method[] methods = c.getDeclaredMethods();
                for( Method m:methods ){
                    String mName = m.getName();
                    if ( mName.startsWith("set") ){
                        m.invoke(t,rs.getObject( mName.substring(3) ));
                    }
                }
                list.add(t);
            }
        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConn(rs,ps,con);
        }
        return list;
    }
}
