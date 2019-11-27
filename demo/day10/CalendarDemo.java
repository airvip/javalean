import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date:
 */

 public class CalendarDemo
 {
     public static void main(String[] args) {

        Calendar c = Calendar.getInstance();

        c.set(1992,11,01);
        c.add(Calendar.DATE, +1);
        c.add(Calendar.DATE, -2);

        // sop(c);

        
        pCalendar(c);


        /* Date d = new Date();
        sop(d); // 打印的时间不容易看明白，希望有格式

        // 将模式封装到SimpleDateFormat对象中
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String time = sdf.format(d);
        sop(time); */



     }

     public static void pCalendar(Calendar c)
     {
        String[] month = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
        String[] week = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
        sop(c.get(Calendar.YEAR) + "年");
        sop(month[c.get(Calendar.MONTH)]);
        sop(c.get(Calendar.DATE) + " 日");
        sop(week[c.get(Calendar.DAY_OF_WEEK)]);
     }


     public static void sop(Object obj)
     {
         System.out.println(obj);
     }
 }