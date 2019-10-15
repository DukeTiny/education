package 王虎第一周周考;

import java.util.Date;

public class CalcToday {

    public static void main(String[] args) {
        Date time1 = new Date();
        Date time2 = new Date(119,1,19);
        long millis = time1.getTime()-time2.getTime();
        long day = millis/1000/3600/24;
        System.out.println("您输入的的时间为2019年的第" + day + "天");
    }
}
