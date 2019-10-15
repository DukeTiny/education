package com.sia.java.homework.java_2019_03_27;


import java.util.*;


public class JavaDay35Homework {

    public static void main(String[] args) {
        JavaDay35Homework p = new JavaDay35Homework();
        p.printList();

        ArrayList<Integer> al = new ArrayList<>();
        al.add(312);
        al.add(223);
        al.add(312);
        al.add(31123);
        al.add(123);
        al.add(35);
        System.out.println( "\n#################" + p.listTest(al,0) );
        p.testHashSet();
//        p.testMap();
        System.out.println(p.addNum());
        p.general();
    }

    public void printList() {
        int[] randomNum = new int[10];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for ( int i=0; i<10; i++ ) {
            randomNum[i] = (int)(Math.random()*100)+1;
            if ( randomNum[i]>=10 )
                arrayList.add(randomNum[i]);
        }
        for ( Object o: randomNum ) System.out.print( o + "  ");
    }

    public int listTest( ArrayList<Integer> al, Integer s ){
        for ( int i=0; i<al.size(); i++ )
            if (s.equals(al.get(i)))
                return i;
        return -1;
//        Iterator ial = al.iterator();
//        int count = 0;
//        while ( ial.hasNext() ){
//            if( s.equals(ial.next())){
//                return count;
//            }
//            count++;
//        }
//        return -1;
    }

    public void testHashSet() {
        HashSet hs = new HashSet();
        for ( ;hs.size()<6;) {
            hs.add((int)(Math.random()*33)+1);
        }
        System.out.print("红色球的球号为：");
        for ( Object h : hs ) {
            System.out.print(h + "  ");
        }
        int blue  = (int) (Math.random()*16)+1;
        System.out.println("\n蓝色球为：" + blue);
    }

    public void testMap() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一串字符串");
        String str = input.next();

        HashMap<Character,Integer> hm = new HashMap<>();
        while ( 0<str.length() ) {
            char a = str.charAt(0);
            int len = str.length();
            str = str.replace ( String.valueOf(a),"");
            len = len-str.length();
            hm.put(a,len);
        }
        System.out.println(hm);
    }

    public HashSet addNum() {
        HashSet hs = new HashSet();
        for ( ;hs.size()<10; )
            hs.add((int)(Math.random()*20)+1);
        return hs;
    }

    public void general() {
        ArrayList<String> als = new ArrayList<>();
        String str = "吕布,赵云,典韦,关羽,张飞,马超,许褚,颜良,文丑,张辽,黄忠,夏侯敦,夏侯渊,曹洪,李典";
        String[] strArr = str.split(",");
        HashSet hs1 = new HashSet();
        HashSet hs2 = new HashSet();
        HashSet hs3 = new HashSet();
        int i=15;
        while ( i>0 ) {
            fillIn(hs1,i,strArr);  i--;
            fillIn(hs2,i,strArr);  i--;
            fillIn(hs3,i,strArr);  i--;
        }
        HashMap hm = new HashMap();
        hm.put("魏国",hs3);
        hm.put("蜀国",hs1);
        hm.put("吴国",hs2);
        Set hmset = hm.keySet();
        for ( Object o : hmset ) {
            System.out.println( o.toString() + ":" );
            for ( Object o1 : ( ( HashSet ) hm.get( o.toString() ) ) )
                System.out.print( o1 + "  ");
            System.out.println();
        }
    }
    public int fillIn( HashSet hs ,int i,String[] strArr ){
            int a = (int)(Math.random()*i);
            hs.add( strArr[a] );
            strArr[a] = strArr[i-1];
        return i;
    }

}
