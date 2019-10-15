package 王虎第一周周考;

public class Num2 {

    public int getEveryNumSum( int num ) {
        int sum = 0;
        while ( num!=0 ){
            int temp = num%10;
            num/=10;
            sum+=temp;
        }
        return sum;
    }
}
