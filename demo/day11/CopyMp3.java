import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;


public class CopyMp3
{
    public static void main(String[] args) throws IOException
    {
        System.out.println( Charset.defaultCharset());  
        System.out.println(System.getProperty("file.encoding"));
        long startTime = System.currentTimeMillis();
        copy1();
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime) +" 毫秒");

    }


    public static void copy1() throws IOException
    {
        BufferedInputStream bfis = new BufferedInputStream(new FileInputStream("f:\\qfl.mp3")); 
        BufferedOutputStream bfos = new BufferedOutputStream(new FileOutputStream("f:\\qflcopy.mp3")); 
        

        int by = 0;
        while(-1 != (by=bfis.read()))
        {
            bfos.write(by);
        }
        bfis.close();
        bfos.close();
    }
} 