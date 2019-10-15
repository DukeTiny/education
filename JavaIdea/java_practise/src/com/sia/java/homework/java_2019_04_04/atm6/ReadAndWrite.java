package com.sia.java.homework.java_2019_04_04.atm6;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;

public class ReadAndWrite {
    // D:/Sia/JavaIdea/src/com/sia/java/homework/java_2019_04_04/atm6/userInfo.xls
    private final File file = new File("D:/Sia/JavaIdea/src/com/sia/java/homework/java_2019_04_04/atm6/userInfo.xls");
    static final String OPRATOR = ",";
    static int num = 2;


    UserData extract( UserData user ) {
        HSSFWorkbook wb = getWorkBook();
        HSSFSheet sheet = wb.getSheetAt(0 );
        for ( int i=sheet.getFirstRowNum()+1; i<=sheet.getLastRowNum(); i++ ){
            String tempStr = sheet.getRow(i).getCell( (short)2 ).getStringCellValue();
            if  ( tempStr.equals( user.getuName()) ) {
                user.setIndex( (double)i );
                user.setUserId( String.valueOf( sheet.getRow(i).getCell( (short)1 ).getNumericCellValue() ));
                user.setuPwd( sheet.getRow(i).getCell( (short)3 ).getStringCellValue() );
                user.setBalance( sheet.getRow(i).getCell( (short)4 ).getNumericCellValue() );
                break;
            }
        }
        return user;
    }

    void update( UserData users ) {
        HSSFWorkbook wb = getWorkBook();
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row = sheet.getRow( (int) users.getIndex() );
        row.getCell( (short)1).setCellValue( Double.parseDouble( users.getUserId() ) );
        row.getCell( (short)2).setCellValue( users.getuName() );
        row.getCell( (short)3).setCellValue( users.getuPwd() );
        row.getCell( (short)4).setCellValue( users.getBalance() );
        try{
            OutputStream out = new FileOutputStream( file );
            wb.write( out );
            out.close();
        }
        catch ( IOException e ){
            e.printStackTrace();
        }
    }

    void addNewUser ( UserData users ) {
        HSSFWorkbook wb = getWorkBook();
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row = sheet.createRow( sheet.getLastRowNum()+1 );
        row.createCell( (short)0 ).setCellValue( sheet.getLastRowNum() );
        row.createCell( (short)1 ).setCellValue( sheet.getRow( sheet.getLastRowNum()-1 ).getCell((short)1).getNumericCellValue()+1.0 );
        row.createCell( (short)2 ).setCellValue( users.getuName() );
        row.createCell( (short)3 ).setCellValue( users.getuPwd() );
        row.createCell( (short)4 ).setCellValue( 5000.0D );
        write( wb );
    }
    public void delAccount( int index ) {
        HSSFWorkbook wb = getWorkBook();
        HSSFSheet sheet = wb.getSheetAt(0);

        if ( index==sheet.getLastRowNum() ) sheet.removeRow( sheet.getRow(index) );
        if ( index<sheet.getLastRowNum() ){
            sheet.shiftRows( index+1,sheet.getLastRowNum(),-1);
            for ( int i=index; i<=sheet.getLastRowNum(); i++ ) {
                sheet.getRow(i).getCell((short)0).setCellValue(i);
            }
        }
        write( wb );
    }

    private  HSSFWorkbook getWorkBook() {
        HSSFWorkbook wb = null;
        try {
            InputStream in = new FileInputStream( file );
            POIFSFileSystem poi = new POIFSFileSystem( in );
            wb = new HSSFWorkbook( poi );
        }
        catch ( IOException e ){
            e.printStackTrace();
        }
        return wb;
    }

    private void write( HSSFWorkbook wb ) {
        try{
            OutputStream out = new FileOutputStream( file );
            wb.write( out );
            out.close();
            num++;
        }
        catch ( IOException e ){
            e.printStackTrace();
        }
    }

    static  {
        POIFSFileSystem poi;
        HSSFWorkbook wb1 = null;
        try {
             poi = new POIFSFileSystem(new FileInputStream("D:/Sia/JavaIdea/src/com/sia/java/homework/java_2019_04_04/atm6/userInfo.xls"));
             wb1 = new HSSFWorkbook( poi );
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ( wb1.getSheetAt(0).getRow(0)==null ){
            try {
                HSSFWorkbook wb = new HSSFWorkbook();
                OutputStream out = new FileOutputStream( "D:/Sia/JavaIdea/src/com/sia/java/homework/java_2019_04_04/atm6/userInfo.xls" );
                HSSFSheet sheet = wb.createSheet();
                HSSFRow row0 = sheet.createRow( 0 );
                HSSFRow row1 = sheet.createRow( 1 );
                HSSFRow row2 = sheet.createRow( 2 );
                row0.createCell( (short)0 ).setCellValue( "序号" );
                row0.createCell( (short)1 ).setCellValue( "ID" );
                row0.createCell( (short)2 ).setCellValue( "用户名" );
                row0.createCell( (short)3 ).setCellValue( "密码" );
                row0.createCell( (short)4 ).setCellValue( "余额" );

                row1.createCell( (short)0 ).setCellValue( 1 );
                row1.createCell( (short)1 ).setCellValue( 2100653D );
                row1.createCell( (short)2 ).setCellValue( "王虎");
                row1.createCell( (short)3 ).setCellValue( "hahawanghu" );
                row1.createCell( (short)4 ).setCellValue( 5000.0D );

                row2.createCell( (short)0 ).setCellValue( 2 );
                row2.createCell( (short)1 ).setCellValue( 2100654D );
                row2.createCell( (short)2 ).setCellValue( "马丁" );
                row2.createCell( (short)3 ).setCellValue( "hawanghuha" );
                row2.createCell( (short)4 ).setCellValue( 5000.0D );

                wb.write( out );
                out.close();
            }
            catch ( IOException e ){
                e.printStackTrace();
            }
        }
    }

}
