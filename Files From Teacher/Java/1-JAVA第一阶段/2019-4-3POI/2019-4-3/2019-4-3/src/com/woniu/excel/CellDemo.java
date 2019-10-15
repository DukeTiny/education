package com.woniu.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CellDemo {

	public static void main(String[] args) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		//声明工作表
		HSSFSheet sheet = wb.createSheet("123");
		//声明行
		HSSFRow row = sheet.createRow(0);
		//声明列
		HSSFCell cell1 = row.createCell((short)0 );
		HSSFCell cell2 = row.createCell((short) 1);
		HSSFCell cell3 = row.createCell((short) 2);
		HSSFCell cell4 = row.createCell((short) 3);
		//放数据
		cell1.setCellValue(true);
		cell2.setCellValue(new Date());
		cell3.setCellValue("abc");
		cell4.setCellValue(2.5);
		
		
		//格式日期
		HSSFCellStyle dateStyle = wb.createCellStyle();
		dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		cell2.setCellStyle(dateStyle);
		
		HSSFCellStyle alignRight = wb.createCellStyle();
		alignRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		cell3.setCellStyle(alignRight);
		
		HSSFCellStyle alignCenter = wb.createCellStyle();
		alignCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		HSSFCellStyle alignLeft = wb.createCellStyle();
		alignLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		
		
		FileOutputStream out = new FileOutputStream("d:/a.xls");
		wb.write(out);
		out.close();
	}

}
