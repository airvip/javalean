import java.util.Properties;
import java.util.Set;

/**
 * Properties是hashtable的子类
 * 也就是说它具备map集合的特点，而且它里面存储的键值对都是字符串，不需要泛型
 * 
 * 是集合中和IO技术相结合的集合容器
 * 
 * 该对象的特点：可以用于键值对形式的配置文件
 */


public class PropertiesDemo
{
    public static void main(String[] args) {
        setAndGet();
    }

    // 设置和获取元素
    public static void setAndGet()
    {
        Properties prop = new Properties();
        prop.setProperty("java", "99");
        prop.setProperty("php", "100");

        sop(prop);

        String phpValue = prop.getProperty("php");
        sop(phpValue);

        prop.setProperty("php", 1000+"");

        Set<String> names = prop.stringPropertyNames();
        for(String s:names)
        {
            sop(s + ":" + prop.getProperty(s));
        }

    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
} 