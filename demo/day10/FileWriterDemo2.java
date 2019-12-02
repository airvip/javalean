import java.io.FileWriter;
import java.io.IOException;

/**
 *IO异常的处理方式
 * 
 */

 public class FileWriterDemo2
 {
    public static void main(String[] args)
    {
        FileWriter fw = null;
        try
        {
            fw = new FileWriter("d:\\demo.log");

            fw.write("this day is friday");
            
            fw.write("\nffffff");
        }
        catch(IOException e)
        {
            sop("catch:" + e.toString());
        }
        finally
        {
            try
            {
                if(fw != null)
                {
                    fw.close();
                }
            }
            catch(IOException e)
            {
                sop(e.toString());
            }
            
        }
    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }

 }