import java.util.*;

/**
 * Collection
 *   |-- list：元素有序，元素可以重复，因为该集合体系有索引。特点：查询速度很快，但是增删稍慢
 *       |-- ArrayList:底层的数据结构使用的是数组结构。特点：增删很快，查询稍慢。线程不同步
 *       |-- LinkedList:底层使用的是链表数据结构。特点：增删速度很快，查询稍慢
 *       |-- Vector:底层是数组数据结构。线程同步。被ArrayList替代了。
 *   |-- set：元素无序，元素不可以重复。
 * 
 * List:
 *     特有方法，凡是可以操作角标的方法都是该体系特有的方法。
 * 
 * 增
 *   add(index, element);
 *   addAll(index, Collection);
 * 
 * 删
 *    remove(index);
 * 
 * 改
 *    set(index, element);
 * 
 * 查
 *    get(index);
 *    subList(from, to);
 *    listIterator();
 * 
 * List集合特有的迭代器。ListIterator是Iterator的子接口
 * 
 * 在迭代时，不可以通过集合对象的方法操作集合中的元素。
 * 因为会发生ConcurrentModificationException异常
 * 
 * 所以，在迭代时，只能使用迭代器的方法进行操作，科室Iterator方法有局限性。
 * 只能对元素进行判断，取出，删除操作。
 * 如果想要其他的操作如添加，修改等，就需要使用其子接口：ListIterator。
 * 
 * 该接口只能通过List集合的listIterator方法获取。
 */
class ListDemo
{
    public static void main(String[] args) {
        
        // 演示列表迭代器
        ArrayList al = new ArrayList();

        al.add("java");
        al.add("js");
        al.add("php");
        al.add("python");
        sop("原集合："+ al);



        ListIterator li = al.listIterator();

        
        sop("hasPrevious():"+li.hasPrevious());
        sop("hasNext():"+li.hasNext());
        while(li.hasNext())
        {
            Object obj = li.next();

            if(obj.equals("js"))
                // li.add("javascript");
                li.set("javascript");
        }

        
        sop("hasPrevious():"+li.hasPrevious());
        sop("hasNext():"+li.hasNext());

        while(li.hasPrevious())
        {
            sop(li.previous());
        }


        sop(al);

        /* Iterator it = al.iterator();
        while(it.hasNext())
        {
            Object obj = it.next();
            if(obj.equals("js"))
                // al.add("javascript"); // 错误的操作
                it.remove();

            sop("obj="+obj);
        }
        sop(al);
 */
          
    }

    public static void method()
    {
        ArrayList al = new ArrayList();

        al.add("java");
        al.add("js");
        al.add("php");
        al.add("python");
        sop("原集合："+ al);

        // 在指定位置添加元素
        al.add(1, "airvip");
        sop("指定位置添加元素后："+al);

        // 删除指定位置元素
        al.remove(2);
        sop("删除指定位置元素后："+al);

        // 修改元素
        al.set(0, "Java");
        sop("修改后："+al);

        // 通过角标获取元素
        sop("get(1):"+al.get(1));

        // 获取所有元素
        for(int x=0; x<al.size(); x++)
        {
            sop("get("+x+"):"+al.get(x));
        }


        Iterator it = al.iterator();
        while(it.hasNext())
        {
            sop("next:"+it.next());
        }

        // 获取对象的位置
        sop("index = "+al.indexOf("php"));

        List sub = al.subList(1,3);
        sop(sub);
    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}