package com.woniu.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("服务器端...");
		ServerSocket ss = new ServerSocket(10101);
		Socket s = ss.accept();
		System.out.println("链接成功...");
		OutputStream out = s.getOutputStream();
		out.write("hello client".getBytes());
		out.flush();
		out.close();
	}
}
