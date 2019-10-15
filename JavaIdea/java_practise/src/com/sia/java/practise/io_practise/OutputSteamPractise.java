package com.sia.java.practise.io_practise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputSteamPractise {


    public static void main(String[] args) throws IOException {
            OutputStream out = new FileOutputStream("D:/output.txt");
            out.write("1111111111123234".getBytes());
            out.write("abc".getBytes());
            out.write('a');
    }



}
