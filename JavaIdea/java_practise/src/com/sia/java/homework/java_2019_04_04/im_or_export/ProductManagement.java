package com.sia.java.homework.java_2019_04_04.im_or_export;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ProductManagement {
        private static String dataPath;

    /* 通过商品本身入库 */
    boolean storeProduct( Product product ){
        return storeInfo( product.getProID(),product.getProName(),product.getProPrice(),product.getProQuantity() );
    }



    /* 通过商品信息入库 */
    boolean storeInfo ( String proID,String proName,double proPrice,double proQuantity ) {
        HSSFWorkbook wb;
        try {
            POIFSFileSystem poi = new POIFSFileSystem( new FileInputStream( new File ( dataPath ) )  );
            wb = new HSSFWorkbook( poi );
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow tHead = sheet.createRow(0);
            HSSFCell tCell = tHead.createCell( (short)0 );
            int proIndex = -1;
            for ( int i=sheet.getFirstRowNum()+1; i<=sheet.getLastRowNum(); i++ ) {
                if ( proID.equals( sheet.getRow(i).getCell( (short)0).getStringCellValue() ) ) {
                    proIndex = i;
                }
            }
            HSSFCellStyle cs = wb.createCellStyle();
            cs.setDataFormat( HSSFDataFormat.getBuiltinFormat( "m/d/yy h:mm"));
            if ( proIndex!=-1 ) {
                sheet.getRow(proIndex).getCell( (short)3).setCellValue
                        ( sheet.getRow(proIndex).getCell( (short)3).getNumericCellValue() + proQuantity );
                HSSFCell cell = sheet.getRow(proIndex).getCell( (short)4);
                cell.setCellStyle( cs );
                cell.setCellValue( new Date() );
                write( wb );
                return true;
            }
            else {
                int rowNum = sheet.getLastRowNum()+1;
                System.out.println(rowNum);
                HSSFRow row = sheet.createRow( rowNum );
                row.createCell( (short) 0 ).setCellValue( proID );
                row.createCell( (short) 1 ).setCellValue( proName );
                row.createCell( (short) 2 ).setCellValue( proPrice );
                row.createCell( (short) 3 ).setCellValue( proQuantity );
                HSSFCell cell = row.createCell( (short)4 );
                cell.setCellStyle( cs );
                cell.setCellValue( new Date() );
                write( wb );
                return true;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    /* 出库 */
    boolean outBound ( String proName,int outQuantity ) {

            if ( outQuantity<0 ) {
                System.out.println("产品数量输入错误。");
                return false;
            }
        HSSFWorkbook wb = getWB();
        HSSFSheet sheet = wb.getSheetAt(0);
            if ( sheet!=null ){
                for ( int i=sheet.getFirstRowNum()+1; i<=sheet.getLastRowNum(); i++ ){

                    if ( proName.equals( sheet.getRow(i).getCell( (short)1).getStringCellValue() ) ){
                        double restQuantity = sheet.getRow(i).getCell( (short)3).getNumericCellValue();
                        if ( restQuantity < outQuantity ) {
                            System.out.println("商品剩余:" + restQuantity + "，余量不足");
                            return false;
                        }
                        else {
                            sheet.getRow(i).getCell( (short)3).setCellValue
                                        ( sheet.getRow(i).getCell( (short)3).getNumericCellValue() - outQuantity );
                            write( wb );
                            return true;
                        }
                    }

                }
                System.out.println("找不到您需要的产品。");
            }
            else System.out.println("表哥不存在");
        return false;
    }

    /* 名字模糊查询 */
    boolean blurQuery( String proName ) {
        HSSFWorkbook wb = getWB();
        HSSFSheet sheet = wb.getSheetAt(0);
        int count = 0;
        if ( sheet!=null ){
            for ( int i=sheet.getFirstRowNum()+1; i<=sheet.getLastRowNum(); i++ ){
                if ( sheet.getRow(i).getCell( (short)1).getStringCellValue().contains(proName)  ){
                    if ( count == 0 ) {
                        System.out.println( "商品ID\t\t商品名称\t\t商品价格\t\t商品余量\t\t最后入库时间");
                        ++count;
                    }
                    showProduct( sheet,i );
                    return true;
                }
            }
            System.out.println("找不到您需要的产品。");
        }

        else System.out.println("表格不存在");
        return false;
    }


    /* 查询全部 */
    void queryAll() {
        HSSFWorkbook wb = getWB();
        HSSFSheet sheet = wb.getSheetAt(0);
        int count =0;
        if ( sheet!=null ){
            for ( int i=sheet.getFirstRowNum()+1; i<=sheet.getLastRowNum(); i++ ){
                if ( count==0 ){
                    System.out.println( "商品ID\t\t商品名称\t\t商品价格\t\t商品余量\t\t最后入库时间");
                    count++;
                }
                showProduct( sheet,i );
            }
        }
        else System.out.println("表格不存在");
    }

    /* 辅助功能，获得表格 */
    private HSSFWorkbook getWB() {
        HSSFSheet sheet = null;
        HSSFWorkbook wb = null;
        try {
            InputStream in = new FileInputStream( dataPath );
            POIFSFileSystem poi = new POIFSFileSystem( in );
            wb = new HSSFWorkbook( poi );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    /* 辅助功能打印所需要打印的产品 */
    private void showProduct( HSSFSheet sheet,int i ) {
        System.out.print( sheet.getRow(i).getCell( (short) 0 ).getStringCellValue() + "\t\t" );
        System.out.print( sheet.getRow(i).getCell( (short) 1 ).getStringCellValue() + "\t\t" );
        System.out.print( formatDate( sheet.getRow(i).getCell( (short) 2 ) ) + "\t\t" );
        System.out.print( formatDate( sheet.getRow(i).getCell( (short) 3 ) ) + "\t\t" );
        System.out.println( formatDate( sheet.getRow(i).getCell( (short) 4 ) ) + "\t\t" );
    }

    /* 判断数字类型为日期还是double类型的数值 */
    private String formatDate( HSSFCell cell ) {
        SimpleDateFormat sdf = null;
        String cellValue = null;
        if ( HSSFDateUtil.isCellDateFormatted(cell) ){
            Date date = cell.getDateCellValue();
            if ( cell.getCellStyle().getDataFormat()==14 ){
                sdf = new SimpleDateFormat( "yyyy/MM/dd" );
            }
            else if ( cell.getCellStyle().getDataFormat()==21 ){
                sdf = new SimpleDateFormat( "hh:mm:ss" );
            }
            else if ( cell.getCellStyle().getDataFormat()==22 ){
                sdf = new SimpleDateFormat( "yyyy/MM/dd hh:mm:ss" );
            }
            else throw new RuntimeException( "位置日期类型" );
            cellValue = sdf.format( date );
        }
        else cellValue = String.valueOf( cell.getNumericCellValue() );
        return cellValue;
    }

    /* 静态域，用了生成表头 */
    static {
        InputStream in = null;
        Properties pro = new Properties();
        try {
            in = new FileInputStream(new File("config.properties"));
            pro.load(in);
            dataPath = pro.getProperty("filename");
            InputStream check = new FileInputStream( dataPath );
            POIFSFileSystem poi = new POIFSFileSystem( check );
            HSSFWorkbook checkWB = new HSSFWorkbook( poi );
            if ( checkWB.getSheetAt(0).getRow(0).getCell((short)1).getStringCellValue()==null ) {
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet();
                HSSFRow tHead = sheet.createRow(0);
                OutputStream out = new FileOutputStream(dataPath);
                tHead.createCell( (short) 0 ).setCellValue("ProductID");
                tHead.createCell( (short) 1 ).setCellValue("ProductName");
                tHead.createCell( (short) 2 ).setCellValue("ProductPrice");
                tHead.createCell( (short) 3 ).setCellValue("ProductQuantity");
                tHead.createCell( (short) 4 ).setCellValue("LastStoreTime");
                wb.write(out);
                out.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    void write( HSSFWorkbook wb) {
        try {
            OutputStream out = new FileOutputStream( new File ( dataPath ) );
            wb.write( out );
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
