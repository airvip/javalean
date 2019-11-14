import java.util.*;

/**
 * 去除 ArrayList 集合中重复元素。
 */

class ArrayListTest
{
    public static void main(String[] args) {

        ArrayList al = new ArrayList();

        al.add("js");
        al.add("php");
        al.add("python");
        al.add("java");
        al.add("js");
        al.add("php");

        sop(al);

        al = singleElement(al);

        sop(al);


        
    }


    public static ArrayList singleElement(ArrayList al)
    {
        // 定义一个临时容器
        ArrayList newAl = new ArrayList();

        for(Iterator it = al.iterator(); it.hasNext();)
        {
             Object obj = it.next();

             if(!newAl.contains(obj))
                 newAl.add(obj);
        }
        return newAl;
    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}