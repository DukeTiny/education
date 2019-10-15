package com.sia.java.practise.properties_practise;

import java.io.*;
import java.util.Properties;

public class rpTestDrive {

    public static void main(String[] args) throws IOException {
//        ReadProperties rp = new ReadProperties();
        File streamFile = new File ("config.properties");
        InputStream in = new FileInputStream(streamFile);
        Properties pro = new Properties();
        pro.load(in);
        File file = new File ( pro.getProperty("filename") );
        pro.clear();
        pro.load(new FileInputStream(file));
        pro.setProperty("TestDrive","GOGOGO");
        pro.store( new FileOutputStream("D:\\test.properties"),"这是注释");
//        try {
//            FileWriter fw = new FileWriter(file,true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            bw.write("\r\n春路雨添花");
//            bw.flush();
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
