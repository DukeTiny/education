package Test;

public class B implements A {
    public String f1() {
        return "I can fly";
    }

    public static void main(String[] args) {
        A a = new B();
    }
}
class Outer {
    int y = 6;
    static class Inner {
        static int y = 3;
        void show() {
            System.out.println(y);
        }
    }
}
class Demo {
    int show(int a, int b) {
        return 0;
    }

}