package com.cxz.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDao<T> {

    private static PreparedStatement ps;
    private static Connection con;
    private static ResultSet rs;
    private ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public void doSomething(String sql,Object[] objects) {
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(sql);
            for ( int i=0; i<objects.length; i++ ){
                ps.setObject(i+1,objects[i]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDaoUtil.closeAll(rs,ps,con);
        }
    }

    public List<T> getSomething(String sql, Object[] objects,Class c){
        List<T> users = new ArrayList<>();
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(sql);
            for ( int i=0; i<objects.length; i++ ){
                ps.setObject(i+1,objects[i]);
            }
            rs = ps.executeQuery();
            while ( rs.next() ){
                T t = (T) c.newInstance();
                Method[] methods = c.getDeclaredMethods();
                for( Method m:methods ){
                    String mName = m.getName();
                    if( mName.startsWith("set")){
                        Class[] cs = m.getParameterTypes();
                        mName = mName.substring(3);
                        if(cs[0]==Integer.class) m.invoke(t, rs.getInt(mName));
                        else if(cs[0]==String.class) m.invoke(t, rs.getString(mName));
                        else if(cs[0]==Date.class) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(m.invoke(t, rs.getDate(mName)));
                        else if(cs[0]==Double.class) m.invoke(t, rs.getDouble(mName));
                        else if(cs[0]==Float.class)m.invoke(t, rs.getFloat(mName));
                    }
                }
                users.add(t);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
           BaseDaoUtil.closeAll(rs,ps,con);
        }
        return users;
    }
}
