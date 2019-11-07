/**
 * StringBuffer 是字符串缓冲区。
 * 
 * 是一个容器。
 * 特点：
 * 1、而且长度是可变的
 * 2、可以字节操作多个数据类型
 * 3、最终会通过toString方法转变成字符串
 * 
 * 1. 存储
 *     StringBuffer append():将指定数据作为参数添加到已有数据结尾处。
 *     StringBuffer insert(offset, data):将指定数据作为参数插入到offset位置。
 *     
 * 2. 删除
 *     StringBuffer delete(start, end):删除缓冲区中的数据，留头去尾
 *     StringBuffer deleteCharAt(index):删除缓冲区指定位置的字符
 * 
 * 3. 获取
 *     char charAt(int index)
 *     int indexOf(String str)
 *     int lastIndexOf(String str)
 *     int length()
 *     String substring(int start, int end)
 * 
 * 4. 修改
 *     StringBuffer replace(start, end, str)
 *     void setCharAt(int index, char ch)
 * 
 * 5. 翻转
 *     StringBuffer reverse()
 * 
 * 6. 将缓冲区数据存储到指定数组中
 *     void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)    
 * 
 * 
 * JDK1.5 版本之后出现了StringBuilder
 * StringBuffer是线程同步
 * StringBuilder是线程不同步
 * 
 * 以后开发建议使用 StringBuilder
 * 
 * 升级3因素
 * 1.提高效率
 * 2.简化书写
 * 3.提高安全性
 * 
 */

class StringBufferDemo
{
    public static void main(String[] args) {
        // mDel();
        // mUp();


        StringBuffer sb = new StringBuffer("asdfghjkl");
        char[] chs = new char[6];
        sb.getChars(1, 4, chs, 1);
        for(int x =0; x<chs.length; x++)
        {
            sop("chs["+x+"]="+chs[x]+";");
        }

    }

    public static void mUp()
    {
        StringBuffer sb = new StringBuffer("asdfghjkl");
        sb.replace(1,4, "airvip");
        sop(sb);
    }

    public static void mDel()
    {
        StringBuffer sb = new StringBuffer("asdfghjkl");

        // sb.delete(1, 3);
        // 清空缓冲区
        sb.delete(0, sb.length());
        sop(sb);
    }

    public static void mAdd()
    {
        StringBuffer sb = new StringBuffer();

        StringBuffer sb1 = sb.append(34).append(true).append("abc");

        sop(sb);
        sop(sb1);

    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}