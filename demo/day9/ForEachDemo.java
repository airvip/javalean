import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 高级For循环
 * 格式 for(数据类型 变量名: 被遍历的集合（Collection）或者数组)
 * {}
 * 
 * 对集合进行遍历
 * 只能获取几何元素，但不能对集合进行操作。
 * 
 * 迭代器输了遍历，还可以进行remove集合中元素的动作
 * 如果使用ListIterator,还可以在遍历过程中对集合进行增删改查的动作
 * 
 * 传统for循环和高级for有什么区别呢？
 * 高级for有一个局限性，必须有被遍历的目标。
 * 
 * 建议在遍历数组的时候，还是希望使用传统for，因为传统for可以定义脚标。
 */

 public class ForEachDemo
 {
     public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bb");
        list.add("t");
        list.add("dd");
        
        /* for(Iterator it = list.iterator(); it.hasNext();)
        {
            sop(it.next());
        } */

        for(String s:list)
        {
            sop(s);
        }

        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(1, "php1");
        hm.put(3, "php3");
        hm.put(2, "php2");

        Set<Integer> keySet = hm.keySet();
        for(Integer i:keySet)
        {
            sop(i+"::"+hm.get(i));
        }

        Set<Map.Entry<Integer,String>> EntrySet = hm.entrySet();
        for(Map.Entry<Integer,String> me:EntrySet)
        {
            sop(me.getKey() + "::"+me.getValue());
        }
        

     }

     public static void sop(Object obj)
     {
         System.out.println(obj);
     }
 }