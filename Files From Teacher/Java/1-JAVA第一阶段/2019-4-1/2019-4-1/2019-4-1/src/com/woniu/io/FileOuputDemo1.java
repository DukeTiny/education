package com.woniu.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileOuputDemo1 {

	public static void main(String[] args) {
		//����Դ
		File file = new File("d:"+File.separator+"a.txt");
		//������
		FileOutputStream output = null;
		try{
			//ʹ����
			output = new FileOutputStream(file,true);
			//д��һ���ֽ�
//			output.write(97);
			
			//д��һ���ֽ�����
//			String str = "���";
//			output.write(str.getBytes());
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر���
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
