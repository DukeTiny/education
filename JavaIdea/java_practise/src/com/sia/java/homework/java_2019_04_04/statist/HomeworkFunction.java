package com.sia.java.homework.java_2019_04_04.statist;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeworkFunction {

    private File fileSrc = new File("D:/HomeworkCollection/Src");
    private File fileCollection = new File("D:/HomeworkCollection/Collections");
    private InputStream in;
    private OutputStream out;

    public void collection(File file1,File file2) throws IOException {
        if ( file1.exists() ){
            File[] files = fileSrc.listFiles();
            if ( files!=null ){
                for ( File f:files ) {
                    if ( f.isFile() ) {
                        in = new FileInputStream(fileSrc);
                        byte[] bytes = new byte[(int)f.length()];
                        in.read( bytes );
                        if ( !file2.exists() ) file2.mkdir();
                        out = new FileOutputStream( file2.getAbsolutePath() + File.separator + f.getName() );
                        out.write(bytes);
                        out.flush();
                        in.close();
                        out.close();
                    }
                    if ( f.isDirectory() ) {
                        if ( !file2.exists() ) file2.mkdir();
                        File[] fFiles = f.listFiles();
                        File tempFile = new File( file2.getAbsolutePath() + File.separator + f.getName() );
                        tempFile.mkdir();
                        collection(f,tempFile);
                    }
                }

            }

        }


    }

    public void moveAndSort(File file1,File file2) throws IOException {
        if ( file1.exists() ){
            File[] files = fileSrc.listFiles();
            if ( files!=null ){
                for ( File f:files ) {
                    if ( f.isFile() ) {
                        if ( !file2.exists() ) file2.mkdir();
                        in = new FileInputStream(fileSrc);
                        byte[] bytes = new byte[(int)f.length()];
                        in.read( bytes );
                        String dirName = sort( file2,f );
                        out = new FileOutputStream( dirName + File.separator + f.getName() );
                        out.write( bytes );
                        out.flush();
                        in.close();
                        out.close();
                    }
                    if ( f.isDirectory() ) {
                        if ( !file2.exists() ) file2.mkdir();
                        File[] fFiles = f.listFiles();
                        String dirName = sort( file2,f );
                        File tempFile2 = new File( dirName + File.separator + f.getName() );
                        tempFile2.mkdir();
                        collection(f,tempFile2);
                    }
                }
            }
        }
    }

    public void doOrDont() throws IOException {
        //获取学生提交文件的集合
        File file = new File( " D:/HomeworkCollection/SortByDate" + File.separator + new SimpleDateFormat("yyyy/MM/dd").format( new Date() ));
        File[] filesArray = file.listFiles();
        StringBuilder filesName = null;
        for ( File f: filesArray ) {
            filesName.append(f.getName()).append(",");
        }
        String filename = filesName.toString();

        //获取所有学生的名字集合
        File nameFile = new File ( "D:/HomeworkCollection/StuName.txt" );
        FileReader reader = new FileReader(nameFile);
        BufferedReader br = new BufferedReader( reader );
        String name = br.readLine();
        br.close();
        String[] nameArray = name.split(",");

        //检查是否提交
        HSSFWorkbook wb = new HSSFWorkbook();
        OutputStream out = new FileOutputStream("D:/HomeworkCollection/statistic.xls");
        HSSFSheet sheet = wb.createSheet("统计作业提交情况");
        HSSFSheet shee2 = wb.createSheet(new Date().getMonth()-1  + "月" + new Date().getDate() + "日作业未提交者");
        HSSFRow row = sheet.createRow(0);
        if ( sheet.getRow(0).getCell((short)0)==null ){
            row.createCell((short)0).setCellValue("序号");
            row.createCell((short)0).setCellValue("姓名");
        }
        row.createCell( (short) (row.getLastCellNum()+1) ).setCellValue( ( new Date().getMonth()-1 ) + "月" + new Date().getDate() + "日作业" );

        if ( shee2.getLastRowNum()==0 ){
            shee2.createRow(0).createCell((short)0).setCellValue( new Date().getMonth()-1  + "月" + new Date().getDate() + "日作业");
        }
        else {
            shee2.createRow(shee2.getLastRowNum()+1).createCell((short)0).setCellValue( new Date().getMonth()-1  + "月" + new Date().getDate() + "日作业");
        }
        int nums = 1;
        for ( int i=0; i<nameArray.length; i++ ) {
            HSSFRow row1 = sheet.createRow(i);
            row1.createCell( (short)0 ).setCellValue(i+1);
            row1.createCell( (short)1 ).setCellValue(nameArray[i]);
            String str = filename.contains( nameArray[i] )?"交":"未交";
            row1.createCell( (short) (row.getLastCellNum()+1) ).setCellValue( str );
            if ( str.equals("未交") ) {
                if ( shee2.getLastRowNum()==0 ) {
                    shee2.createRow(0).createCell((short) nums).setCellValue(nameArray[i]);
                    nums++;
                }
                else {
                    shee2.createRow(shee2.getLastRowNum()+1).createCell((short) nums).setCellValue(nameArray[i]);
                    nums++;
                }
            }
        }
    }

    private String sort( File f1,File f2 ){
        String dirName = f1.getAbsolutePath() + File.separator + new SimpleDateFormat("yyyy/MM/dd").format( f2.lastModified() );
        File dirFile = new File ( dirName );
        if ( !dirFile.exists() ) dirFile.mkdir();
        return dirName;
    }
}
