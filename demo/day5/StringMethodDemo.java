/**
 * String类适用于描述字符串事物，那么它就提供了多个方法对字符串进行操作。
 * 
 * 常见的操作有哪些？
 * “abcd”
 * 
 * 1.获取
 *   1.1 字符串中包含的字符数，也就是字符串的长度
 *     int length():获取长度
 *   1.2 根据位置获取位置上某个字符。
 *     char charAt(int index):
 *   1.3 根据字符获取该字符在字符串的位置,如果没有找到返回-1
 *     int indexOf(int ch):返回的是ch在字符串中第一次出现的位置
 *     int indexOf(int ch, int fromIndex):从fromIndex指定位置开始，获取ch在字符串中出现的位置
 * 
 *     int indexOf(String str):返回的是str在字符串中第一次出现的位置
 *     int indexOf(String str, int fromIndex):从fromIndex指定位置开始，获取str在字符串中出现的位置
 * 
 * 2.判断
 *   2.1 字符串中是否包含某一个子串
 *     boolean contains(str)
 *   2.2 字符串是否有内容
 *     boolean isEmpty() : 原理就是判断长度是否为0.
 *   2.3 字符串是否是以指定内容开头
 *     boolean startsWith(str);
 *   2.4 字符串是否是以指定内容结尾
 *     boolean endsWith(str);
 */


class StringMethodDemo 
{

    public static void method_id() 
    {
        String str = "ArrayDemo.java";
        // 判断文件名称是否是以Array单词开头
        sop(str.startsWith("Array"));
        // 判断文件名称是否是.java的文件
        sop(str.endsWith(".java"));
        // 判断文件是否包含 Demo
        sop(str.contains("Demo"));
    }


    public static void method_get()
    {
        String str = "abcdefasdf";
        // 长度
        sop(str.length());

        // 根据索引获取字符
        sop(str.charAt(4));

        // 根据字符获取索引
        sop(str.indexOf('b'));
        sop(str.indexOf('b', 4));

        // 反向索引一个字符出现的位置
        sop(str.lastIndexOf('b'));
        sop(str.lastIndexOf('b', 4));
    }

    public static void main(String[] args) {

        // method_get();
        method_is();
        
    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}