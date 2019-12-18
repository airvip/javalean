import java.util.Arrays;

/**
 * 编码：字符串变成字节码数据
 * 
 * 解码：字节数组变成字符串。
 * 
 * String-->byte[]; str.getBytes(charsetName);
 * 
 * byte[] --> String; new String(byte[], charsetName)
 */

public class EncodeDemo
{
    public static void main(String[] args) throws Exception
    {
        String s = "你好";

        // byte[] b1 = s.getBytes("GBK");
        byte[] b1 = s.getBytes();

        sop(Arrays.toString(b1));

        // String s1 = new String(b1, "GBK");
        String s1 = new String(b1);

        sop(s1);

    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}