import java.net.*;


import java.io.*;


class MyIE
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("192.168.1.44", 10001);

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        out.println("GET / HTTP/1.1");
        out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        out.println("Accept-Language: zh-CN,zh;q=0.9,en;q=0.8");
        out.println("Host: 192.168.1.44:10001");
        out.println("Connection: keep-alive");
        
        out.println();
        out.println();


        BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line = null;
        while(null != (line=bufr.readLine()))
        {
            System.out.println(line);
        }
        s.close();
    }
}