import java.util.*;

/**
 * 
 * 
 */

class GenericDemo2
{
    public static void main(String[] args) {
        
        TreeSet<String> al = new TreeSet<String>(new LenComparator());
        al.add("php");
        al.add("python");
        al.add("oc");
        al.add("js");

        // al.add(4); // al.add(new Integer(4));

        for(Iterator<String> it = al.iterator(); it.hasNext();)
        {
            sop(it.next());
        }

    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}


class LenComparator implements Comparator<String>
{
    public int compare(String o1, String o2)
    {
        // int num = new Integer(o2.length()).compareTo(new Integer(o1.length()));
        int num = Integer.valueOf(o2.length()).compareTo(Integer.valueOf(o1.length()));
        if(num == 0)
            return o2.compareTo(o1);
        return num;
    }
}