package com.woniu.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputDemo {

	public static void main(String[] args) throws IOException {
		File file =new File("1.txt");
		FileInputStream input = new FileInputStream(file);
		BufferedInputStream bInput = new BufferedInputStream(input);
//		int c = bInput.read();
//		byte[] b = new byte[(int) file.length()];
//		bInput.read(b);
		bInput.close();
		input.close();
	}

}
