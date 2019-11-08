import java.util.*;

/**
 * 
 * 1. add方法的参数类型是Object,以便于接收任意类型对象
 * 
 * 
 * 2. 集合中存储的都是对象的引用（地址）
 * 
 */
class CollectionDemo
{
    public static void main(String[] args) {
        method_2();

    }

    public static void method_2()
    {
        ArrayList al = new ArrayList();
        al.add("java01");
        al.add("java02");
        al.add("java03");

        ArrayList bl = new ArrayList();
        bl.add("java01");
        bl.add("java03");
        bl.add("java05");

        // al.retainAll(bl);// 取交集，al之后保留bl中相同的元素
        al.removeAll(bl);

        sop("al:"+al); 
        sop("bl:"+bl); 


    }


    public static void base_method()
    {
        // 创建一个集合容器，使用Collection接口的子类，ArrayList

        ArrayList al = new ArrayList();

        //1 添加元素
        al.add("java01");
        al.add("java02");
        al.add("java03");

        // 打印集合
        sop(al);

        //2 获取个数，集合长度
        sop("size:" + al.size());

        //3 删除元素
        al.remove("java01");
        sop(al);

        //4 判断元素
        sop("jav03是否存在"+al.contains("java03"));
        sop("集合是否为空"+al.isEmpty());

    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}