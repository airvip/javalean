import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * 删除一个带内容的目录
 * 删除原理：
 * 在Windows中，删除目录是从里往外删除的。
 * 
 * 既然是从里往外删除，就需要用到递归
 * 
 */
public class FileDemo
{
    public static void main(String[] args) throws IOException
    {
        File dir = new File("E:\\tmp");
        removeDir(dir);
        
    }

    public static void removeDir(File dir)
    {
        File[] files = dir.listFiles();
        for(File f : files)
        {
            if(!f.isHidden() && f.isDirectory())
            {
                removeDir(f);
            }
            else
            {
                sop(f.toString() + ":file:" + f.delete());
            }
        }
        sop(dir + ":dir:" + dir.delete());
    }

  

    


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}