

class Foo {
    public int num=1;
}

class T1 implements Runnable{

    private Foo foo;
    public T1(Foo foo) {
        this.foo = foo;
    }
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            synchronized (foo) {
                while (foo.num!=1){
                    try {
                        foo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                foo.num=2;
                foo.notifyAll();
            }
        }
    }
}

class T2 implements Runnable{

    private Foo foo;
    public T2(Foo foo) {
        this.foo = foo;
    }
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            synchronized (foo) {
                while (foo.num!=2){
                    try {
                        foo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                foo.num=3;
                foo.notifyAll();
            }
        }
    }
}

class T3 implements Runnable{

    private Foo foo;
    public T3(Foo foo) {
        this.foo = foo;
    }
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            synchronized (foo) {
                while (foo.num!=3){
                    try {
                        foo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                System.out.println();
                foo.num=1;
                foo.notifyAll();
            }
        }
    }
}

public class AppTest {
    public static void main(String[] args) {

        Foo foo = new Foo();
        T1 t1 = new T1(foo);
        T2 t2 = new T2(foo);
        T3 t3 = new T3(foo);

        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t2);
        Thread tt3 = new Thread(t3);

        tt1.start();
        tt2.start();
        tt3.start();

    }
}
