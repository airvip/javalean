import java.util.*;

/**
 * 使用LinkedList模拟一个对战或者队列数据结构。
 * 
 * 堆栈：先进后出
 * 队列：先进先出
 * 
 */


class QueueDemo
{
    private LinkedList link;

    QueueDemo()
    {
        link = new LinkedList();
    }

    public void myAdd(Object obj)
    {
        link.offerFirst(obj);
    }

    public Object myGet()
    {
        return link.pollLast();
    }

    public boolean isNull()
    {
        return link.isEmpty();
    }

}

class LinkedListTest
{
    public static void main(String[] args) {
        
        QueueDemo q = new QueueDemo();

        q.myAdd("php");
        q.myAdd("java");
        q.myAdd("python");
        q.myAdd("js");


        while(!q.isNull()){
            sop(q.myGet());
        }
        

    }

    

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}