package Test;

public class Animal {


    public static void main(String[] args) {
        for ( int i=1,j=1; i<=45;){

            if( j<=(i%10) ){
                System.out.println(j + "*" + i%10 + "=" + i*j);
            }
//            if ( i%10==0 ) {
//                i++;
//
//                continue;
//            }
            j++;
            if (j==(i%10)+1) {
                System.out.println();
                j=1;
            }
            i++;

        }
    }
}
