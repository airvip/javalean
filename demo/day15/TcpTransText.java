import java.io.*;
import java.net.*;

/**
 * 需求：建立一个文本转换服务器
 * 客户端给服务端发送文本，服务端会将文本转换成大写再返回给客户端
 * 而且客户端可以不断的进行文本转换。当客户端输入over时,转换结束
 * 
 * 分析：
 * 客户端：
 * 既然是操作设备上的数据，那么就可以使用io技术，并按照io的操作规律来思考
 * 源：键盘录入
 * 目的：网络设备，网络输出流
 * 而且操作的是文本数据，可以选择字符流。
 * 
 * 步骤
 * 1. 建立服务
 * 2. 获取键盘录入
 * 3. 将数据发给服务端
 * 4. 后去服务端返回的大写数据
 * 5. 结束，关资源
 * 
 * 都是文本数据，可以使用字符流进行操作，同时提高效率加入缓冲
 * 
 * 出现问题
 * 现象：客户端和服务端都在莫名等待，这是为什么呢？
 * 因为客户端和服务端都有阻塞式的方法，这些方法没有读到结束标记，那么就会一直等，而导致两端都在一直等待
 * 
 * 
 */

 class TcpClient3
 {
     public static void main(String[] args) throws Exception
     {
         Socket s = new Socket("192.168.1.32", 10002);

         // 定义读取键盘数据的流对象
         BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
         // 定义目的，将数据写入到socket输出流，发给服务端
        //  BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
         PrintWriter out = new PrintWriter(s.getOutputStream(), true);
         // 定义一个socket读取流，读取服务反会的信息
         BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
         

         String line = null;
         while(null != (line = bufr.readLine()))
         {
            /* bufwOut.write(line);
            bufwOut.newLine();
            bufwOut.flush(); */
            out.println(line);

            if(line.equals("over"))
                break;

            String str = bufrIn.readLine();
            System.out.println("Server:"+str);
         }


         bufr.close();
         s.close();
     }
 }


 class TcpServer3
 {
     public static void main(String[] args) throws Exception
     {
         ServerSocket ss = new ServerSocket(10002);

         Socket s = ss.accept();
         String ip = s.getInetAddress().getHostAddress();
         System.out.println(ip+"...connected");

         BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //  BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
         PrintWriter out = new PrintWriter(s.getOutputStream(), true);

         String line = null;
         while(null != (line = bufrIn.readLine()))
         {
            /* bufwOut.write(line.toUpperCase());
            bufwOut.newLine();
            bufwOut.flush(); */
            out.println(line.toUpperCase());
         }

        s.close();
        ss.close();
     }
 }