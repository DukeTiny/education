package com.woniu.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileOuputDemo1 {

	public static void main(String[] args) {
		//声明源
		File file = new File("d:"+File.separator+"a.txt");
		//声明流
		FileOutputStream output = null;
		try{
			//使用流
			output = new FileOutputStream(file,true);
			//写入一个字节
//			output.write(97);
			
			//写入一个字节数组
//			String str = "你好";
//			output.write(str.getBytes());
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭流
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
