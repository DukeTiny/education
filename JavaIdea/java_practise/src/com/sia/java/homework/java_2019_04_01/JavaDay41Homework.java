package com.sia.java.homework.java_2019_04_01;

import java.io.*;
import java.text.SimpleDateFormat;

public class JavaDay41Homework {


    public static void main(String[] args) throws IOException {
        JavaDay41Homework jdh = new JavaDay41Homework();
//        try{
//            jdh.createAndMove();
//            jdh.throught( "D:/IOtest/HelloWorld.txt");
//        }
//        catch ( IOException e ) {
//            e.printStackTrace();
//        }
//        jdh.write();
//        jdh.copyPicture();
        jdh.copyAll("D:/woniu","D:/copy");
    }
    //创建和移动
    void createAndMove() throws IOException {
        // 创建文件以及判断是什么类型
        File file = new File("D:/HelloWorld.txt");
        file.createNewFile();
        if ( file.isFile() ) System.out.println("I'm a file");
        else System.out.println("I'm a directory");
        System.out.println("I'll move to IOtest");

        // 移动到IOtest
        File toDir = new File("D:/IOtest");
        toDir.mkdir();
        InputStream in = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        in.read(bytes);
        in.close();
        File toFile = new File(file.getAbsolutePath().replace(file.getParent(),(toDir.getCanonicalPath()+File.separator)));
        OutputStream out = new FileOutputStream(toFile);
        out.write(bytes);
        out.close();
        file.delete();
    }

    void throught( String str ) {
        File file = new File(str);
        File[] files = file.listFiles();
        if ( file.isDirectory() && files!=null ) {
            for ( File f:files ) {
                if ( f.isFile() ) {
                    System.out.println( f.getName() + "\t\t" + new SimpleDateFormat("yyyy-MM-dd hh:mm:dd").format(f.lastModified())
                    + "\t\t" + (f.isFile()?"<file>":"<dir>"));
                }
                if ( f.isDirectory() ){
                    System.out.println();
                    System.out.println( f.getName() + "\t\t" + new SimpleDateFormat("yyyy-MM-dd hh:mm:dd").format(f.lastModified())
                            + "\t\t" + (f.isFile()?"<file>":"<dir>"));
                    throught(f.getAbsolutePath());
                }
            }
        }
    }
    void write() {
        File file = new File("D:/Hello.txt");
        try {
            OutputStream out = new FileOutputStream(file);
            out.write("HelloJavaWorld你好世界".getBytes());
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    void copyPicture() throws IOException {
        File fromPicture = new File("D:/sia/princess.jpg");
        byte[] bytes = new byte[ (int)fromPicture.length() ];
        InputStream in = new FileInputStream(fromPicture);
        in.read(bytes);
        in.close();
        OutputStream out = new FileOutputStream("D:/princess.jpg");
        out.write(bytes);
        out.close();
    }

    void copyAll(String str1,String str2 ) throws IOException {
        File file1 = new File(str1);
        File file2 = new File(str2);
        file2.mkdir();
        if ( file1.isDirectory() ) {
            File[] files = file1.listFiles();
            if ( files!=null ) {
                for ( File f:files ) {
                    if ( f.isFile() ) {
                        InputStream in = new FileInputStream(f);
                        byte[] bytes = new byte[(int)f.length()];
                        in.read(bytes);
                        in.close();
                        OutputStream out = new FileOutputStream ( file2.getCanonicalPath() + File.separator + f.getName());
                        out.write(bytes);
                        out.close();
                    }
                    if ( f.isDirectory() ) {
                        File temp = new File(file2.getCanonicalPath() + File.separator + f.getName() );
                        temp.mkdir();
                        copyAll(f.getAbsolutePath(),temp.getAbsolutePath());
                    }
                }
            }
        }
    }

}
