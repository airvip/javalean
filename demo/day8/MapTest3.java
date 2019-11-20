import java.util.*;
/**
 * 需求："sdawihjfkahklwafjdshfjaghfagajfnkjhfalas"获取该字符串中的字母出现次数
 * 
 * 希望打印结果：a(1)c(2)...
 * 
 * 通过结果发现，每一个字母都有对应的次数。
 * 说明字母和次数之间都有映射关系。
 * 
 * 注意了，当发现有映射关系时，可以选择map集合
 * 因为map集合中存放的就是映射关系
 * 
 * 什么实用map集合？
 * 当数据之间存在映射关系时，就要先想map集合。
 * 
 * 思路：
 * 1.将字符串转换成字符数组，因为要对每一个字母进行操作。
 * 
 * 2.定义一个map集合，因为打印结果的字母有顺序，所以实用TreeMap集合。
 * 
 * 3.遍历字符数组。
 * 将每一个字母作为key去查map集合。
 * 如果返回null,将该字母和1存入到map集合中
 * 如果返回不是null,说明该字母在map集合中已经存在并有对应次数。
 * 那么就获取该次数并进行自增，然后将该字母和自增后的次数存入map集合中，覆盖原键所对应的的值
 * 
 * 4.将map集合中的数据变成指定的字符串形式返回。
 * 
 */


 class MapTest3
 {
    public static void main(String[] args) {

        String str = charCount("sdawihjfkahklwafjdshfjaghfagajfnkjhfalas");
        sop(str);



    }

    public static String charCount(String str)
    {
        char[] chs = str.toCharArray();

        TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();

        int count = 0;
        for(int x=0; x < chs.length; x++)
        {
            
            Integer value = tm.get(chs[x]);
            /* if (value == null)
            {
                tm.put(chs[x], 1);
            }
            else
            {
                tm.put(chs[x], ++value);
            } */
            count++;
            if (value != null)
                count = value + 1;
            tm.put(chs[x], count);
            count = 0;
        }

        // sop(tm);

        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Character, Integer>> entrySet = tm.entrySet();

        for(Iterator<Map.Entry<Character, Integer>> it=entrySet.iterator(); it.hasNext();)
        {
            Map.Entry<Character, Integer> me = it.next();
            sb.append(me.getKey()+"("+me.getValue()+")");
        }

        return sb.toString();
    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
 }