package com.sia.java.practise.io_practise;

import java.io.*;

public class MoveToC {

    public static void main(String[] args) throws IOException {
        File fromFile = new File("D:/gs.txt");
        InputStream in = new FileInputStream(fromFile);
        byte[] bytes = new byte[ (int)fromFile.length() ];
        in.read(bytes);
        in.close();
        File toFile = new File("C:/abc/");
        toFile.mkdir();
        File toFile2 = new File("C:/abc/gs.txt");
        FileWriter fw = new FileWriter(toFile2);
//        OutputStream fw = new FileOutputStream(toFile2);
        fw.write(new String(bytes));
        fw.close();
        fromFile.delete();
    }
}
