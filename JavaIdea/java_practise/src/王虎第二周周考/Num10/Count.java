package 王虎第二周周考.Num10;

public class Count {


    public static void main(String[] args) {
        int a = 8;
        int b = 884813000;
        int count = 0;
        while ( a<b ) {
            a*=2;
            count++;
        }
        System.out.println( "需要折叠" + count + "次" );
    }
}
