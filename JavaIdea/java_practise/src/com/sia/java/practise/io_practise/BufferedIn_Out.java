package com.sia.java.practise.io_practise;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BufferedIn_Out {

    public static void main(String[] args) throws IOException {
//        bufOut();
//        bufReader();
//        bufWriter();
        printTest();
    }


    static void bufIn() throws IOException {
        File file =  new File("D:/Sia/JavaIdea/src/com/sia/java/practise/io_practise/1.txt");
        InputStream in = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(in);
        byte[] buf = new byte[(int) file.length()];
        bis.read(buf);
//        int i=-1;
//        while ( (i=bis.read())!=-1) {
//            System.out.print((char)i);
//        }
        bis.close();
        System.out.println( new String(buf));
    }

    static void bufOut() throws IOException {
        File file =  new File("D:/Sia/JavaIdea/src/com/sia/java/practise/io_practise/1.txt");
        OutputStream out = new FileOutputStream(file,true);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        bos.write("\r\n春路雨添花，花动一山春色。行到小溪处，有黄鹂千百。".getBytes());
        bos.flush();
        bos.close();
    }

    static void bufReader() throws IOException {
        File file =  new File("D:/Sia/JavaIdea/src/com/sia/java/practise/io_practise/1.txt");

        InputStream in = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        while ( br.ready() ){
            System.out.print( (char)br.read() );
//            System.out.println( br.readLine() );
        }
    }
    static void bufWriter() throws IOException {
        File file =  new File("D:/Sia/JavaIdea/src/com/sia/java/practise/io_practise/1.txt");

        OutputStream out = new FileOutputStream(file,true);
        OutputStreamWriter os = new OutputStreamWriter(out, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(os);
        bw.write("\r\n飞云当面化龙蛇，夭矫转空碧。醉卧古藤阴下，了不知南北。");
        bw.flush();
        bw.close();
    }
    static void printTest() throws IOException {
        PrintWriter pw = new PrintWriter("D:/Sia/JavaIdea/src/com/sia/java/practise/io_practise/1.txt");
        pw.write("asdasdsdadasd");
//        pw.println("好事近 梦中作[秦观]");
//        pw.print(5);
        pw.flush();
        pw.close();
    }
}
