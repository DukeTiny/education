package com.woniu.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WorkBookCreate {

	public static void main(String[] args) throws IOException {
		//����Workbook����
		HSSFWorkbook workbook = new HSSFWorkbook();
		//�ڹ������мӹ�����
		HSSFSheet sheet1 = workbook.createSheet("���¿��ڱ�");
		HSSFSheet sheet2 = workbook.createSheet("May");
		
		//���������
		FileOutputStream out = new FileOutputStream("d:/a.xls");
		//��workbook�������ļ�
		workbook.write(out);
		//�ر���
		out.close();
	}

}
