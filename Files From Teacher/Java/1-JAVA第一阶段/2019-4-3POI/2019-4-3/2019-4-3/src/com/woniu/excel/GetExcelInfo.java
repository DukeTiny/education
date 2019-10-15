package com.woniu.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class GetExcelInfo {

	public static void main(String[] args) throws IOException {
		POIFSFileSystem poi = new POIFSFileSystem(new FileInputStream("d:/a.xls"));
		HSSFWorkbook wb = new HSSFWorkbook(poi);
		HSSFSheet sheet = wb.getSheetAt(0);
		for(int i=sheet.getFirstRowNum();i<=sheet.getLastRowNum();i++){
			HSSFRow row = sheet.getRow(i);
			for(int j=row.getFirstCellNum();j<=row.getLastCellNum();j++){
				HSSFCell cell = row.getCell((short) j);
				if(cell!=null){
					String cellValue = "";
					switch(cell.getCellType()){
						case HSSFCell.CELL_TYPE_NUMERIC:
							if(HSSFDateUtil.isCellDateFormatted(cell)){
								SimpleDateFormat sdf = null;
								if(cell.getCellStyle().getDataFormat()==14){
									sdf = new SimpleDateFormat("yyyy/MM/dd");
								}else if(cell.getCellStyle().getDataFormat()==21){
									sdf = new SimpleDateFormat("hh:mm:ss");
								}else if(cell.getCellStyle().getDataFormat()==22){
									sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								}
								Date d = cell.getDateCellValue();
								cellValue = sdf.format(d);
							}else{
								cellValue = String.valueOf(cell.getNumericCellValue());
							}
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							cellValue = String.valueOf(cell.getBooleanCellValue());
							break;
						case HSSFCell.CELL_TYPE_STRING:
							cellValue = cell.getStringCellValue();
							break;
					}
					System.out.print(cellValue+" ");
				}
				
			}
			System.out.println();
		}
	}

}
