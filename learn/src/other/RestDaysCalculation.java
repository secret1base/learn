package other;

import javax.xml.crypto.dsig.SignatureMethod;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 计算从当前时间开始，到截止时间，中间有多少个周六周日
 * @author: wyj
 * @date: 2020/06/19
 */
public class RestDaysCalculation {
    public static void main(String[] args) throws ParseException {
        int s =caculate("2020-06-19","2020-12-30");
        System.out.println(s);
    }


    public static int caculate(String beginDate, String endDate) throws ParseException{
        int i=0;
        SimpleDateFormat yearmonthday=new SimpleDateFormat("yyyy-MM-dd");
        Date begin = yearmonthday.parse(beginDate);
        Date end = yearmonthday.parse(endDate);
        long beginLong = begin.getTime();
        long endLong = end.getTime();
        while(beginLong<=endLong){
            Date date=new Date(beginLong);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            boolean isWeekend = cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
            if(isWeekend){
                i++;
            }
            beginLong+=24*60*60*1000;
        }
        return i;
    }
}
