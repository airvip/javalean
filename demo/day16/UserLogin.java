import java.net.*;
import java.io.*;

class LoginClient
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("192.168.1.44", 10001);

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        for(int x=0; x<3; x++)
        {
            String line = bufr.readLine();

            if (line == null)
                break;

            out.println(line);


            String info = bufIn.readLine();
            System.out.println("info:"+info);
            if(info.contains("hello"))
                break;
        }

        bufr.close();
        s.close();



    }
}

class UserThread implements Runnable
{
    private Socket s;
    UserThread(Socket s)
    {
        this.s = s;
    }
    public void run()
    {
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "...connected");
        try
        {
            for(int x=0; x<3; x++)
            {
                BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String name = bufIn.readLine();
                System.out.println(name);
                if(name == null)
                    break;

                BufferedReader bufr = new BufferedReader(new FileReader("user.data"));

                PrintWriter out = new PrintWriter(s.getOutputStream(), true);

                String line = null;
                boolean flag = false;
                while(null != (line = bufr.readLine()))
                {
                    if(line.equals(name))
                    {
                        flag = true;
                        break;
                    }
                }

                if(flag)
                {
                    System.out.println(name+" logined");
                    out.println("hello "+name);
                    break;
                }else{
                    System.out.println(name+" try login");
                    out.println(name + " not exist");
                }

            }
            s.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException(ip + "check error");
        }
    }
}

class LoginServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(10001);

        while(true)
        {
            Socket s = ss.accept();

            new Thread(new UserThread(s)).start();
        }
    }
}