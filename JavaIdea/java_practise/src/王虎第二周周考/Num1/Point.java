package 王虎第二周周考.Num1;

public class Point {

    private int x =0;
    private int y =0;

    public Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void movePoint( int dx,int dy ) {
        System.out.println( "移动后点的坐标为：(" + (this.x+dx) + "," + (this.y+dy) + ")");
    }

    public static void main(String[] args) {

        Point p1 = new Point();
        Point p2 = new Point(5,3);

        System.out.print("p1");
        p1.movePoint(9,6);

        System.out.print("p2");
        p2.movePoint(9,6);

    }
}
