package 王虎第一周周考;

public class Num7 {

    public void tenToTwo( int num){
        String str = "";
        while ( num!=0 ) {
          int tempNum = num%2;
          str = tempNum + str;
          num/=2;
        }
        System.out.println(str);
    }
}
