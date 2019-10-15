package com.sia.java.practise.io_practise;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class IOPR {

    File newFile = new File("D:/Sia/a.properties");
    Properties pro = new Properties();

    public static void main(String[] args) throws IOException {
        File file = new File("D:/Sia/test.txt");
        // 字节流读取
//        InputStream in = new FileInputStream(file);
//        byte[] bytes = new byte[(int)file.length()];
//        in.read(bytes);
//        in.close();
//        for ( byte b:bytes ) System.out.println(b);
//        OutputStream outs = new FileOutputStream(file,true);
//        byte[] bytes = {1,2,3,4,5};
//        outs.write(bytes);
//        outs.flush();
//        outs.close();

        // 字符流读取
//        InputStream is = new FileInputStream(file);
//        InputStreamReader isr = new InputStreamReader(is,StandardCharsets.UTF_8);
//        BufferedReader reader = new BufferedReader(isr);
//        String content;
//        while ( ( content = reader.readLine() )!=null ){
//            System.out.println(content);
//        }
//        BufferedInputStream bis = new BufferedInputStream(is);
//        int num;
//        while ( (num = bis.read())!=-1 ){
//            System.out.print((char)num);
//        }

        OutputStream out = new FileOutputStream(file, true);
        OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(osw);
        writer.write("\r\n我就是这么逗比");

        writer.flush();
        writer.close();
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
        BufferedInputStream bis = new BufferedInputStream(is);
        String content;
        while ((content = reader.readLine()) != null) {
            System.out.println(content);
        }
        reader.close();


//        InputStreamRe  ader in = new InputStreamReader(is, StandardCharsets.UTF_8);
//        int i;
//        while( (i=in.read())!=-1 ) {
//            System.out.print((char)i);
//        }
//
//        int temp;
//        while ( (temp=in.read())!=-1 ) {
//            if( (char)temp!='\r' )
//                System.out.println((char)temp);
//        }
//        OutputStream out = new FileOutputStream(file,true);
//        OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
//        String content = "\r\n这是我添加的内容";
//        osw.write(content);
//        osw.flush();
//        osw.close();

//        char[] c = new char[(int)file.length()];
//        IOPR a = new IOPR();
//        a.pro.setProperty("wanghu","Handsome");
//        a.pro.setProperty("mading","Handsome");
//        System.out.println(a.pro.getProperty("wanghu"));
//        System.out.println(a.pro.stringPropertyNames());
    }

    public String getValue(String str) throws IOException {

        pro.load(new FileInputStream(newFile));
        return pro.getProperty(str);
    }

    public void setValue() throws IOException {
        System.out.println("AAAA");
    }

    public void setValue(String key, String value) throws IOException {
        pro.load(new FileInputStream(newFile));
        pro.setProperty(key, value);
        pro.store(new FileOutputStream(newFile, true), "");
    }


}
