import java.io.BufferedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.io.InputStreamReader;

/**
 * 编写一个聊天程序
 * 有收数据部分和发数据部分
 * 这两部分需要同时执行
 * 那就需要使用多线程技术
 * 一个线程控制收，一个线程控制发
 * 
 * 因为收和发动作是不一致的，所以
 */

class ChatDemo
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket sendSocket = new DatagramSocket();
        DatagramSocket receSocket = new DatagramSocket(10001);

        new Thread(new Send(sendSocket)).start();
        new Thread(new Rece(receSocket)).start();
    }
}

class Send implements Runnable
{

    private DatagramSocket ds;
    public Send(DatagramSocket ds)
    {
        this.ds = ds;
    }

    public void run()
    {
        try
        {
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while(null != (line = bufr.readLine()))
            {
                if("886".equals(line))
                    break;

                byte[] buf = line.getBytes();

                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.255"), 10001);

                ds.send(dp);
            }

        }
        catch(Exception e)
        {
            throw new RuntimeException("send error");

        }

    }
}


class Rece implements Runnable
{

    private DatagramSocket ds;
    public Rece(DatagramSocket ds)
    {
        this.ds = ds;
    }

    public void run()
    {
        try
        {
            while(true)
            {
                byte[] buf = new byte[1024]; 
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                ds.receive(dp);

                String ip = dp.getAddress().getHostAddress();
                String data = new String(dp.getData(), 0, dp.getLength());

                System.out.println("ip:"+ip+System.lineSeparator()+"data:"+data+System.lineSeparator());
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException("receive error");
        }
    }
}

