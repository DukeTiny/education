package com.woniu.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("2.txt");
		FileOutputStream out = new FileOutputStream(file);
		BufferedOutputStream output = new BufferedOutputStream(out);
//		output.write(97);
//		String str = "abcd";
//		output.write(str.getBytes());
		output.flush();
		output.close();
		out.close();
	}

}
