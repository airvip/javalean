import java.util.*;
/**
 * 需求：对学生对象的年龄进行排序
 * 因为数据是以键值对形式存在的，所以要使用可以排序的Map集合。TreeMap
 * 
 */

class Student implements Comparable<Student>
{
    private String name;
    private int age;

    Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Student s)
    {
        int num = Integer.valueOf(this.age).compareTo(Integer.valueOf(s.age));
        if(num == 0)
            return this.name.compareTo(s.name);
        return num;
    }

    public int hashCode()
    {
        return name.hashCode() + age*34;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Student))
            throw new ClassCastException("type is error!");

        Student s = (Student)obj;
        return this.name.equals(s.name) && this.age == s.age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String toString()
    {
        return name+":"+age;
    }

}

class StuNameComparator implements Comparator<Student>
{
    public int compare(Student s1,Student s2)
    {
        int num = s1.getName().compareTo(s2.getName());
        if(num == 0)
            return Integer.valueOf(s1.getAge()).compareTo(Integer.valueOf(s2.getAge()));
        return num;
    }
}


 class MapTest2
 {
    public static void main(String[] args) {

        TreeMap<Student,String> tm = new TreeMap<Student,String>(new StuNameComparator());

        tm.put(new Student("java1",21),"beijing");
        // tm.put(new Student("java1",21),"undefined");
        tm.put(new Student("java03",23),"shanghai");
        tm.put(new Student("java2",22),"guangzhou");
        tm.put(new Student("java04",24),"jinan");

    
        Set<Map.Entry<Student, String>> entrySet = tm.entrySet();
        for(Iterator<Map.Entry<Student, String>> it = entrySet.iterator(); it.hasNext();)
        {
            Map.Entry<Student, String> me = it.next();
            sop(me.getKey()+"=>"+me.getValue());
        }



    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
 }