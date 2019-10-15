package 王虎第一周周考;

import java.lang.reflect.Field;

public class Num1 {
    private String s;
    private int a;
    public int getNum( int num1, int num2 ) {
        int max = 1;
        while ( num2!=0 ){
            int tempNum = num1%num2;
            num1 = num2;
            num2 = tempNum;
            max = num1;
        }
        return max;
    }

    public static void main(String[] args) {
        Class c = Num1.class;
        Field[] fs = c.getDeclaredFields();

    }
}
