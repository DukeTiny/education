package com.sia.Test;

public class Fu {
    public int id;
    public String name;

    @Override
    public String toString() {
        return "Fu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class AppTest{
    public static void main(String[] args) {
        Fu f1 = new Fu();

        f1.id = 1;
        f1.name = "foo";
        Fu f2 = f1;
        f2.id = 2;
        f2.name = "bar";

        System.out.println(f1);
        System.out.println(f2);
    }
}