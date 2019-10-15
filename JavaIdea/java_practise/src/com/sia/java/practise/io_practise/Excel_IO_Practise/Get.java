package com.sia.java.practise.io_practise.Excel_IO_Practise;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


public class Get {

    public static void main(String[] args) throws IOException {
        POIFSFileSystem poi = new POIFSFileSystem(new FileInputStream("d:/test.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(poi);
//        HSSFSheet sheet = wb.getSheet("poem");
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row = sheet.getRow(0);
        HSSFCell cell0 = row.getCell((short) 0);
        HSSFCell cell1 = row.getCell((short) 1);
        HSSFCell cell2 = row.getCell((short) 2);
        HSSFCell cell3 = row.getCell((short) 3);
        Date date = cell0.getDateCellValue();
        Boolean aBoolean = cell1.getBooleanCellValue();
        double d = cell2.getNumericCellValue();
        String str = cell3.getStringCellValue();
        System.out.println(date);
        System.out.println(aBoolean);
        System.out.println(d);
        System.out.println(str);
    }
}
