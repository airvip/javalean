/**
 * 装饰设计模式
 * 当想要对已有的对象功能进行功能增强时，
 * 可以定义类，将已有对象传入，基于已有的功能，并提供加强功能。
 * 那么定义的该类称为装饰类。
 */

public class PersonDemo
{
    public static void main(String[] args) {

        Person p = new Person();
        // p.chifan();
        SuperPerson sp = new SuperPerson(p);
        sp.superChifan();
    }
} 


public class Person
{
    public void chifan()
    {
        System.out.println("eat 1");
    }
} 

public class SuperPerson
{
    private Person p;
    SuperPerson(Person p)
    {
        this.p = p;
    }

    public void superChifan()
    {
        System.out.println("eat123");
        p.chifan();
        System.out.println("eat456");
    }

}

