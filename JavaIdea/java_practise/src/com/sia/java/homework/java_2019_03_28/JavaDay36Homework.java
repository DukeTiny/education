package com.sia.java.homework.java_2019_03_28;


import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;


public class JavaDay36Homework {

    public static void main(String[] args) {
        JavaDay36Homework p = new JavaDay36Homework();
//        p.calcMoney();
//        p.concat();
//        System.out.println(p.guessNum());
//        int[][] a = {{2,3,4,6},{1,1,2,2,2,2,2,3,3,3,3}};
//        String[] a = {"a","b"};
//        System.out.println(Arrays.deepToString(a));

    }
    public void calcMoney() {
        Random rd = new Random();
        BigDecimal myMoney = new BigDecimal("10000");
        BigDecimal oh = new BigDecimal("100");
        BigDecimal f = new BigDecimal("0");
        for ( int i=1; i<=5; i++) {
            BigDecimal d = new BigDecimal(rd.nextDouble()*1+1);
            f = d;
            myMoney = myMoney.add( myMoney.multiply(d.divide(oh,2,BigDecimal.ROUND_HALF_EVEN)) );
        }
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(myMoney));
    }
    public void concat() {
        // 二维数组赋值1
        int[][] ss = {{1,2,3},
                      {4,5},
                      { 6,7,8,9}};

        // 二维数组赋值2
//        int[][] ss = new int[3][];
//        int m = 1;
//        for ( int i=0; i<3; i++ ){
//            if ( i==0 ) ss[i] = new int[3];
//            if ( i==1 ) ss[i] = new int[2];
//            if ( i==2 ) ss[i] = new int[4];
//            for ( int j=0; j<ss[i].length; j++)
//                ss[i][j] = m++;
//        }
        Arrays.copyOf(ss,2);
        System.out.println(Arrays.deepToString(ss).replace(" ",""));

        StringBuffer sb1 = new StringBuffer();
        sb1.append("[");
        for ( int[] m : ss ) {
            sb1.append("[");
            for ( int j = 0; j < m.length; j++ ) {
                sb1.append(m[j]);
                if ( j < m.length - 1) sb1.append(",");
            }
            sb1.append("]");
            if ( m [ m.length - 1 ] != ss [ ss.length - 1 ] [ m.length - 1 ] ) sb1.append(",");
        }
        sb1.append("]");
        System.out.println(sb1);


//        int j = 0;
//        for ( int i=0; i<3; i++ ) {
//            int m =0;
//            sb[i] = new StringBuffer[4];
//            for ( ; j<9 ;){
//                j++;
//                sb[i][m] = new StringBuffer();
//                sb[i][m].append(j);
//                m++;
//                if ( j==3 ) break;
//                if ( j==5 ) break;
//            }
//        }
//        for ( StringBuffer[] outer: sb ) {
//            for (StringBuffer inner : outer) System.out.println(inner);
//        }
    }
    public StringBuffer guessNum() {
        Random rd = new Random();
        Scanner input = new Scanner(System.in);
        int num = rd.nextInt(100)+1;
        for ( int i=0; i<10; i++ ) {
            System.out.println("请输入您猜的数字");
            int guessNum = input.nextInt();
            if (num > guessNum) System.out.println("小了");
            if (num < guessNum) System.out.println("大了");
            if (num == guessNum) return new StringBuffer().append("恭喜您猜中了");
        }
        return new StringBuffer().append("你太笨了，游戏结束");

    }
}
