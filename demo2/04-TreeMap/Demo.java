import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();

        List<String> li = new ArrayList<>();
        li.add("orange");
        li.add("apple");
        li.add("pear");

        int i = 0;
        for (String s:li) {
            map.put(s, i);
            i ++;
        }
        
        /*map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);*/
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        for (Map.Entry<String, Integer> entry:
             map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }



    }
}

