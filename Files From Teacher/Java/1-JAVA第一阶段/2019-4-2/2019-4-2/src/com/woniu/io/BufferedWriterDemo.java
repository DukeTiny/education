package com.woniu.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("2.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
//		bw.write(97);
//		String str = "asfasdf";
//		bw.write(str.toCharArray());
		bw.write("sdfsdfasd");
		bw.newLine();
		bw.write("asdfsdf");
		bw.flush();
		bw.close();
		fw.close();
	}

}
