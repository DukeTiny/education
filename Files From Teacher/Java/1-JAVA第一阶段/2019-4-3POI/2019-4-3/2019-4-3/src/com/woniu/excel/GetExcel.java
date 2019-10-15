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
					case HSSFCell.CELL_TYPE_NUMERIC: // ����
						// short s = cell.getCellStyle().getDataFormat();
						if (HSSFDateUtil.isCellDateFormatted(cell)) {// �������ڸ�ʽ��ʱ���ʽ
							SimpleDateFormat sdf = null;
							// ��֤shortֵ
							if (cell.getCellStyle().getDataFormat() == 14) {
								sdf = new SimpleDateFormat("yyyy/MM/dd");
							} else if (cell.getCellStyle().getDataFormat() == 21) {
								sdf = new SimpleDateFormat("HH:mm:ss");
							} else if (cell.getCellStyle().getDataFormat() == 22) {
								sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							} else {
								throw new RuntimeException("���ڸ�ʽ����!!!");
							}
							Date date = cell.getDateCellValue();
							cellValue = sdf.format(date);
						} else if (cell.getCellStyle().getDataFormat() == 0) {// ������ֵ��ʽ
							cellValue = String.valueOf(cell.getNumericCellValue());
						}
						break;
					case HSSFCell.CELL_TYPE_STRING: // �ַ���
						cellValue = String.valueOf(cell.getStringCellValue());
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
						cellValue = String.valueOf(cell.getBooleanCellValue());
						break;
					case HSSFCell.CELL_TYPE_FORMULA: // ��ʽ
						cellValue = String.valueOf(cell.getCellFormula());
						break;
					case HSSFCell.CELL_TYPE_BLANK: // ��ֵ
						cellValue = null;
						break;
					case HSSFCell.CELL_TYPE_ERROR: // ����
						cellValue = "�Ƿ��ַ�";
						break;
					default:
						cellValue = "δ֪����";
						break;

					}
					System.out.print(cellValue + " ");
				}
			}
			System.out.println();
		}
	}

}
