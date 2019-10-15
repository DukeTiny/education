public class DeadLock implements Runnable {

    boolean flag;

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        if (flag) {
            synchronized (A.leftRight) {
                System.out.println("leftRight" + this.flag);
                synchronized (A.rightLeft) {
                    System.out.println("rightLeft" + this.flag);
                }
            }
        } else {
            synchronized (A.rightLeft) {
                System.out.println("rightLeft" + this.flag);
                synchronized (A.leftRight) {
                    System.out.println("leftRight" + this.flag);
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock dl1 = new DeadLock(true);
        DeadLock dl2 = new DeadLock(false);
        Thread th1 = new Thread(dl1);
        Thread th2 = new Thread(dl2);
        th1.start();
        th2.start();
    }
}

class A {
    public static Object leftRight = new Object();
    public static Object rightLeft = new Object();
}
