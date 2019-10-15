package com.sia.java.practise.io_practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class FilePractise {

    public static void main(String[] args) throws IOException {

//        for ( int i=0; i<=12; i++ ) {
//            if ( i==0 ){
//                File file = new File("d:/woniu");
//                file.mkdir();
//            }
//            else if ( i<=10){
//                File file = new File("d:/woniu/" + i + ".txt");
//                file.createNewFile();
//            }
//            else if ( i==11){
//                File file = new File("d:/woniu/abc");
//                file.mkdir();
//            }
//            else {
//                File file = new File("d:/woniu/bbb");
//                file.mkdir();
//            }
//        }
//        File file = new File("D:/woniu/10.txt");
//        System.out.println ( file.getName() );
//        System.out.println ( file.getAbsolutePath() );
//        System.out.println ( file.getParent() );
//        System.out.println ( "File" + file.isFile() );
//        System.out.println ( "Dir" + file.isDirectory() );
//        File file2 = new File("D:/woniu/2.txt");
//        file2.delete();
//        showAll ( new File("D:/woniu"));
//        input();
//        input1();
//        input3();
//        File file = new File("D:/eee/a.txt" );
//        file.mkdir();
//        file.createNewFile();
//        InputStream in = new FileInputStream(file);
//        byte[] bytes = new byte[(int) file.length()];
//        in.read(bytes);
//        System.out.println(new String(bytes));
//        for ( int i=0; i<bytes.length; i++ ){
//            System.out.print((char)bytes[i]);
//        }
//        System.out.println();
//        int temp=-1;
//        for ( int i=0; i<file.length(); i++ ){
//            temp = in.read();
//            System.out.print((char)temp);
//        }
//        in.close();
        File file = new File("D:/woniu");
        showAll(file);

    }

    static void showAll( File dir ) {
        if ( dir.isDirectory() && dir.exists() ) {
            for ( File f:dir.listFiles() ) {
//                if ( f.getName().indexOf(".txt")==-1 ){
                    if(  f.isFile() )
                        System.out.println(f.getName() + "\t\t"  + new SimpleDateFormat("yyyy-MM-dd  hh:mm:dd").format(f.lastModified()) + "\t\t" + (f.isFile()?"<file>":"<dir>"));
                    else {
                        System.out.println();
                        System.out.println(f.getName() + "\t\t"  + new SimpleDateFormat("yyyy-MM-dd  hh:mm:dd").format(f.lastModified()) + "\t\t" + (f.isFile()?"<file>":"<dir>"));
                        if ( f.isDirectory() && f.exists() ) {
                            for ( File d:f.listFiles() ) {
                                System.out.print("\t");
                                System.out.println(d.getName() + "\t\t"  + new SimpleDateFormat("yyyy-MM-dd  hh:mm:dd").format(d.lastModified()) + "\t\t" + (d.isFile()?"<file>":"<dir>"));
                                if ( d.isDirectory() ) showAll(d);
                            }
                        }
                    }
//                }
            }

        }
    }

    static void input( ) throws IOException {
        File file = new File("D:/1.txt");
//        file.createNewFile();
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[ (int)file.length() ];
        in.read(b);
        String str = new String(b);
        System.out.println ( str );

    }
    static void input1( ) throws IOException {
        File file = new File("D:/1.txt");
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[ (int)file.length() ];
        in.read(b);
        for ( byte bb:b ) System.out.print((char)bb);
        System.out.println();
    }
    static void input3( ) throws IOException {
        File file = new File("D:/1.txt");
        InputStream in = new FileInputStream(file);
        for ( int i=0; i<file.length(); i++ ){
            System.out.print((char)in.read());
        }

    }
}
