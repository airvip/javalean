import java.util.*;

import javax.lang.model.util.ElementScanner6;
/**
 * 集合框架的工具类
 * Collections
 */


class CollectionsDemo2
{
    public static void main(String[] args) {
        shuffleDemo();
    }


    public static void shuffleDemo()
    {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("btb");
        list.add("t");
        list.add("dd");
        sop(list);

        Collections.shuffle(list);
        sop(list);
    }

    public static void orderDemo()
    {
        TreeSet<String> list = new TreeSet<String>(Collections.reverseOrder(new StrLenComparator()));
        // TreeSet<String> list = new TreeSet<String>();
        list.add("aaa");
        list.add("btb");
        list.add("terer");
        list.add("dd");

        for(Iterator it=list.iterator(); it.hasNext();)
        {
            sop(it.next());
        }
        
    }

    public static void replaceAllDemo()
    {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("btb");
        list.add("t");
        list.add("dd");

        sop(list);
        Collections.replaceAll(list, "t", "tt");
        sop(list);
        Collections.reverse(list);
        sop(list);
        Collections.swap(list, 1, 3);
        sop(list);
    }


    /**
     * 练习：fill方法可以将list集合中所有元素替换成指定元素
     * 将list集合中部分元素替换成指定元素
     */
    public static void fillDemo()
    {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bb");
        list.add("t");
        list.add("dd");

        sop(list);

        Collections.fill(list, "bt");
        sop(list);
    }



    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}

class StrLenComparator implements Comparator<String>
{
    public int compare(String s1,String s2)
    {

        int num = Integer.valueOf(s1.length()).compareTo(Integer.valueOf(s2.length()));
        if(num == 0)
            return s1.compareTo(s2);
        return num;
    }
}
