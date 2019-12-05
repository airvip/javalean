import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


/**
 * 字符流
 * FileReader
 * FileWriter
 * BufferedReader
 * BufferedWriter
 * 
 * 字节流
 * FileInputStream
 * FileOutputStream
 * 
 * BufferedInputStream
 * BufferedOutputStream
 * 
 * 
 * 通过刚才的键盘录入一行数据并打印其大写，发现其实就是读取一行数据的原理。
 * 也就是readLine方法
 * 
 * 能不能直接使用readLine方法来完成键盘录入的一行数据的读取呢？
 * readLine 方法是 字符流 BufferedReader 类中的方法
 * 而键盘录入的 read 方法是 字节流 InputStream 的方法
 * 
 * 那么能不能将字节流转换成字符流在使用字符流缓冲区的readline方法呢？
 */

 public class TransStreamDemo
 {
     public static void main(String[] args) throws IOException
     {
         /* // 获取键盘输入对象
         InputStream in = System.in;

         // 将字节流对象转换成字符流对象，要使用转换流：InputStreamReader
         InputStreamReader isr = new InputStreamReader(in);

         // 为了提高效率，将字符串进行缓冲区技术高效操作。使用BufferedReader
         BufferedReader bufr = new BufferedReader(isr); */

         // 键盘录入最常见写法
         BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));


         /* OutputStream out = System.out;
         OutputStreamWriter osw = new OutputStreamWriter(out);
         BufferedWriter bufw = new BufferedWriter(osw); */

         BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));



         String line = null;
         while(null!= (line = bufr.readLine()))
         {
             if("over".equals(line))
                 break;
            //  sop(line.toUpperCase());
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
         }
         bufr.close();
         bufw.close();


     }

     public static void sop(Object obj)
     {
         System.out.println(obj);
     }
 }