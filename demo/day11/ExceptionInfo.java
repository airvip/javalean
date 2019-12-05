import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ExceptionInfo
{
    public static void main(String[] args) throws IOException
    {

        try
        {
            int[] arr = new int[2];
            sop(arr[3]);
        }
        catch(Exception e)
        {
            System.setOut(new PrintStream("file.txt"));
            // e.printStackTrace(new PrintStream("file.txt"));
            e.printStackTrace(System.out);
        }


    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}