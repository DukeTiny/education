package com.cxz.core;

import com.cxz.annotation.Controller;
import com.cxz.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建controller对象
 * 建立URL与controller
 * URL与method的映射关系
 *
 */
public class HandlerMapping {

    // 定义容器，存储所有的controller对象
    private Map<String,Object> ioc = new HashMap<>();
    // 建立URL与普通类的映射，可以把普通类的编程了servlet
    private Map<String,Object> controllerMapping = new HashMap<>();
    // 建立URL与Controller的映射关系，其实是与普通种的方法映射
    private Map<String,Method> methodMapping = new HashMap<>();

    public void init() {
        Collection controllers = ioc.values();
        for( Object controller:controllers ){
            Class clazz = controller.getClass();
            if( !clazz.isAnnotationPresent(RequestMapping.class)){
                continue;
            }
            RequestMapping classRM = (RequestMapping)clazz.getDeclaredAnnotation(RequestMapping.class);
            String controllerURL = classRM.value();
            Method[] methods = clazz.getDeclaredMethods();
            for( Method method:methods ){
                if(!method.isAnnotationPresent(RequestMapping.class)) continue;
                RequestMapping methodRM = (RequestMapping)method.getDeclaredAnnotation(RequestMapping.class);
                String methodURL = methodRM.value();
                String url = controllerURL+methodURL;
                System.out.println(url);
                controllerMapping.put(url,controller);
                methodMapping.put(url,method);
            }
        }
    }

    /*向Map种存入实例化的对象*/
    public void doInstance(List<String> classNames) {
        for( String className:classNames ){
            try {
                Class clazz = Class.forName(className);
                if( clazz.isAnnotationPresent(Controller.class)){
                    Object obj = clazz.newInstance();
                    String clName = firstLetterToLower(clazz.getSimpleName());
                    ioc.put(clName,obj);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private String firstLetterToLower(String simpleName) {
        return simpleName.replace(simpleName.charAt(0),(char)((byte)simpleName.charAt(0)+32));
    }

    public Map<String, Object> getIoc() {
        return ioc;
    }

    public void setIoc(Map<String, Object> ioc) {
        this.ioc = ioc;
    }

    public Map<String, Object> getControllerMapping() {
        return controllerMapping;
    }

    public void setControllerMapping(Map<String, Object> controllerMapping) {
        this.controllerMapping = controllerMapping;
    }

    public Map<String, Method> getMethodMapping() {
        return methodMapping;
    }

    public void setMethodMapping(Map<String, Method> methodMapping) {
        this.methodMapping = methodMapping;
    }
}
