package com.cxz.dispatcherservlet;

import com.cxz.annotation.Controller;
import com.cxz.annotation.RequestMapping;
import com.cxz.core.HandlerAdapter;
import com.cxz.core.HandlerMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class DispatcherServlet extends HttpServlet {
    private final static long serialVersionUID = 1L;
    private Properties pro = new Properties();
    private List<String> classNames = new ArrayList<>();
    private HandlerMapping handlerMapping = new HandlerMapping();
    private HandlerAdapter handlerAdapter;

    @Override
    public void init() throws ServletException {
        // 获取初始化参数，取得配置文件名称
        loadProperties();
        // 扫描指定包下的所有的类,获取类全名
        String packageName = pro.getProperty("package");
        doScanner(packageName);
        handlerMapping.doInstance(classNames);
        handlerMapping.init();
        initHandlerAdapter();
    }

    private void initHandlerAdapter() {
        this.handlerAdapter = new HandlerAdapter(handlerMapping);
    }


    private void doScanner(String packageName) {
        String packageFilePath = packageName.replaceAll("\\.","/");
        URL url = DispatcherServlet.class.getClassLoader().getResource(packageFilePath);
        File file = new File(url.getFile().replaceAll("%20",""));
        File[] files = file.listFiles();
        if ( files==null ){
            return;
        }
        for (File f :files) {
            if( f.isDirectory()){
                doScanner(packageName+"."+f.getName());
            }
            else {
                String fullClassName = packageName+"."+f.getName();
                classNames.add(fullClassName.replace(".class",""));
            }
        }
    }

    private void loadProperties() {
        String configFileName = getInitParameter("config");
        InputStream is = DispatcherServlet.class.getClassLoader().getResourceAsStream(configFileName);
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String key = uri.replace(req.getContextPath(),"");
        handlerAdapter.adapter(key,req,resp);
    }
}
