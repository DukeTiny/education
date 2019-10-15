package com.woniu.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("1.txt");
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
//		while(br.ready()){
//			int i = br.read();
//			System.out.print((char)i);
//		}
//		char[] c = new char[(int) file.length()];
//		br.read(c);
//		System.out.println(new String(c));
//		while(br.ready()){
//			String str = br.readLine();
//			System.out.println(str);
//		}
		br.close();
		reader.close();
	}

}
