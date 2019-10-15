package com.woniu.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTools {
	public static void main(String[] args) {
//		�û�����һ���ļ���,������ļ������е��ļ����ļ��и��Ƶ��û�ָ��������һ����ַ.
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
		//���ж�file�Ƿ�Ϊ�ļ���
		if(file.isDirectory()){
			//��ø�Ŀ¼�������ļ����ļ���
			File[] files = file.listFiles();
			if(files!=null){
				for(File f:files){
					//�ж����ļ�(IO������)�����ļ���(mkdir())
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
