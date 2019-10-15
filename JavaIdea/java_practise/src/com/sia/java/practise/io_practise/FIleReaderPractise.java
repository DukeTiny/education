package com.sia.java.practise.io_practise;

import java.io.File;
import java.io.IOException;

public class FIleReaderPractise {


    public static void main(String[] args) throws IOException {
        File file = new File("c:/abc/gs.txt");
        System.out.println(file.getCanonicalPath());
//        FileReader fr = new FileReader(file);
////        while ( fr.ready() ) {
////            System.out.print( (char)fr.read());
////        }
//        for ( int i=0; i<(int)file.length()/2-27; i++ ) {
//            System.out.print( (char)fr.read() );
//        }
//        char[] chars = new char[(int)file.length()];
//        fr.read(chars);
//        System.out.println(chars);

    }


}
