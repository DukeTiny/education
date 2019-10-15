package com.woniu.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WorkBookCreate {

	public static void main(String[] args) throws IOException {
		//生成Workbook对象
		HSSFWorkbook workbook = new HSSFWorkbook();
		//在工作簿中加工作表
		HSSFSheet sheet1 = workbook.createSheet("四月考勤表");
		HSSFSheet sheet2 = workbook.createSheet("May");
		
		//生出输出流
		FileOutputStream out = new FileOutputStream("d:/a.xls");
		//将workbook创建成文件
		workbook.write(out);
		//关闭流
		out.close();
	}

}
