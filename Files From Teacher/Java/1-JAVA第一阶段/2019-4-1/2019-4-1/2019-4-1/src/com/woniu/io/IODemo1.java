package com.woniu.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo1 {

	public static void main(String[] args) throws IOException {
		// 1、将一首古诗写入"d:/gs.txt"。
		// File file = new File("d:/gs.txt");
		// FileWriter fw = new FileWriter(file);
		// fw.write("啊随风倒就阿三地飞撒娇法律");
		// fw.close();
		// 2、将d:/gs.txt拷贝到c:/gs2.txt。
		// //先读出d:/gs.txt的内容
		// File sourceFile = new File("d:/gs.txt");
		// FileInputStream input = new FileInputStream(sourceFile);
		// byte[] b = new byte[(int) sourceFile.length()];
		// input.read(b);
		// input.close();
		// //将读出的内容,写入c:/gs2.txt
		// File targetFile = new File("c:/gs2.txt");
		// FileOutputStream output = new FileOutputStream(targetFile);
		// output.write(b);
		// output.close();
		// 3、将d:/gs.txt移动到c:/abc/gs.txt。
		// 先读出d:/gs.txt的内容
		File sourceFile = new File("d:/gs.txt");
		FileInputStream input = new FileInputStream(sourceFile);
		byte[] b = new byte[(int) sourceFile.length()];
		input.read(b);
		input.close();
		// 将读出的内容,写入c:/abc/gs.txt
		File targetDir = new File("c:/abc/");
		targetDir.mkdir();
		File targetFile = new File(targetDir.getAbsolutePath()+File.separator+"gs.txt");
		FileOutputStream output = new FileOutputStream(targetFile);
		output.write(b);
		output.close();
		sourceFile.delete();
	}

}
