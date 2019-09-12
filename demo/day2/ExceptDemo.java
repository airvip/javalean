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
 * 2.对方声明几个异常，就对应有几个catch块。不要定义多余的catch块。
 *     如果多个catch块中的异常出现继承关系，父类异常的catch块放在最下面。
 * 
 * 建立在进行catch处理时，catch中一定要定义具体的处理方式。
 * 不要简单定义一句 e.printStackTrace()
 * 也不要就简单的就书写一句输出语句。
 * 
 * 
 * 
 * 因为项目中会出现特有的问题
 * 而这些问题并未被Java所描述并封装对象
 * 所以对于这些特有的问题可以按照Java的对问题封装的思想，将特有的问题进行自定义的异常封装。
 * 
 * 
 * 当函数内不出现了throw抛出异常对象，那么就必须要给对应的处理对象动作。
 * 要么在内部 try catch处理。
 * 要么在函数声明上让调用者处理。
 * 
 * 
 * throws 和 throw 的区别
 * throws 使用在函数上
 * throw 使用在函数内
 * 
 * throws 后面跟的异常类。可以跟多个，用逗号隔开
 * throw 后面跟的是异常对象
 * 
 * 
 * Exception中有一个特殊的子类异常RuntimeException运行时异常
 * 如果在函数内容内抛出该异常，函数是上可以不声明，编译一样通过。
 * 如果在函数是哪个声明了该异常，调用者可以不用进行处理，编译一样通过。
 * 
 * 自定义异常时：如果该异常的发生，无法再继续运算，就让自定义异常继承 RuntimeException
 * 
 * 对于异常分两种：
 * 1. 编译时被检测的异常
 * 2.编译时不被检测的异常（运行时异常，RuntimeException以及其子类）
 */

class FuShuException extends Exception
 {
    private static final long serialVersionUID = 1L;

    FuShuException(String msg)
    {
        super(msg);
    }

 }

class Demo 
{
    int div(int a, int b) throws FuShuException
    {
        if(b < 0)
            throw new FuShuException("除数为负数");

        return a / b;
    }
}

class ExceptDemo 
{
    public static void main(String[] args) // throws Exception
    {
        Demo d = new Demo();
        try
        {
            int x = d.div(4, -1);
            System.out.println(x);
        }
        catch(FuShuException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("finally"); // finally中存放的是一定会被执行的代码
        }
        

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