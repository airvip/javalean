import java.util.*;

/**
 * Collection
 *   |-- list：元素有序，元素可以重复，因为该集合体系有索引。特点：查询速度很快，但是增删稍慢
 *       |-- ArrayList:底层的数据结构使用的是数组结构。特点：增删很快，查询稍慢。线程不同步
 *       |-- LinkedList:底层使用的是链表数据结构。特点：增删速度很快，查询稍慢
 *       |-- Vector:底层是数组数据结构。线程同步。被ArrayList替代了。
 *   |-- set：元素无序，元素不可以重复。Set集合的功能和Collection是一致的。
 *       |-- HashSet:底层数据结构是哈希表。线程是非同步的。
 *             X注意：对于判断元素是否存在以及删除等操作，依赖的方法是元素的hashCode和equals方法。
 *       |-- TreeSet:可以对Set集合中的元素进行排序。
 *             底层数据结构是二叉树
 *             保证元素唯一性的依据：compareTo方法返回 0。
 * 
 *             TreeSet排序的第一种方式：让元素自身具备比较性。元素需要实现 Comparable 接口，覆盖compareTo方。
 *             这种方式也成为了元素的自然顺序，或者叫做默认顺序。
 * 
 *             TreeSet排序的第二种方式。
 *             当元素自身不具备比较性是，或者具备的比较性不是所需要的。
 *             这时就需要让集合自身具备比较性。
 *       
 * 
 * 需求：
 * 往TreeSet集合中存储自定义对象学生。
 * 想按照学生的年龄进行排序
 * 
 * 
 * 记住排序时：当主要的条件相同时，一定要判断比较一下次要条件。
 * 
 */
class TreeSetDemo
{
    public static void main(String[] args) {
        
        storageCustomDemo();
          
    }

    public static void storageStrDemo()
    {
        TreeSet t = new TreeSet();

        sop(t.add("php"));
        t.add("java");
        sop(t.add("php"));
        t.add("python");
        t.add("js");
        t.add("java");
        sop("原集合："+ t);



        for(Iterator it = t.iterator(); it.hasNext();)
        {
             sop(it.next());
        }
    }


    public static void storageCustomDemo()
    {
        TreeSet t = new TreeSet();

        t.add(new Student("php", 51));
        t.add(new Student("java", 11));
        t.add(new Student("java", 11));
        t.add(new Student("python", 11));
        
        sop("原集合："+ t);



        for(Iterator it = t.iterator(); it.hasNext();)
        {
             Student s = (Student)it.next();
             sop(s.getAge()+"---"+s.getName());
        }
    }



    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}


class Student implements Comparable
{
    private String name;
    private int age;

    Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public int compareTo(Object obj)
    {
        if(!(obj instanceof Student))
            throw new RuntimeException("不是学生对象");
        
        Student s = (Student)obj;
        if(this.age > s.age)
            return 1;
        if(this.age == s.age)
        {
            return this.name.compareTo(s.name);
        }
        return -1;
    }


}