import java.net.*;
import java.io.*;

/**
 * 客户端与服务端演示
 * 
 * 1.
 * 客户端：浏览器
 * 服务端：自定义
 * 
 * 2.
 * 客户端：浏览器
 * 服务端：tomcat服务器
 */

 class ServerDemo
 {
     public static void main(String[] args) throws Exception
     {
         ServerSocket ss = new ServerSocket(10001);

         Socket s = ss.accept();
         System.out.println(s.getInetAddress().getHostAddress());

         InputStream in = s.getInputStream();
         byte[] buf = new byte[1024];
         int len = in.read(buf);
         System.out.println(new String(buf, 0, len));


         PrintWriter out = new PrintWriter(s.getOutputStream(), true);
         out.println("<html><head></head><body>hello client</body></html>");

       

         s.close();
         ss.close();
     }
 }