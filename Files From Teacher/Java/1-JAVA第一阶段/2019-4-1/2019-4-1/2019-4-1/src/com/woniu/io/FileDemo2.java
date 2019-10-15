package com.woniu.io;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo2 {
	public static void showFile(File dir,String type) {
		// 判断传递进来的参数是否存在及是否为文件夹
		if (dir.exists() && dir.isDirectory()) {
			// 获得根目录下的子文件和文件夹
			File[] files = dir.listFiles();
			if(files!=null){
				for (File f : files) {
					//判断文件名是否以type的值的结束
					//文件名是否包含查询关键字
					if(f.getName().indexOf(type)!=-1){
						long modifyTime = f.lastModified();
						Date modifyDate = new Date(modifyTime);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						String timeStr = sdf.format(modifyDate);
						String lenStr = f.length()/1024+"kb";
						String typeStr = f.isDirectory()?"<dir>":"file";
						String name = f.getName();
						System.out.println(timeStr+"\t"+lenStr+"\t"+typeStr+"\t"+name);
					}
					if(f.isDirectory()){
						showFile(f,type);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// 显示指定文件夹对象下所有的子文件及文件夹
		File f = new File("c:/");
		FileDemo2.showFile(f,"png");
	}
}
