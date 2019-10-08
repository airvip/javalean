/**
 * 对于多个生产者和消费者为什么要定义while判断标记？
 * 原因：让被唤醒的线程再一次判断标记。
 * 
 * 
 * 为什么定义notifyAll？
 * 因为需要唤醒对方线程。
 * 因为只有notify,容易出现只唤醒本线程的情况，导致程序中的所有线程等待。
 */

class Resource 
{
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name)
    {
        while(flag) // 真表明生产的东西还没消费掉，等待
        {
            try{
                wait();
            }catch(Exception e){
                //
            }
        }
        this.name = name+"----"+count++;

        System.out.println(Thread.currentThread().getName() + "生产者"+this.name);
        flag = true;
        this.notifyAll();
    }

    public synchronized void out()
    {
        while(!flag){
            try{
                wait();
            }catch(Exception e){
                //
            }
        }
        System.out.println(Thread.currentThread().getName() + "....消费者"+this.name);
        flag = false;
        this.notifyAll();
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
            res.set("|包子|");
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
            res.out();;
        }
    }
}



class ProducerConsumerDemo 
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