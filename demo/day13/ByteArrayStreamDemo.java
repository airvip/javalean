import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

/**
 * 用于操作字节数组的流对象
 * 
 * ByteArrayInputStream:构造的时候，需要接收数据源，而且数据源是一个字节数组。
 * ByteArrayOutputStream:构造的时候，不用定义数据穆迪，因为该对象中已经内部封装了可变长度的字节数组，这就是数据目的地。
 * 
 * 因为这两个流对象都操作的数组，并没有使用系统资源。所以，不用进行close关闭.
 * 
 * 在流操作规律讲解时：
 * 原设备：键盘 System.in，硬盘 FileStream ，内存 ArrayStream
 * 目的设备：控制台 System.out，硬盘 FileStream，内存 ArrayStream
 * 
 * 
 * 用流的读写思想来操作数组。
 * 
 */

public class ByteArrayStreamDemo
{
    public static void main(String[] args) {
        // 数据源
        ByteArrayInputStream bis = new ByteArrayInputStream("ABCDEFG".getBytes());

        // 数据目的
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int by = 0;
        while((by=bis.read()) != -1)
        {
            bos.write(by);
        }

        System.out.println(bos.size());
        System.out.println(bos.toString());

        
        // bos.writeTo(new FileOutputStream("byte.txt"));

    }
}