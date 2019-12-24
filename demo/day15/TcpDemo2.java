import java.io.*;
import java.net.*;
/**
 * 演示tcp的传输客户端和服务端的互访
 * 需求：客户端给服务端发送数据，服务端收到后，给客户端反馈信息
 * 
 */

 /**
  * 1. 建立socket服务，指定要连接主机和端口
    2. 获取socket流中的输出流。将数据写到该流中，通过网络发送给服务端
    3. 获取socket流中的输入流，将服务端反馈的数据获取到并打印
    4. 关闭客户端
  */

 class TcpClient2
 {
     public static void main(String[] args) throws Exception
     {
         // 创建客户端的 socket 服务，指定目的主机和端口
         Socket s = new Socket("192.168.1.32", 10002);

         // 为了发送数据，应该获取socket流中的输出流
         OutputStream out = s.getOutputStream();

         out.write("tcp data".getBytes());

         InputStream in = s.getInputStream();
         byte[] buf = new byte[1024];
         int len = in.read(buf);
         System.out.println(new String(buf, 0, len));

         s.close();
     }
 }


 class TcpServer2
 {
     public static void main(String[] args) throws Exception
     {
         ServerSocket ss = new ServerSocket(10002);

         Socket s = ss.accept();
         String ip = s.getInetAddress().getHostAddress();
         System.out.println(ip+"...connected");

         InputStream in = s.getInputStream();

         byte[] buf = new byte[1024];
         int len = in.read(buf);

         System.out.println(new String(buf, 0, len));

         OutputStream out = s.getOutputStream();
         out.write("server received".getBytes());
         
        s.close();
        ss.close();

        //  System.out.println("Hello World!");
     }
 }