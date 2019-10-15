package 王虎第二周周考.Num6;

import java.util.Scanner;

public class CaseChange {

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        System.out.println("请输入一段\"纯\"字符串：");
        String str = input.nextLine();
        String temp = "";
        for ( int i=0; i<str.length(); i++ ) {
            char c = str.charAt(i);
            c = ( (byte)c>=65 && (byte)c<=90 )?(char)((byte)c+32):(char)((byte)c-32);
            temp += String.valueOf(c);
        }
        System.out.println(temp);

    }


}
