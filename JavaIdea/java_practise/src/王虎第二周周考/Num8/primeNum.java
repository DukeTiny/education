package 王虎第二周周考.Num8;

import java.util.Scanner;

public class primeNum {

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        System.out.println("请输入一个大于\"1\"的正整数");
        int num = input.nextInt();
        boolean isPrime = true;
        for ( int i=2; i<num; i++ ) {
            if ( num%i==0 ) isPrime = false;
        }
        if ( isPrime ) System.out.println("是质数");
        else System.out.println("不是质数");
    }
}
