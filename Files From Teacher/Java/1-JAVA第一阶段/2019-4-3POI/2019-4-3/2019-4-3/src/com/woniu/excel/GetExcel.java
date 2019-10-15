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

public class GetExcel {

	public static void main(String[] args) throws IOException, IOException {
		POIFSFileSystem poi = new POIFSFileSystem(new FileInputStream("d:/a.xls"));
		HSSFWorkbook wb = new HSSFWorkbook(poi);
		HSSFSheet sheet = wb.getSheetAt(0);
		for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
			HSSFRow row = sheet.getRow(i);
			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				HSSFCell cell = row.getCell((short) j);
				if (cell != null) {
					String cellValue = null;
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC: // 数字
						// short s = cell.getCellStyle().getDataFormat();
						if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
							SimpleDateFormat sdf = null;
							// 验证short值
							if (cell.getCellStyle().getDataFormat() == 14) {
								sdf = new SimpleDateFormat("yyyy/MM/dd");
							} else if (cell.getCellStyle().getDataFormat() == 21) {
								sdf = new SimpleDateFormat("HH:mm:ss");
							} else if (cell.getCellStyle().getDataFormat() == 22) {
								sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							} else {
								throw new RuntimeException("日期格式错误!!!");
							}
							Date date = cell.getDateCellValue();
							cellValue = sdf.format(date);
						} else if (cell.getCellStyle().getDataFormat() == 0) {// 处理数值格式
							cellValue = String.valueOf(cell.getNumericCellValue());
						}
						break;
					case HSSFCell.CELL_TYPE_STRING: // 字符串
						cellValue = String.valueOf(cell.getStringCellValue());
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
						cellValue = String.valueOf(cell.getBooleanCellValue());
						break;
					case HSSFCell.CELL_TYPE_FORMULA: // 公式
						cellValue = String.valueOf(cell.getCellFormula());
						break;
					case HSSFCell.CELL_TYPE_BLANK: // 空值
						cellValue = null;
						break;
					case HSSFCell.CELL_TYPE_ERROR: // 故障
						cellValue = "非法字符";
						break;
					default:
						cellValue = "未知类型";
						break;

					}
					System.out.print(cellValue + " ");
				}
			}
			System.out.println();
		}
	}

}
