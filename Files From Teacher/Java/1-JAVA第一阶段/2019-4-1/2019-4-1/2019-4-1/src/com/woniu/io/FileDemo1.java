package com.woniu.io;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {

	public static void main(String[] args) throws IOException {
//		1����e���£�����һ��woniu�ļ��У���woniu�ļ����´���1.txt,2.txt...10.txt��
		File file = new File("e:"+File.separator+"woniu");
//		file.mkdir();
//		for(int i=1;i<=10;i++){
//			File temp = new File(file.getAbsolutePath()+File.separator+i+".txt");
//			temp.createNewFile();
//		}
//		�ٴ���abc��bbb�����ļ��С�
//		File dir1 = new File(file.getAbsolutePath()+File.separator+"abc");
//		File dir2 = new File(file.getAbsolutePath()+File.separator+"bbb");
//		dir1.mkdir();
//		dir2.mkdir();
//		дһЩ���ݵ�10.txt�У�
//		��ȡ10.txt�����֡�����·��������Ŀ¼����������ļ������ļ��С���ȡ�����ĳ��ȡ�
		File file2 = new File(file.getAbsolutePath()+File.separator+"10.txt");
		System.out.println(file2.getName());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getParent());
		System.out.println(file2.isFile());
		System.out.println(file2.length());
//		�ڽ�2.txt�ļ�ɾ����
		File file3 = new File(file.getAbsolutePath()+File.separator+"2.txt");
		file3.delete();
//		2����ʾwoniu�ļ��µ������ļ����ļ��еľ���·����
		File[] files = file.listFiles();
		for(File f:files){
			System.out.println(f.getAbsolutePath());
		}
	}

}
