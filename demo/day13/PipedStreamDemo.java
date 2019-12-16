import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo
{
    public static void main(String[] args) throws IOException
    {
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();
        in.connect(out);
        Read r = new Read(in);
        Write w = new Write(out);
        new Thread(r).start();
        new Thread(w).start();
    }
}

class Read implements Runnable
{
    private PipedInputStream in;
    Read(PipedInputStream i)
    {
        this.in = i;
    }
    public void run()
    {
        try{
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            String s = new String(buf, 0, len);
            System.out.println(s);
            in.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("管道读取流失败");
        }
    }

}

class Write implements Runnable
{
    private PipedOutputStream out;
    Write(PipedOutputStream out)
    {
        this.out = out;
    }
    public void run()
    {
        try
        {
            out.write("piped from".getBytes());
            out.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("管道写入流失败");
        }

    }
}

