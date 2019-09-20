/**
 * 需求：简单的卖票程序
 * 多个窗口同时卖票
 * 
 * 
 * 创建线程的第二种方式：实现Runnable接口
 * 
 * 步骤：
 * 1.定义类实现Runnable接口
 * 2.覆盖Runnable接口中的run方法
 * 3.通过Thread类建立线程对象
 *     将线程要运行的代码放在该run方法。
 * 
 * 4.将Runnable接口的子类对象作为实际参数传递给Thread类的构造函数
 *     为什么要将Runnable接口的子类对象作为实际参数传递给Thread类的构造函数
 *     因为自定义的run方法所属的对象是Runnable接口的子类的方法
 * 
 * 5.调用Thread类的start方法开启线程并调用Runnable接口子类的run方法
 * 
 * 实现方式和继承方式的区别：
 * 继承Thread：线程代码存放Thread子类run方法中。
 * 实现Runnable：线程代码存放在接口的子类的run方法中。
 * 
 * 实现方式好处：避免了单继承的局限性。
 * 在定义线程时，建议使用实现方式。
 * 
 * 
 * 同步代码块
 * synchronized(对象)
 * {
 * }
 * 
 * 对象如同锁，持有锁的线程可以在同步中执行
 * 没有持有锁的线程即使获取cpu的执行权也进不去，因为没有获取锁。
 * 
 * 
 * 同步的前提：
 * 1. 必须要有两个或者两个以上的线程。
 * 2. 必须是多个线程使用同一个锁
 * 
 * 必须保证同步只能有一个线程在运行。
 * 
 * 好处：解除了多线程的安全问题。
 * 弊端：多个线程都要判断锁，比较消耗资源。
 * 
 * 
 * 同步函数使用的是哪一个锁呢？
 * 函数需要被对象调用，那么函数都有一个所属对象引用，就是this。所以同步函数使用的锁是this。
 * 
 * 
 * 如果同步函数被静态修饰后，使用的锁是什么呢？
 * 通过验证，发现不再是this。因为静态方法中也不可以定义this。
 * 
 * 静态进内存时，内存中没有本类对象，但是一定有该类对应的字节码文件对象。
 * 类名.class  该对象的类型是Class
 * 
 * 静态的同步方法，使用的锁是该方法所在类的字节码文件对象。类名.class 
 */

class Ticket implements Runnable  //extends Thread 
{
    // private static int tick = 100;
    private int tick = 100;

    Object obj = new Object();

    boolean flag = true;
    
    public void run() 
    {
        if(flag)
        {
            while (true) 
            {
                synchronized(this)
                {
                    if(tick > 0)
                    {
                        try {
                            Thread.sleep(1);
                        } catch (Exception e) {
                            //TODO: handle exception
                        }
                        // System.out.println(Thread.currentThread().getName()+ "---" + (Thread.currentThread() == this) + "---" + tick--);
                        System.out.println(Thread.currentThread().getName()+ "---" + tick--);
                    }    
                }
            }
        }
        else
        {
            while(true)
                show();
        }
        
    }

    // public static synchronized void show() 
    public synchronized void show() //this锁
    {
        if(tick > 0)
        {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                //TODO: handle exception
            }
            System.out.println(Thread.currentThread().getName()+ "--show--" + tick--);
        }
    }
}



class TicketDemo
{
    public static void main(String[] args) {


        Ticket t = new Ticket();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        // Thread t3 = new Thread(t);
        // Thread t4 = new Thread(t);
        t1.start();
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            //TODO: handle exception
        }
        t.flag = false;
        t2.start();
        // t3.start();
        // t4.start();


        /* Ticket t1 = new Ticket();
        t1.start(); */
    }
}