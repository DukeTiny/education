package com.woniu.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("c:/gs2.txt");
		FileReader fr = new FileReader(file);
//		int i = fr.read();	//��ȡһ���ַ�
//		System.out.println(i);
		
//		char[] c = new char[(int) file.length()];
//		fr.read(c); //�����ݶ����ַ�������
//		fr.close();
//		System.out.println(new String(c));
		
//		while(fr.ready()){
//			int i = fr.read();
//			System.out.print((char)i);
//		}
		
		for(int i=0;i<file.length();i++){
			int j = fr.read();
			System.out.print((char)j);
		}
	}

}
