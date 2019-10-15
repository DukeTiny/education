package com.woniu.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo1 {

	public static void main(String[] args) {
		//�����ļ�Դ
		File sourceFile = new File("d:"+File.separator+"1.txt");
		FileInputStream input = null;
		try {
			//����������������ļ�Դ����
			input = new FileInputStream(sourceFile);
			//��ȡһ���ֽ�
//			int c = input.read();
//			System.out.println(c);
			
			//��ȡһ���ֽ�����
//			byte[] b = new byte[(int) sourceFile.length()]; //��������ĳ��ȵ����ļ��ĳ���
//			input.read(b);			//��ȡ�ļ������ݵ�b������
//			String str = new String(b);	//���ֽ�����ת���ַ���
//			System.out.println(str.trim()+"+++++++++++++++++++");
			
			//�����ļ����ȣ���ȡ�ļ�����
//			for(int i=0;i<sourceFile.length();i++){
//				int c = input.read();
//				System.out.print((char)c);
//			}
			
			//��֪���ļ����ȣ���ȡ�ļ�����
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
