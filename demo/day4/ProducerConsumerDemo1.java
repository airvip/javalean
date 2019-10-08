import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对于多个生产者和消费者为什么要定义while判断标记？
 * 原因：让被唤醒的线程再一次判断标记。
 * 
 * 
 * 为什么定义notifyAll？
 * 因为需要唤醒对方线程。
 * 因为只有notify,容易出现只唤醒本线程的情况，导致程序中的所有线程等待。
 */

/**
 * JDK1.5中提供了多线程升级解决方案。
 * 将同步synchronizes替换成实现Lock操作。
 * 将Object中的wait，notify notifyAll 替换了 Condition 对象。
 * 该对象可以Lock锁进行获取
 * 
 * 该示例中，实现了本方只唤醒对方操作
 */
class Resource 
{
    private String name;
    private int count = 1;
    private boolean flag = false;

    private Lock lock = new ReentrantLock();
    private Condition condition_pro = lock.newCondition();
    private Condition condition_con = lock.newCondition();

    public void set(String name) throws InterruptedException
    {
        lock.lock();
        try{
            while(flag) // 真表明生产的东西还没消费掉，等待
            {
                condition_pro.await();
            }
            this.name = name+"----"+count++;

            System.out.println(Thread.currentThread().getName() + "生产者"+this.name);
            flag = true;
            condition_con.signal();
        }catch(Exception e){
            //
        }
        finally{
            lock.unlock();
        }
    }

    public void out() throws InterruptedException
    {
        lock.lock();
        try{
            while(!flag){
                try{
                    condition_con.await();
                }catch(Exception e){
                    //
                }
            }
            System.out.println(Thread.currentThread().getName() + "....消费者"+this.name);
            flag = false;
            condition_pro.signal();
        }catch(Exception e){
            //
        }
        finally{
            lock.unlock();
        }
    }


}

class Producer implements Runnable 
{
    private Resource res;

    Producer(Resource res)
    {
        this.res = res;
    }

    public void run()
    {
        while(true)
        {
            try
            {
                res.set("|包子|");
            }catch(InterruptedException e){
                //
            }
            
        }
    }
}


class Consumer implements Runnable 
{
    private Resource res;

    Consumer(Resource res)
    {
        this.res = res;
    }

    public void run()
    {
        while(true)
        {
            try
            {
                res.out();;
            }catch(InterruptedException e){
                //
            }
            
        }
    }
}



class ProducerConsumerDemo1 
{
    public static void main(String[] args) {
        Resource res = new Resource();

        Producer pro = new Producer(res);
        Consumer con = new Consumer(res);

        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);

        Thread t11 = new Thread(con);
        Thread t12 = new Thread(con);


        t1.start();
        t2.start();

        t11.start();
        t12.start();

    }
}