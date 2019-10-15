package 王虎第一周周考;

import java.util.Date;

public class Num5 {

    public void getDay1( int year,int month,int date){
        int day = 0;
        switch ( month ) {
            case 12: day+=30;
            case 11: day+=31;
            case 9:  day+=31;
            case 8:  day+=31;
            case 7:  day+=30;
            case 6:  day+=31;
            case 5:  day+=30;
            case 4:  day+=31;
            case 3:
                if ( (year%4==0 && year%100!=0) || year%400==0) day+=29;
                else day+=28;
            case 2:  day+=31;
            case 1:  day+=date;
            default:
                System.out.println("内容输入错误");
                break;
        }
        System.out.println("您输入的的时间为" + year + "年的第" + day + "天");
    }

    public void getDay2( int year,int month,int date){
        Date time1 = new Date(year-1900,month-1,date);
        Date time2 = new Date(year-1900,0,0);
        long millis = time1.getTime()-time2.getTime();
        long day = millis/1000/3600/24;
        System.out.println("您输入的的时间为" + year + "年的第" + day + "天");
    }
}
