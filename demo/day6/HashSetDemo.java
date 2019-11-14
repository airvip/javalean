import java.util.*;

/**
 * Collection
 *   |-- list：元素有序，元素可以重复，因为该集合体系有索引。特点：查询速度很快，但是增删稍慢
 *       |-- ArrayList:底层的数据结构使用的是数组结构。特点：增删很快，查询稍慢。线程不同步
 *       |-- LinkedList:底层使用的是链表数据结构。特点：增删速度很快，查询稍慢
 *       |-- Vector:底层是数组数据结构。线程同步。被ArrayList替代了。
 *   |-- set：元素无序，元素不可以重复。Set集合的功能和Collection是一致的。
 *       |-- HashSet:底层数据结构是哈希表。
 *             HashSet是如何保证元素唯一性的呢？
 *             是通过元素的两个方法，hashCode和equals来完成
 *             如果元素的 hashCode值相同，才会判断equals是否为true.
 *             如果元素的 hashCode值不相同，就不会调用 equals.
 * 
 *             注意：对于判断元素是否存在以及删除等操作，依赖的方法是元素的hashCode和equals方法。
 *       
 * 
 *       |-- TreeSet
 *       
 */
class HashSetDemo
{
    public static void main(String[] args) {
        
        // 演示列表迭代器
        HashSet h = new HashSet();

        h.add("java");
        h.add("js");
        sop(h.add("php"));
        sop(h.add("php"));
        h.add("python");
        h.add("java");
        sop("原集合："+ h);



        for(Iterator it = h.iterator(); it.hasNext();)
        {
             sop(it.next());
        }
          
    }



    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}