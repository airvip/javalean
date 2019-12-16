import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 * 
 * 该类不是IO体系中的子类
 * 而是直接继承Object
 * 
 * 但是它是IO包中的成员。因为它具备读和写功能
 * 内部封装了一个数组，而且通过指针对数组的元素进行操作
 * 可以通过 getFilePointer 获取指针位置
 * 同时可以通过seek改变指针的位置
 * 
 * 其实完成读写的原理就是内部封装了字节输入流和输出流
 * 
 * 通过构造函数可以看出，该尅只能操作文件
 * 而且操作文件还是有模式的：只读 r, 读写 rw等
 * 
 * 如果模式为只读 r，不会创建文件。会去读取一个已存在文件，如果该文件不存在，则会出现异常。
 * 如果模式为 rw 操作的文件不存在，会自动创建。如果存在不会进行覆盖。
 */

public class RandomAccessFileDemo
{
    public static void main(String[] args) throws IOException
    {
        // writeFile();
        readFile();
    }

    public static void readFile() throws IOException
    {
        RandomAccessFile raf = new RandomAccessFile("ran.txt", "r");

        // 调整对象中的指针
        // raf.seek(4);

        // 跳过指定的字节数
        raf.skipBytes(4);

        byte[] buf = new byte[6]; // 一个中文 3 字节
        
        raf.read(buf);
        String name = new String(buf);
        int age = raf.readInt();

        System.out.println("name:"+name);
        System.out.println("age:"+age);


        raf.close();
    }

    public static void writeFile2() throws IOException
    {
        RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
        raf.write("php1语言".getBytes());
        raf.seek(4);
        raf.writeInt(66);
        raf.close();
    }

    public static void writeFile() throws IOException
    {
        RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
        raf.write("php1语言".getBytes());
        raf.writeInt(66);
        raf.close();
    }
}