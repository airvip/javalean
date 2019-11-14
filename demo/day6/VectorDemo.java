import java.util.*;

/**
 * 
 * 枚举就是Vector特有的取出方式。
 * 发现枚举和迭代器很像。
 * 其实枚举和迭代是一样的。
 * 
 * 因为枚举的名称以及方法的名称都过长
 * 所以被迭代器取代了，枚举郁郁而终了。
 */
class VectorDemo
{
    public static void main(String[] args) {
        
        Vector v = new Vector();

        v.add("php");
        v.add("python");
        v.add("java");
        v.add("js");

        Enumeration en = v.elements();

        while(en.hasMoreElements())
            sop(en.nextElement());

        sop(v);

    }

    

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}