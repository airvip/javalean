import java.util.*;

/**
 * 练习：按照字符串长度排序。
 * 字符串本身具备比较性，但是它的比较方式不是我们所需要的
 * 这时就只能使用比较器。
 */

class TreeSetTest
{
    public static void main(String[] args) {
        
        TreeSet t = new TreeSet(new StrLenCompare());

        t.add("php");
        t.add("java");
        t.add("javascript");
        t.add("js");
        t.add("oc");
        t.add("python");
        
        sop("原集合："+ t);



        for(Iterator it = t.iterator(); it.hasNext();)
        {
             sop(it.next());
        }
          
    }



    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}




class StrLenCompare implements Comparator
{
    public int compare(Object o1,Object o2)
    {
        String s1 = (String) o1;
        String s2 = (String) o2;
        
        int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
        if(num == 0){
            return s1.compareTo(s2);
        }
        return num;

    }
}