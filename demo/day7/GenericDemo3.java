import java.util.*;

/**
 * 什么时候定义泛型类？
 * 当类中要操作的引用数据类型不确定的时候。
 * 早期定义Object来完成扩展。
 * 现在定义泛型来完成扩展。
 * 
 */

class Worker
{

}

class Student
{

}

class Tool
{
    private Object obj;
    public void setObject(Object obj)
    {
        this.obj = obj;
    }

    public Object getObject()
    {
        return obj;
    }
}


/*
class Tool
{
    private Worker w;
    public void setWorker(Worker w)
    {
        this.w = w;
    }

    public Worker getWorker()
    {
        return w;
    }
}
*/

// 泛型类
class Utils<QQ>
{
    private QQ q;
    public void setObject(QQ q)
    {
        this.q = q;
    }

    public QQ getObject()
    {
        return q;
    }
}

class GenericDemo3
{
    public static void main(String[] args) {
        
        /* Tool t = new Tool();

        t.setObject(new Worker());
        Worker w = (Worker)t.getObject(); */


        Utils<Worker> u = new Utils<Worker>();
        u.setObject(new Worker());
        Worker w = u.getObject();


    }

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}

