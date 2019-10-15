package com.sia.java.homework.java_2019_04_03;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.util.*;

public class ChangeXLS {

    List<Student> stuList = new Vector<Student>();
    Map<String,Integer> maps = new HashMap<String,Integer>();

    public static void main(String[] args) {
        ChangeXLS changeXLS = new ChangeXLS();
//        changeXLS.addStu();             //添加学生到List
//        changeXLS.writeToXLS();         //写入到xls表格文件
//        changeXLS.changeDegree();       //改第三位同学的分数
        changeXLS.readAll();            //统计班级人数
    }

    void addStu() {
        stuList.add( new Student("","学号","姓名","生日","性别","分数","班级") );
        stuList.add( new Student("01","02100653","王虎","1990/09/19","男","100","建一") );
        stuList.add( new Student("02","02100654","许永胜","1990/09/19","男","60","建三") );
        stuList.add( new Student("03","02100655","特哥","1990/09/19","男","83","建一") );
        stuList.add( new Student("04","02100656","吊机","1990/09/19","男","100","建三") );
        stuList.add( new Student("05","02100657","吊棚","1990/09/19","男","70","建二") );
        stuList.add( new Student("06","02100658","周彪","1990/09/19","男","92","建一") );
        stuList.add( new Student("07","02100659","迪哥","1990/09/19","男","65","建三") );
        stuList.add( new Student("08","02100660","李环宇","1990/09/19","男","80","建三") );
        stuList.add( new Student("09","02100661","彭雪","1990/09/19","女","90","建三") );
        stuList.add( new Student("10","02100662","陈丹","1990/09/19","男","80","建四") );
    }
    void writeToXLS() {
        try {
            OutputStream out = new FileOutputStream("D:/stuInfo.xls");
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet();
            for ( int i=0; i<11; i++ ) {
                HSSFRow row = sheet.createRow(i);
                for ( int j=0; j<7; j++ ) {
                    HSSFCell cell = row.createCell((short)j);
                    switch ( j ) {
                        case 0:cell.setCellValue( stuList.get(i).getNo() );
                            break;
                        case 1:cell.setCellValue( stuList.get(i).getsID() );
                            break;
                        case 2:cell.setCellValue( stuList.get(i).getsName() );
                            break;
                        case 3:cell.setCellValue( stuList.get(i).getsBirth() );
                            break;
                        case 4:cell.setCellValue( stuList.get(i).getsSex() );
                            break;
                        case 5:cell.setCellValue( stuList.get(i).getsDegree()) ;
                            break;
                        case 6:cell.setCellValue( stuList.get(i).getsClass() );
                            break;
                    }
                }
            }
            wb.write(out);
            out.flush();
            out.close();
        }
        catch (IOException f) {
            f.printStackTrace();
        }
    }

    void changeDegree() {
        try {
            POIFSFileSystem poi = new POIFSFileSystem( new FileInputStream("D:/stuInfo.xls"));
            HSSFWorkbook wb = new HSSFWorkbook(poi);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row = sheet.getRow(3);
            HSSFCell cell = row.getCell((short)5);

            if ( cell==null ) { cell = row.createCell((short)5); }

            cell.setCellType( HSSFCell.CELL_TYPE_STRING );
            cell.setCellValue( "85" );

            OutputStream out = new FileOutputStream("D:/stuInfo.xls");
            wb.write(out);
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readAll() {
        try{
            POIFSFileSystem poi = new POIFSFileSystem( new FileInputStream("D:/stuInfo.xls") );
            HSSFWorkbook wb = new HSSFWorkbook(poi);
            HSSFSheet sheet = wb.getSheetAt(0);
            for ( int i=sheet.getFirstRowNum()+1; i<=sheet.getLastRowNum(); i++ ) {
                HSSFRow row = sheet.getRow(i);
                HSSFCell cell = row.getCell( (short)6);
                String str = cell.getStringCellValue();
                maps.merge(str, 1, (a, b) -> a + b);
//                if ( maps.get(str)==null ) {
//                    maps.put(str,1);
//                }
//                else {
//                    maps.put(str,maps.get(str)+1);
//                }
            }
            Set<String> mapSet = maps.keySet();
            for ( String s:mapSet) {
                System.out.println( "班级：" + s + "人数：" + maps.get(s));
            }
        }
        catch ( IOException e ){
            e.printStackTrace();
        }
    }
}
