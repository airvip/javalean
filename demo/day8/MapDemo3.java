import java.util.*;
/**
 * map集合的扩展知识
 * map集合被使用是因为具备映射关系
 * 
 * "yureban"  "01"  "zs"
 * "yureban"  "02"  "ls"
 * 
 * "jiuye"  "01"  "ww"
 * "jiuye"  "02"  "ml"
 */

class Student
{
    private String no;
    private String name;

    Student(String no, String name)
    {
        this.no = no;
        this.name = name;
    }

    public String toString()
    {
        return no+":"+name;
    }

}

 class MapDemo3
 {

    public static void demo()
    {
        HashMap<String,List<Student>> school = new HashMap<String,List<Student>>();

        List<Student> yure = new ArrayList<Student>();
        List<Student> jiuye = new ArrayList<Student>();

        yure.add(new Student("02","ls"));
        yure.add(new Student("01","zs"));
        jiuye.add(new Student("01","ww"));
        jiuye.add(new Student("02","ww"));

        school.put("yure", yure);
        school.put("jiuye", jiuye);

        Set<Map.Entry<String,List<Student>>> entrySet = school.entrySet();
        for(Iterator<Map.Entry<String,List<Student>>> it = entrySet.iterator(); it.hasNext();)
        {
            Map.Entry<String,List<Student>> room = it.next();
            getInfos(room.getValue());
        }

    }

    public static void getInfos(List<Student> li)
    {
        for(Iterator<Student> it=li.iterator(); it.hasNext();)
        {
            Student stu = it.next();
            sop(stu);
        }
    }


    public static void main(String[] args) {

        demo();

        /* HashMap<String,String> yureban = new HashMap<String,String>();
        yureban.put("02","ls");
        yureban.put("01","zs");

        HashMap<String,String> jiuye = new HashMap<String,String>();
        jiuye.put("01","ww");
        jiuye.put("02","ml");

        HashMap<String,HashMap<String,String>> school = new HashMap<String,HashMap<String,String>>();
        school.put("yureban",yureban);
        school.put("jiuye",jiuye);

        Set<Map.Entry<String, HashMap<String,String>>> scEntrySet = school.entrySet();
        for(Iterator<Map.Entry<String, HashMap<String,String>>> it = scEntrySet.iterator(); it.hasNext();)
        {
            Map.Entry<String, HashMap<String,String>> sc = it.next();
            getStudebtInfo(sc.getValue());
        } */

    }
    
    public static void getStudebtInfo(HashMap<String,String> room)
    {
        Set<Map.Entry<String, String>> entrySet = room.entrySet();
        for(Iterator<Map.Entry<String, String>> it=entrySet.iterator(); it.hasNext();)
        {
            Map.Entry<String, String> stu = it.next();
            sop("No:"+stu.getKey()+",name:"+stu.getValue());
        }
        
    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
 }