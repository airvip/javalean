import java.util.*;
/**
 * map集合的两种取出方式
 * 1. Set<k> keySet：将map中所有的键存入到Set集合中，
 *   因为Set具备迭代器。所以可以迭代方式取出所有的键，在根据get方法，获取每一个键对应的值。
 * 
 *   Map集合的取出原理：将map集合转换成set集合，在通过迭代器取出。
 * 
 * 2. Set<Map.Entry<k,v>> entrySet：将map集合中的映射关系存入到了set集合中，
 *   而这个关系的数据就是 Map.Entry
 */

 class MapDemo2
 {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<String,String>();

        map.put("03","php03");
        map.put("02","php02");
        map.put("01","php01");
        map.put("04","php04");
        map.put(null,"php04");
        map.put("05",null);

        // 将Map集合中的映射关系取出。存入到Set集合中。
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for(Iterator<Map.Entry<String, String>> it = entrySet.iterator(); it.hasNext();)
        {
            Map.Entry<String, String> me = it.next();
            sop("key:"+me.getKey() + "=value:"+me.getValue());
        }


        /* // 先获取map集合中的所有键的Set集合，keySet();
        Set<String> keySet = map.keySet();

        //有了Set集合，就可以获取其迭代器
        for(Iterator<String> it = keySet.iterator(); it.hasNext();)
        {
            String key = it.next();
            sop("key:"+key+"--value:"+map.get(key));
        } */



    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
 }