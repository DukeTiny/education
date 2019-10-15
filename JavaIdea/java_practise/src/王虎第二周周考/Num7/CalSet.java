package 王虎第二周周考.Num7;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalSet {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2019,5,15,12,23,45);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        System.out.printf("%d-%d-%d %d:%d:%d",year,month,date,hour,minute,second);

    }

}
