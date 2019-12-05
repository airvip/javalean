import java.io.File;
import java.io.IOException;

/**
 * File类常见方法
 * 1. 创建
 *     boolean createNewFile():在指定位置创建文件，如果该文件已经存在，则不创建，返回false
 *                             和输出流不一样，输出流对象一建立创建文件，而且文件已经存在，会覆盖
 * 
 * 2. 删除
 *     boolean delete();删除失败返回false
 *     void deleteOnExit();在程序退出时删除指定文件
 * 
 * 3. 判断
 *     boolean exist():文件是否存在
 *     isFile():
 *     isDirectory():
 *     isHidden();
 *     isAbsolute();
 * 
 * 4. 获取信息
 */
public class FileDemo
{
    public static void main(String[] args) throws IOException
    {
        method_3();
    }

    public static void method_3() throws IOException
    {
        File f1 = new File("java.log");
        f1.mkdir();
        
        sop("isDirectory:"+f1.isDirectory());
        sop("isFile:"+f1.isFile());
        sop("isAbsolute:"+f1.isAbsolute());

    }

    public static void method_2() throws IOException
    {
        File f1 = new File("java.log");
        
        sop("execute:"+f1.canExecute());
        sop("exists:"+f1.exists());

        // 创建文件夹
        File dir = new File("aa\\bb");
        sop("mkdir:"+dir.mkdir());
    }

    public static void method_1() throws IOException
    {
        File f1 = new File("java.log");
        sop("create:"+f1.createNewFile());

        // sop("delete:"+f1.delete());
    }

    //创建File对象
    public static void consMethod()
    {
        // 将a.txt封装成file对象，可以将已有的和未出现的文件或者文件夹封装成对象
        File f1 = new File("java.log");

        File f2 = new File("f:\\ab", "javaf2.log");

        File d = new File("f:\\ab");
        File f3 = new File(d, "javaf3.log");

        File f4 = new File("f:"+File.separator+"ab"+File.separator+"javaf4.log");

        sop(f1);
        sop(f2);
        sop(f3);
        sop(f4);


    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}