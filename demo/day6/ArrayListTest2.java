import java.util.*;

/**
 * 将自定义对象作为元素存储到ArrayList集合中，并去除重复元素
 * 
 * 比如：存人对象，同名同年龄，视为同一个人，为重复元素
 * 
 * 思路：
 * 1. 对人描述，将数据封装对象
 * 2. 定义容器，将人存入。
 * 3. 取出
 * 
 * 
 * List集合判断元素是否相同，依据是元素的equals方法。
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

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Person))
            return false;
        
        Person p = (Person) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }

}

class ArrayListTest2
{
    public static void main(String[] args) {

        ArrayList al = new ArrayList();

        al.add(new Person("airvip1", 24));
        al.add(new Person("airvip2", 23));
        al.add(new Person("airvip3", 22));
        al.add(new Person("airvip1", 23));
        al.add(new Person("airvip1", 24));

        al = singleElement(al);

        
        for(Iterator it = al.iterator(); it.hasNext();)
        {
            /* Object obj = it.next();
            Person item = (Person)obj; */

            Person item = (Person)it.next();

            sop( item.getName() +"..."+ item.getAge());
        }

        
    }

    public static ArrayList singleElement(ArrayList al)
    {
        // 定义一个临时容器
        ArrayList newAl = new ArrayList();

        for(Iterator it = al.iterator(); it.hasNext();)
        {
             Object obj = it.next();

             if(!newAl.contains(obj))
                 newAl.add(obj);
        }
        return newAl;
    }


    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}