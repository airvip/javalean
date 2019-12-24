import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;



class UdpSend2
{
    public static void main(String[] args) throws Exception
    {
        // 1. 创建udp服务，通过 DatagramSocket对象
        DatagramSocket ds = new DatagramSocket();

        // 2. 确定数据封装成数据包
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while(null != (line = bufr.readLine()))
        {
            if("886".equals(line))
                break;

            byte[] buf = line.getBytes();
            DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.32"), 9999);

            // 3. 通过socket将已有的数据包发送出去，通过send方法
            ds.send(dp);
        }

        // 4. 关闭资源
        ds.close();

    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}


class UdpRece2
{
    public static void main(String[] args) throws Exception
    {
        // 1. 创建udp服务，通过 DatagramSocket对象
        DatagramSocket ds = new DatagramSocket(9999);

        while(true)
        {
            // 2. 定义数据包，用于存储
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);

            // 3. 通过服务的receive方式将收到数据存入数据包中
            ds.receive(dp);

            // 4. 通过数据包的方法获取其中的数据
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(), 0, dp.getLength());
            int port = dp.getPort();

            sop("addr"+ ip + ":"+port + System.lineSeparator() + "data:"+data);
        }

        // 5.关闭资源
        // ds.close();

    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}


