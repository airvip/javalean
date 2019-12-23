import java.net.*;

/**
 * 需求：通过udp传输方式，将一段文字数据发送出去
 * 思路：
 * 1. 建立 udpsocket 服务
 * 2. 提供数据，并将数据封装到数据包中
 * 3. 通过socket服务的发送功能，将数据包发出去
 * 4. 关闭资源
 * 
 */
class UdpSend
{
    public static void main(String[] args) throws Exception
    {
        // 1. 创建udp服务，通过 DatagramSocket对象
        DatagramSocket ds = new DatagramSocket();

        // 2. 确定数据封装成数据包
        byte[] buf = "udp data".getBytes();
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.32"), 9999);

        // 3. 通过socket将已有的数据包发送出去，通过send方法
        ds.send(dp);

        // 4. 关闭资源
        ds.close();

    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}

/**
 * 需求：
 * 定义一个应用程序，用于接收udp协议传输的数据并进行处理的。
 * 
 * 定义udp的接收端
 * 思路：
 * 1. 定义udpsocket服务，通常会监听一个端口，其实就是给这个接收网络应用程序定义数字标识。
 *     方便明确那些
 * 2. 定义一个数据包，因为要存储接收到的字节数据。
 * 因为数据包对象中有更多功能可以提取字节数据中的不同数据信息
 * 3. 通过socket服务的receive方法将收到的数据存入已定义好的数据包中
 * 4. 通过数据包对象的特有功能。将这些不同的数据取出，打印在控制台上
 * 5. 关闭资源
 * 
 */
class UdpRece
{
    public static void main(String[] args) throws Exception
    {
        // 1. 创建udp服务，通过 DatagramSocket对象
        DatagramSocket ds = new DatagramSocket(9999);

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

        // 5.关闭资源
        ds.close();

    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}


