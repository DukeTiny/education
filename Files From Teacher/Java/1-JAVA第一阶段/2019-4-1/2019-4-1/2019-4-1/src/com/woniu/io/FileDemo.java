package com.woniu.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		//�����ļ���ɾ���ļ�
//		File file = new File("d:/1.txt");
//		file.createNewFile();
//		
//		file.delete();
		
		//��������ļ��У����Ҫɾ�����ļ��������ļ��У����޷�ɾ����
//		File file2 = new File("d:/abc/");
//		file2.mkdirs(); //�ж��ļ��ж�������
//		file2.delete();
		
		//�����ļ��еĴ�����ɾ��
//		File file3 = new File("d:/abc/bbb/ccc/");
//		file3.mkdir();
//		file3.delete();
		
		//����ļ�һϵ����Ϣ
//		File file4 = new File("d:/1.txt");
//		//��ȡ�ļ����������
//		String fileName = file4.getName();
//		System.out.println(fileName);
//		//����ļ�����ľ���·��
//		String absolutePath = file4.getAbsolutePath();
//		System.out.println(absolutePath);
//		//����ļ��ĳ���
//		long len = file4.length();
//		System.out.println(len);
//		//��ø���Ŀ¼
//		File file = file4.getParentFile();
//		System.out.println(file);
//		//�������޸�ʱ��
//		long time = file4.lastModified();
//		Date date = new Date(time);
//		System.out.println(date);
		
		//�����ļ���
		//���d�̸�Ŀ¼�������ļ����ļ���
		File file5 = new File("d:/");
		//�ж�file�����Ƿ�Ϊ�ļ���  isDirectory()  isFile();
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
