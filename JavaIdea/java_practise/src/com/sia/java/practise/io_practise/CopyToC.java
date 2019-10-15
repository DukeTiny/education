package com.sia.java.practise.io_practise;

import java.io.*;

public class CopyToC {

    public static void main(String[] args) throws IOException {
        File fromFile = new File("D:/gs.txt");
        InputStream in = new FileInputStream(fromFile);
        byte[] bytes = new byte[(int)fromFile.length()];
        in.read(bytes);
        in.close();
        File toFile = new File("C:/gs2.txt");
        OutputStream out = new FileOutputStream(toFile);
        out.write(bytes);
        out.close();
    }

}
