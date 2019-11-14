import java.util.*;

/**
 * 往hashSet中存入自定义对象
 * 姓名和年龄相同为同一个人，重复元素
 *
 *        
 */

class Person
{
    private String name;
    private int age;
    Person(String name, int age)
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

    public int hashCode()
    {
        // return 60;
        return name.hashCode()+age*37;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Person))
            return false;
        
        Person p = (Person) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }

}

class HashSetTest
{
    public static void main(String[] args) {
        
        // 演示列表迭代器
        HashSet h = new HashSet();

        h.add(new Person("java", 11));
        h.add(new Person("php", 12));
        h.add(new Person("java", 11));
        h.add(new Person("python", 51));
        h.add(new Person("js", 41));
        
        sop("原集合："+ h);

        sop("python 51 在不在："+h.contains(new Person("python", 51)));
        sop(h.remove(new Person("java", 11)));



        for(Iterator it = h.iterator(); it.hasNext();)
        {
            Person p = (Person)it.next();

            sop(p.getName() + "---" + p.getAge());
        }
          
    }



    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}