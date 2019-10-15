package com.woniu.io;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo2 {
	public static void showFile(File dir,String type) {
		// �жϴ��ݽ����Ĳ����Ƿ���ڼ��Ƿ�Ϊ�ļ���
		if (dir.exists() && dir.isDirectory()) {
			// ��ø�Ŀ¼�µ����ļ����ļ���
			File[] files = dir.listFiles();
			if(files!=null){
				for (File f : files) {
					//�ж��ļ����Ƿ���type��ֵ�Ľ���
					//�ļ����Ƿ������ѯ�ؼ���
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
		// ��ʾָ���ļ��ж��������е����ļ����ļ���
		File f = new File("c:/");
		FileDemo2.showFile(f,"png");
	}
}
