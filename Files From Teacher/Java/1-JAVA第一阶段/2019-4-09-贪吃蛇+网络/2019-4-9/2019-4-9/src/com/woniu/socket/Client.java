package com.woniu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�ͻ���...");
		Socket s = new Socket("192.168.7.221", 10101);
		System.out.println("���ӳɹ�");
		InputStream in = s.getInputStream();
		byte[] b = new byte[1024];
		in.read(b);
		in.close();
		System.out.println(new String(b).trim());
	}

}
