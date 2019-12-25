import java.io.*;
import java.net.*;

 class ImgClient
 {
    public static void main(String[] args) throws Exception
    {

        if(args.length != 1)
        {
            System.out.println("please a imgae");
            return ;
        }



        File file = new File(args[0]);
        if(!(file.exists() && file.isFile()))
        {
            System.out.println("file is error");
            return ;
        }

        if(file.getName().endsWith(".png") )
        {
            System.out.println("file must endswith png");
            return ;
        }

        if(file.length() > 1024 * 1024 * 5 )
        {
            System.out.println("file larger");
            return ;
        }

        Socket s = new Socket("192.168.1.44", 10001);

        FileInputStream fis = new FileInputStream(file);

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

 class ImgThread implements Runnable
 {
     private Socket s;
     ImgThread(Socket s)
     {
         this.s = s;
     }
     public void run()
     {
        String ip = s.getInetAddress().getHostAddress();
        int count = 1;
         try
         {
            System.out.println(ip + "...connected");
            InputStream in = s.getInputStream();

            File file = new File(ip + "(" + (count++) + ")"+ ".png");

            while(file.exists())
                file = new File(ip + "(" + (count++) + ")"+ ".png");

            FileOutputStream fos = new FileOutputStream(file);
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
         catch(Exception e)
         {
            throw new RuntimeException(ip + "up error");
         }
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
            new Thread(new ImgThread(s)).start();
         }
         
        //  ss.close();

     }
 }