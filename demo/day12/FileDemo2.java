import java.io.File;
import java.io.IOException;

/**
 * File类常见方法
 * 
 * 
 */
public class FileDemo
{
    public static void main(String[] args) throws IOException
    {
        listDemo();
    }

    public static void listDemo()
    {
        File f = new File("C:\\");

        String[] names = f.list(); // 调用list方法的file对象必须是封装一个目录，该目录还必须存在
        for(String name : names)
        {
            sop(name);
        }
    }

    public static void listRootsDemo()
    {
        File[] files = File.listRoots();

        for(File f : files)
        {
            sop(f);
        }

    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}