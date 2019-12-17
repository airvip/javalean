import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataInputStream 和 DataOutputStream
 * 
 * 可以用于操作基本数据类型的数据的流对象
 */

public class DataStreamDemo
{
    public static void main(String[] args) throws IOException
    {
        // writeData();
        readData();
    }


    public static void writeData() throws IOException
    {
        
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.data"));
        dos.writeInt(66);
        dos.writeBoolean(true);
        dos.writeDouble(998.89);
        dos.close();
    }

    public static void readData() throws IOException
    {
        
        DataInputStream dis = new DataInputStream(new FileInputStream("data.data"));
        int num = dis.readInt();
        boolean doub = dis.readBoolean();
        double boo = dis.readDouble();
        dis.close();
        System.out.println("int:" + num + " double:"+ doub +" boolean:"+boo);

    }

}