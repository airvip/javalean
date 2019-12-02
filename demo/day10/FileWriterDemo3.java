import java.io.FileWriter;
import java.io.IOException;

/**
 * 演示对已有文件的数据续写
 * 
 */

 public class FileWriterDemo
 {
    public static void main(String[] args)
    {
        FileWriter fw = null;
        try
        {
            // 传递一个true参数，代表不覆盖已有的文件内容，只是追加
            fw = new FileWriter("demo.log", true);

            fw.write("this day is friday\n");
            
            fw.write("ffffff\n");
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