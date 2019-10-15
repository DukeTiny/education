package com.cxz.g_httpmessageconverter.a_serversocket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppTest {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("服务器已经启动");
        Socket client = ss.accept();
        System.out.println("哇哈哈哈哈，我来了");
        InputStream in = client.getInputStream();

        while (in.available()==0);

        ByteArrayOutputStream bo = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];

        while (in.available()>0){
            int len = in.read(buf);
            bo.write(buf,0,len);
        }
        byte[] bytes = bo.toByteArray();
        System.out.println(new String(bytes));
        bo.close();
        in.close();
    }


}
