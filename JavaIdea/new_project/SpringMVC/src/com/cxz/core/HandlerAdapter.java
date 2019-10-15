package com.cxz.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Map;

public class HandlerAdapter {

    private HandlerMapping handlerMapping;
    public HandlerAdapter( HandlerMapping handlerMapping ){
        this.handlerMapping = handlerMapping;
    }
    public void adapter(String key, HttpServletRequest request,HttpServletResponse response ){
        Method method = handlerMapping.getMethodMapping().get(key);
        Object object = handlerMapping.getControllerMapping().get(key);
        Map<String,String[]> paramMap = request.getParameterMap();
        if( method!=null && object!=null ){
            Parameter[] parameters = method.getParameters();
            Object[] params = new Object[parameters.length];
            for( int i=0; i<params.length; i++ ){
                Class paramType = parameters[i].getType();
                String paramTypeName = paramType.getSimpleName();
                String paramRealName = parameters[i].getName();
                if( paramTypeName.equals("HttpServletRequest") ) params[i]=request;
                else if( paramTypeName.equals("HttpServletResponse") ) params[i]=response;
                else if( paramType.isArray() ) params[i]=paramMap.get(paramRealName);
                else {
                    String[] val = paramMap.get(paramRealName);
                    Object value;
                    if( val!=null && (value=getValue(val[0],paramTypeName))!=null ){
                        params[i] = value;
                    }
                    else {
                        Field[] fields = paramType.getDeclaredFields();
                        Object po = null;
                        try {
                            po = paramType.newInstance();
                            for( Field f:fields ){
                                if( (f.getModifiers()&Modifier.STATIC)!=0 || (f.getModifiers()&Modifier.FINAL)!=0) {
                                   continue;
                                }
                                f.setAccessible(true);
                                String paramKey = paramType.getSimpleName()+"."+f.getName();
                                String[] values = paramMap.get(paramKey);
                                if( values!=null ){
                                    Object poFieldValue = getValue(values[0],paramTypeName);
                                    f.set(po,poFieldValue);
                                }
                            }
                        } catch (InstantiationException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        params[i] = po;
                    }
                }
            }
            try {
                method.invoke(object,params);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                response.sendError(404,"What's the Fuck");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private Object getValue( String sVal,String paramTypeName ) {
        Object object = null;
        if( paramTypeName.equals("int") || paramTypeName.equals("Integer") ) object=Integer.parseInt(sVal);
        if( paramTypeName.equals("byte") || paramTypeName.equals("Byte") ) object=Byte.parseByte(sVal);
        if( paramTypeName.equals("short") || paramTypeName.equals("short") ) object=Short.parseShort(sVal);
        if( paramTypeName.equals("long") || paramTypeName.equals("Long") ) object=Long.parseLong(sVal);
        if( paramTypeName.equals("float") || paramTypeName.equals("Float") ) object=Float.parseFloat(sVal);
        if( paramTypeName.equals("double") || paramTypeName.equals("Double") ) object=Double.parseDouble(sVal);
        if( paramTypeName.equals("char") || paramTypeName.equals("Character") ) object=sVal.charAt(0);
        if( paramTypeName.equals("boolean") || paramTypeName.equals("Boolean") ) object=Boolean.parseBoolean(sVal);
        if( paramTypeName.equals("String")) object=sVal;
        return object;
    }

}
