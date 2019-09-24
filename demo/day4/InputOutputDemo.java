/**
 * 
 * wait()
 * notify()
 * notifyAll()
 * 
 * 都使用在同步中，因为要对持有监听器(锁)的线程进行操作
 * 所以要使用在同步中，因为只有同步才具有锁。
 * 
 * 为什么这些操作线程的方法要定义在Object类中呢？
 * 因为这些方法在操作同步线程时，都必须要标识他们所操作线程持有的锁，只有同一个锁上的被等待线程，可以被同一个锁上的notify唤醒。
 * 不可以对不用锁中的线程进行唤醒。
 * 
 * 也就是说，等待和唤醒必须是同一个锁。
 * 而锁可以使任意对象，所以可以被任意对象调用的方法定义Object类中。
 * 
 * 
 */



class Res 
{
    String name;
    String sex;
    boolean flag = false;
}

class Input implements Runnable 
{
    private Res r;
    Object obj = new Object();
    Input(Res r)
    {
        this.r = r;
    }
    public void run() 
    {
        int x = 0;
        while(true)
        {
            synchronized(r){
                if(r.flag)
                    try{r.wait();}catch(Exception e){}
                if(x ==0)
                {
                    r.name = "mike";
                    r.sex = "man";
                }
                else
                {
                    r.name = "丽丽";
                    r.sex = "女";
                }
                x = (x+1) % 2;
                r.flag = true;
                r.notify();
            }
            
        }
    }
}


class Output implements Runnable 
{
    private Res r;
    Object obj = new Object();
    Output(Res r)
    {
        this.r = r;
    }
    public void run() 
    {
        while(true)
        {
            synchronized(r)
            {
                if(!r.flag)
                    try{r.wait();}catch(Exception e){}
                System.out.println(r.name+"...."+r.sex);
                r.flag = false;
                r.notify();
            }
            
        }
    }
}




class InputOutputDemo 
{
    public static void main(String[] args) {
        Res r = new Res();

        Input in = new Input(r);
        Output out = new Output(r);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();
    }
}

