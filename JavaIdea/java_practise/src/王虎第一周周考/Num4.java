package 王虎第一周周考;

public class Num4 {

    public void waterFlower(){
        for ( int i=100; i<=1000; i++ ){
            int a = i%10;
            int b = (i/10)%10;
            int c = (i/100)%10;
            if( i == a*a*a+b*b*b+c*c*c ) {
                System.out.println("水仙花数为" + i);
            }
        }
    }
}
