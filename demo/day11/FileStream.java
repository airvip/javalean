import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * 字符流
 * FileReader
 * FileWriter
 * 
 * BufferedReader
 * BUfferedWriter
 * 
 * 字节流
 * InputStream    
 * OutputStream
 * 
 * 需求，想要操作图片数据，这时就要用到字节流
 */

 class FileStream
 {

    public static void main(String[] args) throws IOException
    {
        readFile3();
    }

    public static void readFile3() throws IOException
    {
        FileInputStream fis = new FileInputStream("fos.txt");
        
        /* int num = fis.available();
        System.out.println(num); */

        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        System.out.println(new String(buf));
        fis.close();
    }

    public static void readFile2() throws IOException
    {
        FileInputStream fis = new FileInputStream("fos.txt");

        byte[] buf = new byte[1024];
        int len = 0;
        if(-1 != (len = (fis.read(buf))))
        {
            System.out.println(new String(buf, 0, len ));
        }
        fis.close();
    }

    public static void readFile() throws IOException
    {
        FileInputStream fis = new FileInputStream("fos.txt");
        int ch = 0;
        if(-1 != (ch = (fis.read())))
        {
            System.out.println((char)ch);
        }
        fis.close();
    }

    public static void writeFile() throws IOException
    {
        FileOutputStream fos = new FileOutputStream("fos.txt");
        fos.write("abcde".getBytes());
        fos.close();

    }
 }