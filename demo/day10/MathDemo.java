import java.util.Random;

public class MathDemo
{
    public static void main(String[] args) {

        Random r = new Random();
        for(int x=0;x<10;x++)
        {
            // sop((int) (Math.random()*10+1));

            sop(r.nextInt(10) + 1);

        }
        

    }

    public static void show()
    {
        double d = Math.ceil(3.14);  // 向上取整
        sop(d);

        double d1 = Math.ceil(-3.14);  // 向上取整
        sop(d1);

        double f = Math.floor(3.14);  // 向下取整
        sop(f);

        double f1 = Math.floor(-3.14);  // 向下取整
        sop(f1);

        long l = Math.round(3.14);  // 四舍五入
        sop(l);

        long l1 = Math.round(3.64);  // 四舍五入
        sop(l1);

        double d2 = Math.pow(2, 3);
        sop(d2);
    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}