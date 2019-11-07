
/**
 * 基本数据类型对象包装类
 * 
 * byte    Byte
 * short   Short
 * int     Integer
 * long    Long
 * boolean Boolean
 * float   Float
 * double  Double
 * char    Character
 * 
 * 
 * 基本数据类型对象包装类的最常见作用。
 * 就是用于基本数据类型和字符串类型之间做转换。
 * 
 * 基本数据类型转换成字符串
 *   基本数据类型+""
 * 
 *   基本数据类型。toString(基本数据类型值)；
 *   如： Integer.toString(43);//将34整数变成"34"
 *   
 * 字符串转换成基本数据类型
 *   xxx a = Xxx.parseXxx(String)
 *   
 *   如：int a = Integer.parseInt("123")
 *   如：double b = Double.parseDouble("123")
 *   如：boolean b = Boolean.parseBoolean("true")
 *   
 * 十进制转成其他进制
 *  toBinaryString();
 *  toHexString();
 *  toOctalString();
 *  
 * 
 * 其他进制转成十进制
 *  parseInt(string, radix)
 * 
 */


class IntegerDemo
{

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        // 整数类型的最大值
        sop("int max : " + Integer.MAX_VALUE);

        // 将一个字符串转成整数
        int num = Integer.parseInt("123");
        sop("num = "+(num+4));

        long a = Long.parseLong("123");
        sop("a = "+(a+4));

        int x = Integer.parseInt("110", 10);
        sop("x = "+x);

        int b = Integer.parseInt("3c", 16);
        sop("b = "+b);
        
    }
}