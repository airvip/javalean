import java.util.*;
/**
 * 集合框架的工具类
 * Collections
 */


class CollectionsDemo
{
    public static void main(String[] args) {
        binarySearchDemo();
    }

    public static void binarySearchDemo()
    {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bb");
        list.add("t");
        list.add("dd");
        Collections.sort(list);

        sop(list);

        int index = Collections.binarySearch(list, "t");
        sop("index:"+index);
    }


    public static void maxDemo()
    {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bb");
        list.add("t");
        list.add("dd");

        String max = Collections.max(list,new StrLenComparator());
        sop("max="+max);
    }

    public static void sortDemo()
    {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bb");
        list.add("t");
        list.add("dd");
        sop(list);

        Collections.sort(list,new StrLenComparator());

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


/* public static<T extends Comparable<? super T>> void sort(List<T> li)
{

}
 */