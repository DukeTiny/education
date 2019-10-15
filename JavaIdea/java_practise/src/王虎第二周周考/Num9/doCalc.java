package 王虎第二周周考.Num9;

public class doCalc {


    public static void main(String[] args) {
        double sum=0;
        for ( int i=1; i<=20; i++) {
            double d = 1.0D;
            for (double j = i; j > 0; j--) {
                d *= j;
            }
            d = 1 / d;
            sum += d;
        }
        System.out.println(sum);
    }
}
