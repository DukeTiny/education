package com.cxz.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateObjArray {


    public static Object[] insert(Object o){
        Object[] objects = getObjectArr(o);
        objects[0] = null;
        return objects;
    }

    public static Object[] update(Object o){
        Object[] objects = getObjectArr(o);
        Object temp = objects[0];
        for( int i=0; i<objects.length; i++ ){
            if( i!=objects.length-1) objects[i] = objects[i+1];
            else objects[i] = temp;
        }
        return objects;
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
                            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
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
