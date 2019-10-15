package com.sia.java.practise.io_practise.Excel_IO_Practise;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GetAll {

    public static void main(String[] args) throws IOException {
        POIFSFileSystem poi = new POIFSFileSystem(new FileInputStream("d:/test.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(poi);
        HSSFSheet sheet = wb.getSheetAt(0);
        for ( int i=sheet.getFirstRowNum(); i<=sheet.getLastRowNum(); i++ ) {
            HSSFRow row = sheet.getRow(i);
            for ( int j=row.getFirstCellNum(); j<=row.getLastCellNum(); j++ ){
                HSSFCell cell = row.getCell( (short)j );
                String cellValue = null;
                if (cell!=null){
                    switch ( cell.getCellType() ) {
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            if ( HSSFDateUtil.isCellDateFormatted(cell) ){
                                SimpleDateFormat sdf = null;
                                if ( cell.getCellStyle().getDataFormat()==14 ){
                                    sdf = new SimpleDateFormat("yyyy/MM/dd");
                                }
                                else if ( cell.getCellStyle().getDataFormat()==21 ){
                                    sdf = new SimpleDateFormat("hh:mm:ss");
                                }
                                else if ( cell.getCellStyle().getDataFormat()==22 ){
                                    sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                                }
                                else {
                                    throw new RuntimeException("日期时间错误");
                                }
                                Date date = cell.getDateCellValue();
                                cellValue = sdf.format(date);
                            }
                            else if ( cell.getCellStyle().getDataFormat() == 0 ){
                                cellValue = String.valueOf(cell.getNumericCellValue());
                            }
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            cellValue = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            cellValue = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA:
                            cellValue = cell.getCellFormula();
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            cellValue = null;
                            break;
                        case HSSFCell.CELL_TYPE_ERROR:
                            cellValue = "非法字符";
                            break;
                        default:
                            cellValue = "未知类型";
                            break;
                    }
                    System.out.print( cellValue + "  \t\t");
                }


            }
            System.out.println();
        }
    }
}
