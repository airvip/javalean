import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo
{
    public static void main(String[] args) throws Exception
    {
        readObj();
    }

    public static void readObj() throws Exception
    {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.obj"));
        Person p = (Person)ois.readObject();
        System.out.println(p);
        ois.close();

    }


    public static void writeObj() throws IOException
    {
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Person.obj"));

        oos.writeObject(new Person("php", 20));

        oos.close();
    }
}