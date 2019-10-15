package 王虎第二周周考.Num5;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rd = new Random();
        int num = rd.nextInt(100) + 1;
        boolean guessRight = false;
        for (int i = 0; i < 10 && !guessRight; i++) {
            System.out.println("请输入您猜测的数字");
            int guess = input.nextInt();
            if ( guess > num && i<9 ) System.out.println("大了");
            if ( guess < num && i<9 ) System.out.println("小了");
            if ( guess == num ) {
                System.out.println("恭喜您猜对了");
                guessRight = true;
            }
        }
        if (!guessRight) System.out.println("你太笨了，游戏结束。");
    }

}
