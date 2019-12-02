import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * 
 */

public class FileReaderDemo
{

    public static void main(String[] args) throws IOException
    {
        // 创建一个文件读取流对象，和指定名称的文件相关联
        // 要保证改文件是已经存在的，如果不存在，会发生异常 FileNotFoundException
        FileReader fr = new FileReader("demo.log");

        // 调用读取流对象的read方法
        // read()：一次读一个字符，而且会自动往下读
        int ch = 0;
        while(-1 != (ch = fr.read()))
        {
            sop((char)ch);
        }
        

        fr.close();
    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}