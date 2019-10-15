package com.sia.java.practise.test_practise;

public class Practise4 {
    public static void main(String[] args) {

        for ( int j=1; j<=5; j++) {
            int i = (int) (Math.random() * 5) + 1;
            System.out.println(i >= 3 ? "Jackpot" : "Loser");
        }
        String a = "aadafqwffqf";
        byte[] b = a.getBytes();
        String[] c = {"aba","qwe"};
        System.out.println(b);
    }

}