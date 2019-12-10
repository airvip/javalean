import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * File类常见方法
 * 
 * 
 */
public class FileDemo
{
    public static void main(String[] args) throws IOException
    {
        File dir = new File("E:\\workspace\\javas\\demo\\day11");
        File[] files = dir.listFiles();
        for(File f : files)
        {
            sop(f.getName() + "::" + f.length());
        }
    }

    public static void listDemo2()
    {
        File dir = new File("E:\\workspace\\javas\\demo\\day11");
        String[] names = dir.list(new FilenameFilter(){
        
            @Override
            public boolean accept(File dir, String name) {
                // TODO Auto-generated method stub
                // return !(Pattern.matches("(.*).java$", name));
                return name.endsWith(".java");
                // return false;
            }
        }); 
        for(String name : names)
        {
            sop(name);
        }
    }

    public static void listDemo()
    {
        File f = new File("C:\\");

        String[] names = f.list(); // 调用list方法的file对象必须是封装一个目录，该目录还必须存在
        for(String name : names)
        {
            sop(name);
        }
    }

    public static void listRootsDemo()
    {
        File[] files = File.listRoots();

        for(File f : files)
        {
            sop(f);
        }

    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}