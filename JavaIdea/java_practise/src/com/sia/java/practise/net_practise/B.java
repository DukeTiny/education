package com.sia.java.practise.net_practise;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class B {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(110);
        Socket s = ss.accept();
        OutputStream out = s.getOutputStream();
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( out));
        bw.write("AAA");
        bw.flush();
        bw.close();

    }
}
