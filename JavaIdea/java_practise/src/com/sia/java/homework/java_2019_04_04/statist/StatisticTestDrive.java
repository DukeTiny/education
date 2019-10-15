package com.sia.java.homework.java_2019_04_04.statist;

import java.io.File;
import java.io.IOException;

public class StatisticTestDrive {


    public static void main(String[] args) throws IOException {
        HomeworkFunction hf = new HomeworkFunction();
        hf.collection( new File("D:/HomeworkCollection/Src"),new File("D:/HomeworkCollection/Collections") );
        hf.moveAndSort( new File("D:/HomeworkCollection/Src"),new File("D:/HomeworkCollection/SortByDate") );
        hf.doOrDont();
    }

}
