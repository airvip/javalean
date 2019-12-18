import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EncodeStreamDemo
{
    public static void main(String[] args) throws IOException
    {
        // writeText();
        readText();
    }

    public static void readText() throws IOException
    {
        
        InputStreamReader isr = new InputStreamReader(new FileInputStream("utf.txt"), "UTF-8");
        char[] buf = new char[10];
        int len = isr.read(buf);
        String str = new String(buf, 0, len);
        System.out.println(str);

    }

    public static void writeText() throws IOException
    {
        
        // OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk.txt"), "GBK"); // 4字节
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf.txt"), "UTF-8"); // 6字节
        osw.write("你好");
        osw.close();

    }
}