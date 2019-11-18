import java.util.*;

/**
 *
 *|-- TreeSet:可以对Set集合中的元素进行排序。
 *    底层数据结构是二叉树
 *    保证元素唯一性的依据：compareTo方法返回 0。
 * 
 *    TreeSet排序的第一种方式：让元素自身具备比较性。元素需要实现 Comparable 接口，覆盖compareTo方。
 *    这种方式也成为了元素的自然顺序，或者叫做默认顺序。
 * 
 *    TreeSet排序的第二种方式。
 *    当元素自身不具备比较性是，或者具备的比较性不是所需要的。
 *    这时就需要让集合自身具备比较性。
 *    定义了比较器，将比较器对象作为参数传递给TreeSet集合的构造函数
 * 
 * 当两种排序都存在是，以比较器为主。
 * 
 * 定义一个类，实现 Comparator 接口，覆盖 compare 方法。
 *    
 */
class TreeSetDemo2
{
    public static void main(String[] args) {
        
        storageCustomDemo();
          
    }



    public static void storageCustomDemo()
    {
        // TreeSet t = new TreeSet();
        TreeSet t = new TreeSet(new MyCompare());

        t.add(new Student("php", 51));
        t.add(new Student("java", 11));
        t.add(new Student("javascript", 31));
        t.add(new Student("js", 12));
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

class MyCompare implements Comparator
{
    public int compare(Object o1,Object o2)
    {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        
        int num = s1.getName().compareTo(s2.getName());

        if(num == 0)
            // return s1.getAge() - s2.getAge();
            return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));

        return num;
    }
}