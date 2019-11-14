import java.util.*;

/**
 * 
 * LinkedList:特有方法：
 * addFirst();
 * addLast();
 * 
 * // 获取但不移除，如果集合中没有元素，会出现NoSuchElementException
 * getFirst();
 * getLast();
 * 
 * // 获取移除原链中的数据，如果集合中没有元素，会出现NoSuchElementException
 * removeFirst();
 * removeLast();
 * 
 * 在JDK1.6出现了替代方法
 * offerFirst();
 * offerLast();
 * 
 * // 获取但不移除，如果集合中没有元素，会返回null
 * peekFirst();
 * peekLast();
 * 
 * // 获取移除原链中的数据，如果集合中没有元素，会返回null
 * pollFirst();
 * pollLast();
 * 
 */
class LinkedListDemo
{
    public static void main(String[] args) {
        
        LinkedList link = new LinkedList();

        link.addFirst("php");
        link.addFirst("python");
        link.addFirst("java");
        link.addFirst("js");

        

        sop(link);

    }

    

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}