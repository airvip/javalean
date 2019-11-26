import java.util.*;

/**
 * Arrays:用于操作数组的工具类
 * 里面都是静态方法
 * 
 * asList:将数组转变成list集合。
 */

 public class ArraysDemo
 {
     public static void main(String[] args) {
         
        /* int[] arr = {3,7,1,4,2,5,6,0,9,8};;
        sop(Arrays.toString(arr));  */

        String[] arr = {"ass","ffe","vvv","bbas"};
        // 把数组集合变成List集合有什么好处？
        /**
         * 可以使用集合的思想和方法来操作数组中的元素
         * 
         * 注意：将数组变成集合，不可以使用集合的增删方法，因为数组的长度是固定的
         * 可以使用如：contains,get,indexOf,subList..如果使用了增删，那么会发生UnsupportedOperationException
         */
        List<String> li = Arrays.asList(arr);
        sop("contains:"+li.contains("vvv"));
        sop(li);

        Integer[] nums = {3,7,1,4,2,5,6,0,9,8};
        /**
         * 如果数组中的元素都是对象，那么变成集合时，数组中的元素就直接转换成集合中的元素。
         * 如果数组中的元素都是基本数据类型，那么会将该数组作为集合中的元素存在。
         */
        List<Integer> liNum = Arrays.asList(nums);
        sop(liNum);


     }


     public static void sop(Object obj)
     {
         System.out.println(obj);
     }
 }