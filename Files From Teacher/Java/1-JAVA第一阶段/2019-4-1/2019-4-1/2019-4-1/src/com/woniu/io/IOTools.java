package com.woniu.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTools {
	public static void main(String[] args) {
//		用户输入一个文件夹,将这个文件夹所有的文件及文件夹复制到用户指定的另外一个地址.
		String sourceDir = "d:/abc/";
		String targetDir = "e:/";
		try {
			IOTools.copyTo(new File(sourceDir),new File(targetDir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void copyTo(File file, File file2) throws IOException {
		//先判断file是否为文件夹
		if(file.isDirectory()){
			//获得根目录所有子文件及文件夹
			File[] files = file.listFiles();
			if(files!=null){
				for(File f:files){
					//判断是文件(IO流拷贝)还是文件夹(mkdir())
					if(f.isFile()){
						FileInputStream input = new FileInputStream(f);
						byte[] b = new byte[(int) f.length()];
						input.read(b);
						input.close();
						
						File temp = new File(file2.getAbsolutePath()+File.separator+f.getName());
						FileOutputStream output = new FileOutputStream(temp);
						output.write(b);
						output.close();
					}
					if(f.isDirectory()){
						//bbb
						//d:/abc/bbb
						//e:/bbb
						String targetDirPath = file2.getAbsolutePath();
						String dirName = f.getName();
						File temp = new File(targetDirPath+File.separator+dirName);
						temp.mkdir();
					}
				}
			}
		
		}
	}
}
