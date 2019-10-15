package 王虎第二周周考.Num4;

import java.util.Random;

public class sortNumber {

    public static void main(String[] args) {
        int[] intArr = new int[10];
        Random rd= new Random();
        for ( int i=0; i<10; i++ ) intArr[i] = rd.nextInt(100);
        for ( int i: intArr ) System.out.print( i + "\t");
        System.out.println();

        for ( int i=0; i<intArr.length-1; i++ )
            for ( int j=0; j<intArr.length-1-i; j++ )
                if ( intArr[j]>intArr[j+1] ){
                    int temp = intArr[j];
                    intArr[j] = intArr[j+1];
                    intArr[j+1] = temp;
                }
        for ( int i:intArr ) System.out.print( i + "\t");
    }


}
