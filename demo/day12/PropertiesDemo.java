import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Properties是hashtable的子类
 * 也就是说它具备map集合的特点，而且它里面存储的键值对都是字符串，不需要泛型
 * 
 * 是集合中和IO技术相结合的集合容器
 * 
 * 该对象的特点：可以用于键值对形式的配置文件
 * 
 * 那么在加载数据时，需要数据有固定的格式：键=值
 */


public class PropertiesDemo
{
    public static void main(String[] args)  throws IOException
    {
        loadDemo();
    }

    public static void loadDemo()  throws IOException
    {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("java.log");
        
        // 将流中的数据加载进集合
        prop.load(fis);
        // sop(prop);
        prop.list(System.out);
        fis.close();
    }

    // 演示，如何将流中的数据存储到集合中
    // 想要将 java.log 中键值数据存储到集合中进行操作
    /**
     * 1.用一个流和java.log文件关联
     * 2.读取一行数据，将改行数据用“="进行切割
     * 3.等号左边作为键，右边作为值，存入到 Properties 集合中
     * 
     */
    public static void method_1() throws IOException
    {
        
        BufferedReader bufr = new BufferedReader(new FileReader("java.log"));

        String line = null;
        Properties prop = new Properties();

        while((line = bufr.readLine()) != null)
        {
            String[] arr = line.split("=");
            prop.setProperty(arr[0], arr[1]);
        }

        bufr.close();

        sop(prop);

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