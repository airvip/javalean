import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * 列出指定目录下文件或者文件夹，包含子目录中的内容
 * 也就是列出指定目录下所有内容
 * 
 * 因为目录中还有目录，只要使用同一个列出目录功能的函数完成即可。
 * 在列出过程中出现的还是目录的话，还可以再次调用本功能。
 * 也就是函数自身调用自身。
 * 这种表现形式或者变成手法称为递归。
 * 
 * 递归需要注意：
 *     1.限定条件
 *     2. 要注意递归次数，尽量避免内存溢出
 */
public class FileDemo
{
    public static void main(String[] args) throws IOException
    {
        File dir = new File("E:\\workspace\\javas\\demo");
        showDir(dir,0);
    }

    

    public static void showDir(File dir, int level)
    {
        String s = getLevel(level);
        sop(s + dir.getName());
        level++;

        File[] files = dir.listFiles();
        for(File f : files)
        {
            if(f.isDirectory())
            {
                showDir(f, level);
            }
            else
            {
                sop(s + f.getName());
            }
        }
    }

    public static String getLevel(int level)
    {
        StringBuilder sb = new StringBuilder();
        for(int x =0; x<level; x++)
        {
            // sb.append("|--");
            sb.insert(0, "|--");
        }
        return sb.toString();
    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}