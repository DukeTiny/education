package com.sia.java.atm.atm3;

public class UI {
    public static void mainUi() {
        System.out.println("|--------------------------------------------|");
        System.out.println("|------->>>>> Welcome Tiger Bank <<<<<-------|");
        System.out.println("|--------------------------------------------|");
        System.out.println();
        System.out.println("|--------------------------------------------|");
        System.out.println("|---< 1.Login >--< 2.Register >--< 3.Out >---|");
        System.out.println("|--------------------------------------------|");
    }
    public static void inputUidUi() {
        System.out.println("|----------Please Enter Your UserId----------|");
    }

    public static void successfulUi() {
        System.out.println("|--------------------------------------------|");
        System.out.println("|-< 1.Save >--< 2.Withdraw >--< 3.Transfer >-|");
        System.out.println("|--------------------------------------------|");
        System.out.println("|---< 4.Check >--< 5.Logout >---< 6.Out >----|");
        System.out.println("|--------------------------------------------|");
    }
    public static void backOrOutUi() {
        System.out.println("|--------------------------------------------|");
        System.out.println("|------< 1.Continue >-----< 2.Out >----------|");
        System.out.println("|--------------------------------------------|");
    }
}
