import java.util.*;
/**
 * ? 通配符，也可以理解为占位符。
 * 泛型的限定：
 * ? extends E:可以接收 E 类型或者 E 的子类型。上限。
 * ? super E: 可以接收 E类型或者 E 的父类型。下限。
 */

class GenericDemo6
{
    public static void main(String[] args) {

        /* ArrayList<String> al = new ArrayList<String>();
        al.add("abc1");
        al.add("abc3");
        al.add("abc2");
        al.add("abc4");

        ArrayList<Integer> al1 = new ArrayList<Integer>();
        al1.add(3);
        al1.add(1);
        al1.add(4);
        al1.add(2);

        printColl(al);
        printColl(al1); */

        ArrayList<Person> al = new ArrayList<Person>();
        al.add(new Person("abc"));
        al.add(new Person("abc1"));
        al.add(new Person("abc2"));

        // printColl(al);

        ArrayList<Student> al1 = new ArrayList<Student>();
        al1.add(new Student("abc"));
        al1.add(new Student("abc1"));
        al1.add(new Student("abc2"));

        printColl(al1); // ArrayList<Person> al = new ArrayList<Student>();

       

    }


    public static void printColl(ArrayList<? extends Person> al)
    {
        
        for(Iterator<? extends Person> it = al.iterator(); it.hasNext();)
        {
            sop(it.next().getName());
        }

    }


    /* public static void printColl(ArrayList<?> al)
    {
        
        for(Iterator<?> it = al.iterator(); it.hasNext();)
        {
            sop(it.next());
        }

    } */

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}

class Person
{
    private String name;
    Person(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
}
class Student extends Person
{
    Student(String name)
    {
        super(name);
    }
}
