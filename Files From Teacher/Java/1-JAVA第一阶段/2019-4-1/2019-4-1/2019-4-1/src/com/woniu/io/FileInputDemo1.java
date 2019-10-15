package com.woniu.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo1 {

	public static void main(String[] args) {
		//建立文件源
		File sourceFile = new File("d:"+File.separator+"1.txt");
		FileInputStream input = null;
		try {
			//声明输入流对象和文件源关联
			input = new FileInputStream(sourceFile);
			//读取一个字节
//			int c = input.read();
//			System.out.println(c);
			
			//读取一个字节数组
//			byte[] b = new byte[(int) sourceFile.length()]; //声明数组的长度等于文件的长度
//			input.read(b);			//读取文件的内容到b数组中
//			String str = new String(b);	//将字节数组转成字符串
//			System.out.println(str.trim()+"+++++++++++++++++++");
			
			//根据文件长度，读取文件内容
//			for(int i=0;i<sourceFile.length();i++){
//				int c = input.read();
//				System.out.print((char)c);
//			}
			
			//不知道文件长度，读取文件内容
			int c = 0;
			while((c=input.read())!=-1){
				System.out.print((char)c);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
