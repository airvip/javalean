import java.util.*;

/**
 * 泛型：JDK1.5版本以后出现新特性，用于解决安全问题，是一个安全机制。
 * 
 * 好处
 * 1.将运行时期出现的问题 ClassCastException,转移到了编译时期。
 *     方便于程序员解决问题，让运行事期问题减少，安全。
 * 
 * 2.避免了强制转换的麻烦。
 * 
 * 泛型格式：通过<>来定义要操作的引用数据类型。
 * 
 * 在使用java提供的对象时，什么时候写泛型呢？
 * 通常在集合框架中很常见。
 * 只要见到<>就要定义泛型。
 * 
 * 其实<>就是用来接收类型的。
 * 当时用集合时，集合中要存储的数据类型作为参数传递到<>中即可。
 * 
 */

class GenericDemo
{
    public static void main(String[] args) {
        
        ArrayList<String> al = new ArrayList<String>();
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