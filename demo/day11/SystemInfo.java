import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemInfo
{
    public static void main(String[] args) throws IOException
    {
        Properties prop = System.getProperties();

        // prop.list(System.out);
        prop.list(new PrintStream("sysinfo.log"));

    }
}