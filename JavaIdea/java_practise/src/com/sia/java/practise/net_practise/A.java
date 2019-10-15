package com.sia.java.practise.net_practise;

import java.io.*;
import java.net.Socket;

public class A {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.7.240",110);
        InputStream in = s.getInputStream();
        byte[] bytes = new byte[1024];
        in.read( bytes );
        in.close();
        System.out.println( new String( bytes ).trim() );
        OutputStream out = s.getOutputStream();
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( out));
        bw.write("BBB");
        bw.flush();
        bw.close();
    }


}
