package com.sia.java.homework.java_before_2019_03_26;


public class JavaDay34HomeWork_Fight {

    public static void main(String[] args) {

        JavaDay34HomeWork_Fight fight = new JavaDay34HomeWork_Fight();
        fight.fight("张飞","属","典韦","魏");

    }

    public void fight(String name1,String wing1,String name2,String wing2) {
        JavaDay34HomeWork_General generalA = new JavaDay34HomeWork_General(name1,wing1);
        JavaDay34HomeWork_General generalB = new JavaDay34HomeWork_General(name2,wing2);
        int powerA = generalA.getGenHP()+generalA.getGenIQ()+generalA.getGenStrength();
        int powerB = generalB.getGenHP()+generalB.getGenIQ()+generalB.getGenStrength();
        if ( powerA== powerB ) System.out.printf("%s方势力武将%s与%s方武将%s战平。\n",wing1,name1,wing2,name2);
        if ( powerA > powerB ) System.out.printf( "%s方势力武将%s战胜%s方武将%s。\n",wing1,name1,wing2,name2);
        if ( powerA < powerB ) System.out.printf( "%s方势力武将%s战胜%s方武将%s。",wing2,name2,wing1,name1);
    }

}
