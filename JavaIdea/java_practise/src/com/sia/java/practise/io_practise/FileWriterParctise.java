package com.sia.java.practise.io_practise;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterParctise {

    public static void main(String[] args) throws IOException {
//        File file = new File("D:/f.txt");
        FileWriter fw = new FileWriter("D:/gs.txt",true);
        fw.write("采桑子  [纳兰性德]\r\n而今才到当时错，心乱凄迷。红泪偷垂，满目春风百是非。\r\n情知此处来无计，强说欢期。一别如斯，落尽梨花月又西。");
        fw.flush();
        fw.close();

    }
}
