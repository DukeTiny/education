package com.cxz.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateObjArray {


    public static Object[] insert(Object o){
        return getObjectArr(o);
    }

    public static Object[] update(Object o,String pk_name){
        return getObjectArr(o,pk_name);
    }

    public static Object[] del( Integer primaryKeyValue){
        return new Object[]{primaryKeyValue};
    }

    public static Object[] findAll(){
        return new Object[]{};
    }

    public static Object[] findOne(Integer primaryKeyValue){
        return new Object[]{primaryKeyValue};
    }


    private static Object[] getObjectArr(Object o,String pk_name){
        Class c = o.getClass();
        Method[] methods = c.getDeclaredMethods();
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
        Object[] objects = new Object[fLen];
        for( int i=0 ;i<fLen; i++ ){
            for (Method method : methods) {
                String mName = method.getName();
                if (mName.startsWith("get") && mName.substring(3).equalsIgnoreCase(fields[i].getName())) {
                    try {
                        if( method.getReturnType()==Date.class){
                            Date date = (Date)method.invoke(o);
                            String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                            objects[i] = dateStr;
                        }
                        else{
                            objects[i] = method.invoke(o);
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return objects;
    }

    private static Object[] getObjectArr(Object o){
        Class c = o.getClass();
        Method[] methods = c.getDeclaredMethods();
        Field[] fields = c.getDeclaredFields();
        int fLen = fields.length;
        Object[] objects = new Object[fLen];
        for( int i=0 ;i<fLen; i++ ){
            for (Method method : methods) {
                String mName = method.getName();
                if (mName.startsWith("get") && mName.substring(3).equalsIgnoreCase(fields[i].getName())) {
                    try {
                        if( method.getReturnType()==Date.class){
                            Date date = (Date)method.invoke(o);
                            String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                            objects[i] = dateStr;
                        }
                        else{
                            objects[i] = method.invoke(o);
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return objects;
    }

}
