import java.net.*;


public class IPDemo
{
    public static void main(String[] args) throws Exception
    { 
        // InetAddress i = InetAddress.getLocalHost();
        InetAddress i = InetAddress.getByName("www.baidu.com");
        sop(i.toString());
        sop("IP ：" + i.getHostAddress());
        sop("Name ：" + i.getHostName());

    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}