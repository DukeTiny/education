package com.woniu.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("3.txt");
		PrintWriter pw = new PrintWriter(file);
		pw.println("abc");
		pw.println("ccc");
		pw.flush();
		pw.close();
	}

}
