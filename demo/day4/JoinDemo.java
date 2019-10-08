/**
 * join:当A线程执行到B线程的 .join() 方法时，A就会等待，等B 线程都执行结束，A才会执行。
 * 
 * join可以用来临时加入线程执行
 */


class Demo implements Runnable 
{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int x=0; x<70; x++)
        {
            System.out.println(Thread.currentThread().getName()+"---"+x);
        }
        
    }
}


class JoinDemo 
{
    public static void main(String[] args) throws Exception
    {
        Demo d = new Demo();

        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);
        t1.start();
        t2.start();
        t1.join();

        for(int x=0; x<80; x++)
        {
            System.out.println("main..."+x);
        }

        System.out.println("main over");


    }
}