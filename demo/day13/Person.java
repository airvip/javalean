import java.io.Serializable;

class Person implements Serializable
{
    public static final long serialVersionUID = 42L;
    private String name;
    private int age;
    Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String toString()
    {
        return this.name + ":" + this.age;
    }
}