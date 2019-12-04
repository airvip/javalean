import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo
{
    public static void main(String[] args) throws IOException
    {
        FileReader fr = new FileReader("PersonDemo.java");
        LineNumberReader lnr = new LineNumberReader(fr);

        String line = null;
        while(null != (line=lnr.readLine()))
        {
            System.out.println(lnr.getLineNumber()+":"+line);
        }

        lnr.close();
        fr.close();
    }
}