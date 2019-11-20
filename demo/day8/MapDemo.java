import java.util.*;
/**
 * map集合：该集合存储键值对，一对一对存储，而且要保证键值唯一性。
 * 1.添加
 *   put(K key, V value)
 *   putAll(? extendsK, ? extends V)
 * 
 * 2.删除
 *   clear();
 *   remove(Object key)
 * 
 * 3.判断
 *   containsValue(Object value);
 *   containsKey(Object key);
 *   isEmpty()
 *   
 * 4.获取
 *   get(Object key)
 *   size();
 *   values()
 * 
 * Map
 *   |-- Hashtable:底层是哈希表数据结构，不可以存入null键null值，该集合是线程同步的。JDK 1.0，效率低
 *   |-- HashMap：底层是哈希表数据结构，可以存入null键null值,该集合是不同步的。JDK 1.2，效率高
 *   |-- TreeMap：底层是二叉树结构，线程不同步，可以用于给map集合中的键进行排序。
 * 
 * 和 Set 很像。其实大家，Set底层使用的Map集合。
 * 
 */

 class MapDemo
 {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<String,String>();
        //添加元素,如果添加时出现相同的键，后添加的值会覆盖原有键的值，并且put方法返回被覆盖的值
        sop("put:" + map.put("03","php03"));
        sop("put:" + map.put("03","php"));
        map.put("02","php02");
        map.put("01","php01");
        map.put("04","php04");
        map.put(null,"php04");
        map.put("05",null);

        sop("containKey:" + map.containsKey("01"));

        sop("remove:" + map.remove("02"));

        sop("get:"+ map.get("03"));
        sop("get:"+ map.get(null));
        sop("get:"+ map.get("05"));
        sop("get:"+ map.get("00"));
        // 可以通过get方法返回值来判断一个键是否存在,通过返回null来判断（不推荐）因为value可以为null

        Collection<String> coll = map.values();
        sop(coll);

        sop(map);



    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
 }