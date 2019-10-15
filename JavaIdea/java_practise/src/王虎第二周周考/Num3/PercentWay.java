package 王虎第二周周考.Num3;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class PercentWay {


    public static void main(String[] args) {
        BigDecimal totalSell = new BigDecimal(150000);
        BigDecimal personalSell = new BigDecimal(52000);
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(2);
        BigDecimal tempBD = personalSell.divide(totalSell,4,BigDecimal.ROUND_HALF_UP);
        System.out.println(nf.format(tempBD));
    }


}
