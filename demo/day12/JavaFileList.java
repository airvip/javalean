import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 将一个指定目录下的java文件的绝对路径存储到一个文本文件中。
 * 建立一个java文件列表文件
 * 
 * 思路：
 * 1.对指定的目录进行递归
 * 2.获取递归过程中所有的java文件的路径
 * 3.将这些路径存储到集合中
 * 4.将集合中的数据写入到一个文件中
 */
public class JavaFileList
{
    public static void main(String[] args) throws IOException
    {
        File dir = new File("E:\\workspace\\javas");
        List<File> list = new ArrayList<File>();

        fileToList(dir, list);
        
        // String filename = new File(dir, "javalog.log");
        wFile(list, "javafile.log");
    }

    public static void fileToList(File dir, List<File> list)
    {
        File[] files = dir.listFiles();
        for(File f : files)
        {
            if(!f.isHidden() && f.isDirectory())
            {
                fileToList(f, list);
            }
            else
            {
                if(f.getName().endsWith("java"))
                {
                    list.add(f);
                }
            }
        }
    }

    public static void wFile(List<File> list, String filename) throws IOException
    {
        BufferedWriter bufw = null;

        try
        {
            bufw = new BufferedWriter(new FileWriter(filename));
            for(File f:list)
            {
                String path = f.getAbsolutePath();
                bufw.write(path);
                bufw.newLine();
            }
        }
        catch(IOException e)
        {
            throw e;
        }
        finally
        {
            try
            {
                if(bufw != null)
                    bufw.close();
            }
            catch(IOException e)
            {
                throw e;
            }
        }
    }

  

    


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}