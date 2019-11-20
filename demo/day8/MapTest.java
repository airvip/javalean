import java.util.*;
/**
 * 每一个学生都有对应的归属地
 * 学生Student;地址 String
 * 学生属性：姓名，年龄
 * 注意：姓名和年龄相同的视为同一个学生
 * 保证学生的唯一性
 * 
 * 1.描述学生
 * 2.定义map容器，将学生作为键，地址作为值存入
 * 3.获取map集合中的元素
 * 
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



 class MapTest
 {
    public static void main(String[] args) {

        Map<Student,String> map = new HashMap<Student,String>();

        map.put(new Student("java1",21),"beijing");
        map.put(new Student("java1",21),"undefined");
        map.put(new Student("java3",23),"shanghai");
        map.put(new Student("java2",22),"guangzhou");
        map.put(new Student("java4",24),"jinan");

        // 第一种取的方式 keySet
        Set<Student> keSet = map.keySet();
        sop(keSet);

        for(Iterator<Student> it = keSet.iterator(); it.hasNext();)
        {
            Student stu = it.next();
            String addr = map.get(stu);
            sop(stu +".."+addr);
        }

        // 第二种取出方式
        Set<Map.Entry<Student, String>> entrySet = map.entrySet();
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