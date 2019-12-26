import java.net.*;
import java.io.*;

class UrlConnectDemo
{
    public static void main(String[] args) throws Exception
    {
        URL url = new URL("https://www.baidu.com/");

        URLConnection conn =  url.openConnection();

        sop(conn);

        InputStream in = conn.getInputStream();

        byte[] buf = new byte[1024];
        int len = in.read(buf);

        sop(new String(buf, 0, len));





    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}