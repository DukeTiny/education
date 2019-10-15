package com.woniu.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo1 {

	public static void main(String[] args) throws IOException {
		// 1����һ�׹�ʫд��"d:/gs.txt"��
		// File file = new File("d:/gs.txt");
		// FileWriter fw = new FileWriter(file);
		// fw.write("����絹�Ͱ����ط���������");
		// fw.close();
		// 2����d:/gs.txt������c:/gs2.txt��
		// //�ȶ���d:/gs.txt������
		// File sourceFile = new File("d:/gs.txt");
		// FileInputStream input = new FileInputStream(sourceFile);
		// byte[] b = new byte[(int) sourceFile.length()];
		// input.read(b);
		// input.close();
		// //������������,д��c:/gs2.txt
		// File targetFile = new File("c:/gs2.txt");
		// FileOutputStream output = new FileOutputStream(targetFile);
		// output.write(b);
		// output.close();
		// 3����d:/gs.txt�ƶ���c:/abc/gs.txt��
		// �ȶ���d:/gs.txt������
		File sourceFile = new File("d:/gs.txt");
		FileInputStream input = new FileInputStream(sourceFile);
		byte[] b = new byte[(int) sourceFile.length()];
		input.read(b);
		input.close();
		// ������������,д��c:/abc/gs.txt
		File targetDir = new File("c:/abc/");
		targetDir.mkdir();
		File targetFile = new File(targetDir.getAbsolutePath()+File.separator+"gs.txt");
		FileOutputStream output = new FileOutputStream(targetFile);
		output.write(b);
		output.close();
		sourceFile.delete();
	}

}
