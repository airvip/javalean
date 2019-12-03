import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * 
 */

public class CopyTest
{

    public static void main(String[] args) throws IOException
    {
        my_copy();
    }


    public static void my_copy()
    {
        FileReader fr = null;
        FileWriter fw = null;

        try
        {
            fr = new FileReader("k:\\CopyTest.java");
            fw = new FileWriter("CopyTest_java.txt");

            char[] buf = new char[1024];
            int len =0 ;
            if(-1 != (len=fr.read(buf)))
            {
                fw.write(buf, 0, len);
            }
        }
        catch(IOException e)
        {
            throw new RuntimeException("read or write error");
        }
        finally
        {
            if(null != fr)
            {
                try
                {
                    fr.close();
                }
                catch(IOException e)
                {
                    sop("fr:"+e.toString());
                }
            }
                

            if(null != fw)
            {
                try
                {
                    fw.close();
                }
                catch(IOException e)
                {
                    sop("fw:"+e.toString());
                }
            }
        }
    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}