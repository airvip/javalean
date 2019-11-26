import java.util.ArrayList;
import java.util.Arrays;

/**
 * 集合变数组
 * Collection接口中的toArray方法
 * 
 */

 public class CollectionToArray
 {
     public static void main(String[] args) {
         ArrayList<String> al = new ArrayList<String>();
         al.add("abc3");
         al.add("abc1");
         al.add("abc2");

         /**
          * 1. 指定类型的数组到底要定义多长呢？
          当指定类型的数组长度小于了集合的size,那么该方法内部会创建一个新的数组，长度为集合的size.
          当指定类型的数组长度大于了集合的size,就不会创建一个新的数组，而是使用传递进来的数据.
          所以创建一个刚刚好的数组最优。

          2. 为什么要将集合转数组？
          为了限定对元素的操作。不需要进行增删了。
          */
         String[] arr = al.toArray(new String[5]);
         sop(Arrays.toString(arr));
     }


     public static void sop(Object obj)
     {
         System.out.println(obj);
     }
 }