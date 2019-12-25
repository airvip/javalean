import java.io.*;
import java.net.*;

/**
 * 客户端
 * 1. 服务端
 * 2. 读取客户端已有的图片数据
 * 3. 通过socket输出流将数据发给服务端
 * 4. 读取服务端反馈信息
 * 5. 关闭
 * 
 * 
 * 
 */

 class ImgClient
 {
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("192.168.1.44", 10001);

        FileInputStream fis = new FileInputStream("cimg.png");

        OutputStream out = s.getOutputStream();

        byte[] buf = new byte[1024];

        int len = 0;
        while(-1 != (len = fis.read(buf)))
        {
            out.write(buf, 0, len);
        }

        // 通知服务端数据已发送完毕
        s.shutdownOutput();

        InputStream in = s.getInputStream();
        byte[] bufIn = new byte[1024];
        
        int num = in.read(bufIn);

        System.out.println(new String(bufIn, 0, num));

        fis.close();
        s.close();
    }
 }


 class ImgServer
 {
     public static void main(String[] args) throws Exception
     {
         ServerSocket ss = new ServerSocket(10001);

         while(true)
         {
            Socket s = ss.accept();

            InputStream in = s.getInputStream();
            FileOutputStream fos = new FileOutputStream("simg.png");
            byte[] buf = new byte[1024];
            int len = 0;
            while(-1 != (len=in.read(buf)))
            {
                fos.write(buf, 0, len);
            }
            OutputStream out = s.getOutputStream();
            out.write("ok".getBytes());
            fos.close();
            s.close();
         }
         
        //  ss.close();

     }
 }