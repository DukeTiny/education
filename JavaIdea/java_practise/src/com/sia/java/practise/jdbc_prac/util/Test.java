package com.sia.java.practise.jdbc_prac.util;

import com.sia.java.practise.io_practise.FilePractise;
import com.sia.java.practise.jdbc_prac.bean.ClassInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        Class c = ClassInfo.class;
        try {
            Constructor cons = c.getConstructor();
            ClassInfo classInfo = (ClassInfo)cons.newInstance();
            Method[] ms = c.getDeclaredMethods();
            Field[] fs = c.getDeclaredFields();
            int i=1;
            for ( Field f:fs ){
                System.out.print( f.getName() + "  ");
                System.out.println( f.getType().getName() );
            }
//            Field f = c.getDeclaredField("cname");
//            if ( !f.isAccessible() ) {
//                f.setAccessible(true);
//            }
//            f.set(classInfo,"王虎");
//            System.out.println(f.get(classInfo));
            for ( Method m:ms ){
                Class[] mParameter = m.getParameterTypes();
                System.out.println( m.isAccessible() );
//                if ( m.getName().startsWith("set")) {
//                    System.out.print(m.getName() + "  ");
//                    for (Class cc : mParameter) {
//                        System.out.print(cc.getName() + "  ");
//                        System.out.print( cc.getTypeName() );
//                    }
//                    System.out.println();
//                }
                i++;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
