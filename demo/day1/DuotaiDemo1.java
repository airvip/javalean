abstract class Animal 
{
    public abstract void eat();
}

class Cat extends Animal
{
    public void eat()
    {
        System.out.println("eat fish");
    }

    public void catchMouse()
    {
        System.out.println("catch mouse");
    }
}

class Dog extends Animal
{
    public void eat()
    {
        System.out.println("吃骨头");
    }

    public void kanJia()
    {
        System.out.println("看家");
    }
}

class Pig extends Animal
{
    public void eat()
    {
        System.out.println("吃饲料");
    }

    public void gongDi()
    {
        System.out.println("拱地");
    }
}


class DuotaiDemo1
{
    public static void main(String[] args) {

        // System.out.println("多态就是通过 代码一，二，三逐步演化来的");
        
        /* 
        //System.out.println("代码一");
        Cat c = new Cat();
        c.eat();

        Dog d = new Dog();
        d.eat(); */

        /*System.out.println("代码二");
        Cat c = new Cat();
        // Cat c1 = new Cat();
        function(c);
        // function(c1);

        function(new Dog());
        function(new Pig()); */

        function(new Cat());
        function(new Dog());
        function(new Pig());

        /* Animal a = new Cat(); //类型提升，(向上转型)
        a.eat();
        Cat c = (Cat) a;
        c.catchMouse(); */


        // 如果想要调用猫的特有方法时，应该如何操作？
        // 强制将父类的引用，转成子类型。(向下转型)

        

        // 错误操作：千万不要将父类对象转换成子类对象
        // 我们能转换的是父类的引用指向了自己子类的对象是，该引用可以被提升，也可以被强制转换

    }


    /* 
    // 代码二
    public static void function(Cat c)
    {
        c.eat();
    }
    public static void function(Dog d)
    {
        d.eat();
    }
    public static void function(Pig p)
    {
        p.eat();
    } */

    public static void function(Animal a)
    {
        a.eat();
        if(a instanceof Cat)
        {
            Cat c = (Cat)a;
            c.catchMouse();
        }
        else if(a instanceof Dog)
        {
            Dog d = (Dog)a;
            d.kanJia();
        }
        else if(a instanceof Pig)
        {
            Pig p = (Pig) a;
            p.gongDi();
        }
    }

}