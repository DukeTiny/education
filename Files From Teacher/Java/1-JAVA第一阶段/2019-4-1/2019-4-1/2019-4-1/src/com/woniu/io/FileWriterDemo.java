package com.woniu.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("d:/b.txt");
		FileWriter fw = new FileWriter(file,false);
//		fw.write('我');
		
		String str = "阿三地风dd俗";
//		fw.write(str.toCharArray());
		fw.write(str);
		fw.close();
	}

}
