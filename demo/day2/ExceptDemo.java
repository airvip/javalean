/**
 * 异常：就是程序在运行时出现不正常的情况
 * 异常由来：问题也是现实生活中一个具体的事物，也可以通过Java的类的形式进行描述，并封装成对象
 *             其实就是Java对不正常情况进行描述后的对象体现。
 * 
 * 对于问题的划分：两种：一种是严重的问题，一种非严重的问题。
 * 
 * 对于严重的问题，Java通过Error类进行描述。
 *   对于Error一般不编写针对性的代码对其进行处理。
 * 
 * 对于非严重的问题，Java通过Exception类进行描述。
 *   对于Exception可以使用针对性的处理方式进行处理。
 * 
 * 
 * 无论Error或者Exception都具有一些共性内容。
 * 比如：不正常情况信息，引发原因等。
 * 
 * Throwable
 *   |- Error
 *   |- Exception 
 * 
 * 2,异常的处理
 * Java提供了特有的语句进行处理
 * try
 * {
 *     需要检测的代码
 * }
 * catch()
 * {
 *     处理异常的代码
 * }
 * finally
 * {
 *     一定会执行的语句
 * }
 * 
 * 3, 对于捕获到的异常对象常用方法操作
 *  String getMessage()
 * 
 * 在函数上声明异常
 * 便于提高安全性，让调用出进行处理，不处理编译失败
 * 
 * 对多异常的处理
 * 1.声明异常时，建议声明更为具体的异常，这样处理的可以更具体
 * 
 */

class Demo 
{
    int div(int a, int b) throws Exception
    {
        return a / b;
    }
}

class ExceptDemo 
{
    public static void main(String[] args) // throws Exception
    {
        Demo d = new Demo();
        int x = d.div(4, 0);
        System.out.println(x);

        /*try
        {
            int x = d.div(4, 0);

            System.out.println(x);
        }
        catch (Exception e)
        {
            System.out.println("除数为零");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/

        System.out.println("over");
        
    }
}