package com.sia.java.basic.game_test;

import java.util.Scanner;

public class SimpleDotGame {
    void go() {
        int countHit=0;
        int countGuess=0;
        int[] nums = new int[3];
        nums[0] = (int)( Math.random()*5);
        nums[1] = nums[0]+1;
        nums[2] = nums[0]+2;
        while ( countHit<3 ) {
            Scanner input = new Scanner( System.in );
            System.out.print("Enter your guess  ");
            boolean hit = false;
            int guess = input.nextInt();
            for ( int i=0; i<nums.length; i++ ) {
                if ( nums[i]==guess ) {
                    hit = true;
                    countHit++;
                    nums[i] = -1;
                    break;
                }
            }
            if ( hit ) System.out.println("Hit");
            else System.out.println("Miss");
            countGuess++;
        }
        if ( countHit==3 ) {
            System.out.println("Kill");
            System.out.println("You took" + countGuess + "guesses" );
        }
    }
}
