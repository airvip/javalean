import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class SplitFile
{
    public static void main(String[] args) throws IOException
    {
        // splitFile();
        merge();
    }  

    public static void merge() throws IOException
    {
        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
        for(int x = 1; x < 3; x++)
        {
            al.add(new FileInputStream("./"+x+".bits"));
        }

        final Iterator<FileInputStream> it=al.iterator();
        Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() 
        {
            public boolean hasMoreElements()
            {
                return it.hasNext();
            }
            public FileInputStream nextElement()
            {
                return it.next();
            }
        };
        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream("./123merge.bits");
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = sis.read(buf)) != -1)
        {
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();
    }

    public static void splitFile() throws IOException
    {
        FileInputStream fis = new FileInputStream("123.txt");
        FileOutputStream fos = null;
        byte[] buf = new byte[100];
        int len = 0;
        int count = 1;

        while((len = fis.read(buf)) != -1)
        {
            fos = new FileOutputStream("./"+(count++)+".bits");
            fos.write(buf, 0, len);
            fos.close();
        }

        if(fos != null)
        {
            fos.close();
        }
        fis.close();
    }
}