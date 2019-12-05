import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


/**
 * 1.
 * 源：键盘录入
 * 目的：控制台
 * 
 * 2. 
 * 需求：想把键盘录入的数据存储到一个文件中。
 * 源：键盘
 * 目的：文件
 * 
 *  2. 
 * 需求：想把文件的数据打印在控制台上。
 * 源：文件
 * 目的：控制台
 * 
 * 流操作的基本规律
 * 最痛苦的就是流对象有很多，不知道该用哪一个
 * 
 * 通过两个明确来完成
 * 1. 源和目的
 *     源：输入流：InputStream Reader
 *     目的：输入流：OutputStream Writer
 * 2. 操作数据是否是纯文本
 *     是：字符流
 *     不是：字节流
 * 
 * 3. 当体系明确后，在明确要使用那个具体对象
 *     通过设备来进行区分
 *     源设备：内存，硬盘，键盘
 *     目的设备：内存，硬盘，控制台
 * 
 * 1.将一个文件中的数据存储到另一个文件中，复制文件
 *     源：因为是源，所以实用读取流。InputStream Reader
 *     是不是操作文本文件
 *     是！这时就可以选择 Reader
 *     这样体系就明确了
 *     
 *     接下来明确要使用该提系统的那个对象
 *     明确设备：硬盘。一个文件
 *     Reader提系统可以操作文件的对象是 FileReader
 * 
 *     是否需要提高效率：是！加入Reader体系中缓冲区 BufferedReader
 *     FileReader fr = new FileReader("1.log");
 *     BufferedReader bufr = new BufferedReader(fr);
 * 
 *     目的：OutputStream Writer
 *     是否是纯文本。
 *     是！Writer
 *     设备：硬盘。一个文件
 *     Writer体系中可以操作中文件的对象是 FileWriter
 *     是否需要提高息率？是！加入Writer体系中缓冲区 BufferedWriter
 *     FileWriter fw = new FileWriter("log.txt");
 *     BufferedWriter bufw = new BufferedWriter(fw);
 */

 public class TransStreamDemo2
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
        //  BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));


         /* OutputStream out = System.out;
         OutputStreamWriter osw = new OutputStreamWriter(out);
         BufferedWriter bufw = new BufferedWriter(osw); */

         BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file.txt"),"UTF-8"));
        //  BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out,"UTF-8"));



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