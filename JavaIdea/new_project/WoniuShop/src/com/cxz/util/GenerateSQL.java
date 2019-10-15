package com.cxz.util;

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
        Field[] fields = c.getDeclaredFields();
        sb.append(" SET(");
        int len = fields.length;
        for (int i = 0; i < len; i++) {
            if ( i<len-1 ) sb.append(fields[i].getName()).append(",");
            else sb.append(fields[i].getName()).append(") ");
        }
        sb.append("VALUES(");
        for ( int i=0; i<len; i++ ){
            if( len==1 ) sb.append("?");
            else if ( i!=len-1)sb.append("?,");
            else sb.append("?");
        }
        sb.append(")");
        return sb.toString();
    }

    public String update(String pk_name){
        StringBuilder sb = new StringBuilder("UPDATE ").append(tableName).append(" SET ");
        Field[] fields = c.getDeclaredFields();
        int fLen = fields.length;
        for (int i = 0; i < fLen; i++) {
            if( pk_name.equals(fields[i].getName())){
                Field tempField = fields[i];
                fields[i] = fields[fLen-1];
                fields[fLen-1] = tempField;
                break;
            }
        }
        for ( int i=0; i<fLen; i++ ){
            if ( i<fLen-2)sb.append(fields[i+1].getName()).append("=?,");
            else if( i==fLen-2 ) sb.append(fields[i+1].getName()).append("=? ");
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
