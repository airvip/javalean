/**
 * 进程：是一个正在执行中的程序。
 *     每一个进程执行都有一个执行顺序。该顺序是一个执行路径，或者叫一个控制单元。
 * 
 * 线程：是进程中的一个独立的控制单元
 *     线程在控制着进程的执行。
 * 
 * 一个进程中至少有一个线程。
 * 
 * java vm启动时会有一个进程 java.exe ,该进程中至少有一个线程负责Java程序的执行。
 * 而且这个线程运行的代码存在于main方法中，该线程称之为主线程。
 * 
 * 扩展：其实更细节说明jvm,jvm启动不止一个线程，还有负责垃圾回收机制的线程。
 * 
 * 
 * 1.如何在自定义的代码中定义一个线程
 *
 * 通过对 API 的查找，Java已经提供了对线程这类事物的描述，就是Thread类。
 * 
 * 创建线程的第一种方式：继承 Thread 类。
 * 步骤：
 * 1. 定义类继承Thread
 * 2. 复写Thread类中的run方法。
 * 3. 调用线程的start方法，该方法有两个作用：启动线程，调用run方法。
 * 
 * 
 * 发现运行结果每一次都不同，因为多个线程都获取cpu的执行权。cpu执行到谁，谁就运行。
 * 明确一点，在某一时刻，只能有一个程序在运行。（多核除外）
 * cpu在做着快速的切换，已达到看上去是同时运行的效果。
 * 我们可以形象把多线程的运行行为在互相抢夺cpu的执行权限。
 * 
 * 这就是多线程的一个特性：随机性，谁抢到谁执行，至于执行多长，cpu说了算。
 * 
 */

class Demo extends Thread 
{
    public void run() 
    {
        for(int i=0; i<60; i++)
        {
            System.out.println("demo run"+i);
        }
    }
}



class ThreadDemo1
{
    public static void main(String[] args) {
        


        Demo d = new Demo();
        d.start();

        for (int i=0; i<60; i++)
        {
            System.out.println("hello world!"+i);
        }


    }
}