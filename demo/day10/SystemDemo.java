import java.util.Properties;

/**
 * System:类中的方法和属性都是静态的
 * out:标准输出，默认是控制台。
 * int:标准输入，默认是键盘。
 * 
 * 描述系统一些信息
 * 
 * 获取系统属性信息：Properties getProperties();
 */

 public class SystemDemo
 {
     public static void main(String[] args) {
        Properties prop = System.getProperties();

        // 因为Properties是Hashtable的子类，也就是Map集合的一个子类对象。
        // 那么可以通过map的方法取出该集合中的元素。
        // 该集合中存储都是字符串，没有泛型定义。

        // 如何在系统中定义一些特有信息呢？

        System.setProperty("myname", "airvip");

        // 获取指定属性信息
        sop(System.getProperty("os.name"));

        // 可不可以在虚拟机启动时，动态的加载一些属性信息呢？
        // java -Dsex=boy SystemDemo.java
        sop(System.getProperty("sex"));

        // 获取所有属性信息
        for(Object obj:prop.keySet())
        {
            String value = (String)prop.get(obj);
            sop(obj +":"+value);
            
        }

     }


     public static void sop(Object obj)
     {
         System.out.println(obj);
     }
 }