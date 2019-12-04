import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符读取缓冲区
 * 该缓冲区提供了一个一次读一行的方法 readline,方便对文本数据的获取
 * 当返回null时，表示读到文件末尾。
 */


public class BufferReaderDemo
{
    public static void main(String[] args) throws IOException
    {
        // 创建一个读取流和文件相关联
        FileReader fr = new FileReader("buf.txt");

        // 为了提高效率，加入了缓冲技术。
        // 只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可
        BufferedReader bufr = new BufferedReader(fr);

        String line = null;
        while(null != (line = bufr.readLine()))
        {
            sop(line);
        }
        // 记住，只要用到缓冲区就要记得刷新
        bufr.close();
        fr.close();
    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }

}