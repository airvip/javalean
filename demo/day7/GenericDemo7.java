import java.util.*;
/**
 * ? 通配符，也可以理解为占位符。
 * 泛型的限定：
 * ? extends E:可以接收 E 类型或者 E 的子类型。上限。
 * ? super E: 可以接收 E类型或者 E 的父类型。下限。
 */

class GenericDemo7
{
    public static void main(String[] args) {

        /* TreeSet<Student> ts = new TreeSet<Student>(new StuComp());
        ts.add(new Student("acc"));
        ts.add(new Student("abc1"));
        ts.add(new Student("aac2")); 

        for(Iterator<Student> it=ts.iterator(); it.hasNext();)
        {
            sop(it.next().getName());
        } */

        /* TreeSet<Worker> ts1 = new TreeSet<Worker>(new WorkerComp());
        ts1.add(new Worker("wacc--"));
        ts1.add(new Worker("wabc--1"));
        ts1.add(new Worker("waac--2"));

        for(Iterator<Worker> it=ts1.iterator(); it.hasNext();)
        {
            sop(it.next().getName());
        } */

        TreeSet<Student> ts = new TreeSet<Student>(new Comp());
        ts.add(new Student("acc"));
        ts.add(new Student("abc1"));
        ts.add(new Student("aac2")); 

        for(Iterator<Student> it=ts.iterator(); it.hasNext();)
        {
            sop(it.next().getName());
        }

        TreeSet<Worker> ts1 = new TreeSet<Worker>(new Comp());
        ts1.add(new Worker("wacc--"));
        ts1.add(new Worker("wabc--1"));
        ts1.add(new Worker("waac--2"));

        for(Iterator<Worker> it=ts1.iterator(); it.hasNext();)
        {
            sop(it.next().getName());
        }


    }

    public static void printColl(ArrayList<? extends Person> al)
    {
        
        for(Iterator<? extends Person> it = al.iterator(); it.hasNext();)
        {
            sop(it.next().getName());
        }

    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}

/* class StuComp implements Comparator<Student>
{
    public int compare(Student s1, Student s2)
    {
        return s1.getName().compareTo(s2.getName());
    }
} 

class WorkerComp implements Comparator<Worker>
{
    public int compare(Worker s1, Worker s2)
    {
        return s1.getName().compareTo(s2.getName());
    }
}
*/

class Comp implements Comparator<Person>
{
    public int compare(Person p1, Person p2)
    {
        return p1.getName().compareTo(p2.getName());
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
class Worker extends Person
{
    Worker(String name)
    {
        super(name);
    }
}
