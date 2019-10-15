package com.woniu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端...");
		Socket s = new Socket("192.168.7.221", 10101);
		System.out.println("链接成功");
		InputStream in = s.getInputStream();
		byte[] b = new byte[1024];
		in.read(b);
		in.close();
		System.out.println(new String(b).trim());
	}

}
