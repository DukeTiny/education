package com.woniu.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		//创建文件和删除文件
//		File file = new File("d:/1.txt");
//		file.createNewFile();
//		
//		file.delete();
		
		//创建多个文件夹，如果要删除的文件夹有子文件夹，则无法删除。
//		File file2 = new File("d:/abc/");
//		file2.mkdirs(); //有多文件夹都不存在
//		file2.delete();
		
		//单个文件夹的创建和删除
//		File file3 = new File("d:/abc/bbb/ccc/");
//		file3.mkdir();
//		file3.delete();
		
		//获得文件一系列信息
//		File file4 = new File("d:/1.txt");
//		//获取文件对象的名字
//		String fileName = file4.getName();
//		System.out.println(fileName);
//		//获得文件对象的绝对路径
//		String absolutePath = file4.getAbsolutePath();
//		System.out.println(absolutePath);
//		//获得文件的长度
//		long len = file4.length();
//		System.out.println(len);
//		//获得父级目录
//		File file = file4.getParentFile();
//		System.out.println(file);
//		//获得最后修改时间
//		long time = file4.lastModified();
//		Date date = new Date(time);
//		System.out.println(date);
		
		//关于文件夹
		//获得d盘根目录下所有文件和文件夹
		File file5 = new File("d:/");
		//判断file对象是否为文件夹  isDirectory()  isFile();
		if(file5.isDirectory()){
			String[] fileNames = file5.list();
			for(String name:fileNames){
				System.out.println(name);
			}
		}
//		File[] files = file5.listFiles();
//		for(File f:files){
//			System.out.println(f.getAbsolutePath());
//		}
	}

}
