package com.sia.java.basic.game_test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.DoubleStream;

public class SDGTestDrive {

    public static void main(String[] args) {
//        SimpleDotGame sdg = new SimpleDotGame();
//        sdg.go();
        Random rd = new Random();
        DoubleStream dd = rd.doubles(5);
        Iterator i = dd.iterator();
        while ( i.hasNext() ) {
            System.out.println( i.next() );
        }
        String[][] s = new String[3][3];
        s[1] = new String[]{"a","b","c"};
        int[][] e = new int[3][3];
        e[1] = new int[]{1,2,3};
    }

}
