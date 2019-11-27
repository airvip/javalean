import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date:
 */

 public class DateDemo
 {
     public static void main(String[] args) {
        Date d = new Date();
        sop(d); // 打印的时间不容易看明白，希望有格式

        // 将模式封装到SimpleDateFormat对象中
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(d);
        sop(time);



     }


     public static void sop(Object obj)
     {
         System.out.println(obj);
     }
 }