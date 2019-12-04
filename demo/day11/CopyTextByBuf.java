import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 通过缓冲区复制一个java文件
 */

public class CopyTextByBuf
{
    public static void main(String[] args) {

        BufferedReader bufr = null;
        BufferedWriter bufw = null;

        try
        {

            bufr = new BufferedReader(new FileReader("BufferedReaderDemo.java"));
            bufw = new BufferedWriter(new FileWriter("BufferedReaderDemo_java.txt"));
            String line = null;
            while(null != (line = bufr.readLine()))
            {
                bufw.write(line);
                bufw.newLine();
            }

        }
        catch(IOException e)
        {
            throw new RuntimeException("read or write error");
        }
        finally
        {
            try{
                if(null != bufr)
                    bufr.close();
            }catch(IOException e){
                throw new RuntimeException("read close error");
            }
            try{
                if(null != bufw)
                    bufw.close();
            }catch(IOException e){
                throw new RuntimeException("read close error");
            }

        }
    }
} 