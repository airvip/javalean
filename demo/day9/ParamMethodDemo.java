/**
 * JDK1.5版本出现的新特性
 * 
 * 方法的可变参数
 * 在使用是注意：可变参数一定要定义在参数列表的最后面
 */

 public class ParamMethodDemo
 {
     public static void main(String[] args) {
         

        // 虽然少定义了多个方法，但是每次都要定义一个数组作为实际参数。
         /* int[] arr = {3,5};
         show(arr);

         int[] arr1 = {2,3,4,5};
         show(arr1); */

         /**
          * 可变参数
          其实就是上一种数组参数的简写形式
          不用每一次都手动的建立数组对象
          只要将要操作的元素作为参数传递即可
          隐式的将这些参数封装成数组
          */
         show(2);
         show(2,3,4,5,6,7,8);


     }

     public static void show(int... arr)
     {
        sop(arr.length);
     }

     /* public static void show(int[] arr)
     {
        
     }
 */
     public static void sop(Object obj)
     {
         System.out.println(obj);
     }
 }