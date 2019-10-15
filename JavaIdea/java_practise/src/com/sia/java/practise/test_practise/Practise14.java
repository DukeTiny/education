package com.sia.java.practise.test_practise;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;

public class Practise14 {

    public static void main(String[] args) throws IOException {
//        delete(2);
//        remove();
        show();
    }
    static void delete( int index ) throws IOException {
        HSSFWorkbook wb = getBook();
        HSSFSheet sheet = wb.getSheetAt(0);
        sheet.shiftRows( index+1,sheet.getLastRowNum(),-1);
        OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\userInfo.xls");
        wb.write(out);
        out.close();
    }
    static HSSFWorkbook getBook() throws IOException{
        POIFSFileSystem poi = new POIFSFileSystem( new FileInputStream("C:\\Users\\Administrator\\Desktop\\userInfo.xls"));
        HSSFWorkbook wb = new HSSFWorkbook( poi );
        return wb;
    }
    static void remove() throws IOException {
        HSSFWorkbook wb = getBook();
        HSSFSheet sheet = wb.getSheetAt(0);
        sheet.removeRow( sheet.getRow(sheet.getLastRowNum()));
        OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\userInfo.xls");
        wb.write(out);
        out.close();
    }
    static void show() throws IOException {
        HSSFWorkbook wb = getBook();
        HSSFSheet sheet = wb.getSheetAt(0);
        System.out.println(sheet.getLastRowNum());
    }
}