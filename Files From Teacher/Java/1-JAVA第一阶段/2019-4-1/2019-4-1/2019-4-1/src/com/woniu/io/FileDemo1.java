package com.woniu.io;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {

	public static void main(String[] args) throws IOException {
//		1、在e盘下，创建一个woniu文件夹，在woniu文件夹下创建1.txt,2.txt...10.txt，
		File file = new File("e:"+File.separator+"woniu");
//		file.mkdir();
//		for(int i=1;i<=10;i++){
//			File temp = new File(file.getAbsolutePath()+File.separator+i+".txt");
//			temp.createNewFile();
//		}
//		再创建abc和bbb两个文件夹。
//		File dir1 = new File(file.getAbsolutePath()+File.separator+"abc");
//		File dir2 = new File(file.getAbsolutePath()+File.separator+"bbb");
//		dir1.mkdir();
//		dir2.mkdir();
//		写一些内容到10.txt中，
//		获取10.txt的名字、绝对路径、父级目录、输出它是文件还是文件夹、获取的它的长度。
		File file2 = new File(file.getAbsolutePath()+File.separator+"10.txt");
		System.out.println(file2.getName());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getParent());
		System.out.println(file2.isFile());
		System.out.println(file2.length());
//		在将2.txt文件删除。
		File file3 = new File(file.getAbsolutePath()+File.separator+"2.txt");
		file3.delete();
//		2、显示woniu文件下的所有文件和文件夹的绝对路径。
		File[] files = file.listFiles();
		for(File f:files){
			System.out.println(f.getAbsolutePath());
		}
	}

}
