package com.sia.java.practise.io_practise.Excel_IO_Practise;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;


public class Create {

    public static void main(String[] args) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        OutputStream out = new FileOutputStream("d:/test.xls");
        HSSFSheet poem = wb.createSheet("poem");
        HSSFRow row = poem.createRow(0);
        HSSFCell cell1 = row.createCell( (short)0 );
        HSSFCell cell2 = row.createCell( (short)1 );
        HSSFCell cell3 = row.createCell( (short)2 );
        HSSFCell cell4 = row.createCell( (short)3 );
        HSSFCellStyle cellStyle = wb.createCellStyle();
        HSSFCellStyle cellStyle1 = wb.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
        cellStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cell1.setCellStyle(cellStyle);
        cell3.setCellStyle(cellStyle1);
        cell4.setCellStyle(cellStyle1);
        cell1.setCellValue(new Date());
        cell2.setCellValue(true);
        cell3.setCellValue(5.0D);
        cell4.setCellValue("Fuck you");
        wb.write(out);
    }
}
