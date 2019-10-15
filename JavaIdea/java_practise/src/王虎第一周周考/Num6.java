package 王虎第一周周考;

import java.util.Date;

public class Num6 {

    public int sixTennToTen( String str ){
        int ten = 0;
        int length = str.length();
        char[] chars = str.toCharArray();
        for ( int i=0; i<length; i++) {
            int temp1 = (((int)chars[i])>=48 && ((int)chars[i])<=57)?((int)chars[i])-48:((int)chars[i])-55;
            int temp2 = (int)(Math.pow(16,length-i-1))*temp1;
            ten +=temp2;
        }
        return ten;
    }
}
