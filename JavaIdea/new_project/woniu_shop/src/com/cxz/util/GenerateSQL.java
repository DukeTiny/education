package com.cxz.util;

import com.cxz.bean.Stock;

import java.lang.reflect.Field;

public class GenerateSQL {

    private String tableName;
    private Class c;

    public GenerateSQL(Class c,String tableName){
        this.tableName = tableName;
        this.c = c;
    }

    public String insert(){
        StringBuilder sb = new StringBuilder("INSERT INTO ");
        sb.append(tableName);
        int len = c.getDeclaredFields().length;
        sb.append(" VALUES(");
        for ( int i=0; i<len; i++ ){
            if( len==1 ) sb.append("?");
            else if ( i!=len-1)sb.append("?,");
            else sb.append("?");
        }
        sb.append(")");
        return sb.toString();
    }

    public String update(){
        StringBuilder sb = new StringBuilder("UPDATE ").append(tableName).append(" SET ");
        Field[] fields = c.getDeclaredFields();
        int len = fields.length;
        for ( int i=0; i<len; i++ ){
            if ( i<len-2)sb.append(fields[i+1].getName()).append("=?,");
            else if( i==len-2 ) sb.append(fields[i+1].getName()).append("=? ");
            else sb.append("WHERE ").append(fields[0].getName()).append("=?");
        }
        return sb.toString();
    }

    public String del(){
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb = sb.append(tableName).append(" WHERE ");
        sb = sb.append(c.getDeclaredFields()[0].getName());
        sb.append("=?");
        return sb.toString();
    }

    public String findAll(){
        return "SELECT * FROM " + tableName;
    }

    public String findOne(){
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(tableName).append(" WHERE ");
        sb = sb.append(c.getDeclaredFields()[0].getName()).append("=?");
        return sb.toString();
    }


}
