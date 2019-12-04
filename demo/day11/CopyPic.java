import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 复制一张图片
 * 思路：
 * 1.用字节读取流对象和图片关联
 * 2.用字节写入流对象创建一个图片文件，用于存储获取到的图片数据。
 * 3.通过循环读写，完成数据的存储
 * 4.关闭资源
 */


public class CopyPic
{
    public static void main(String[] args) throws IOException
    {
        FileOutputStream fos = null;
        FileInputStream fis = null;
       
        try
        {
            fis = new FileInputStream("f:\\123.jpg"); //读
            fos = new FileOutputStream("f:\\123copy.jpg"); // 写
            byte[] buf = new byte[1024];
            int len = 0;
            while(-1 != (len=fis.read(buf)))
            {
                fos.write(buf, 0, len);
            }

        }
        catch(IOException e)
        {
            throw new RuntimeException("copy error"+e.getMessage());
        }
        finally
        {
            try{
                if(fis != null)
                    fis.close();
            }catch(IOException e){
                throw new RuntimeException("input read close error");
            }
            try{
                if(fos != null)
                    fos.close();
            }catch(IOException e){
                throw new RuntimeException("out write close error");
            }
        }
        

    }
} 