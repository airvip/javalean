import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * 
 */

public class FileReaderDemo2
{

    public static void main(String[] args) throws IOException
    {
        // 创建一个文件读取流对象，和指定名称的文件相关联
        // 要保证改文件是已经存在的，如果不存在，会发生异常 FileNotFoundException
        FileReader fr = new FileReader("demo.log");

        // 定义一个字符数组，用于存储读到字符
        // read(cahr[])：返回的是读到的字符个数
        char[] buf = new char[1024];
        /* int num = fr.read(buf);
        sop("num:"+num+"..."+new String(buf)); */

        int num = 0;
        while(-1 != (num = fr.read(buf)))
        {
            sop(new String(buf, 0, num));
        }
        

        fr.close();
    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}