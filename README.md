# javalean

* java 源文件编译（因为源文件是以 utf-8 编码的）

```
$ javac -encoding utf-8 FunDemo.java
$ javac -Xlint:deprecation -encoding utf-8 GenericDemo2.java
```

* 运行 java 字节码（.class文件）

```
$ java FunDemo
Windows启动jvm可以添加 -Dfile.encoding=utf-8 这样测试运行 
java -Dfile.encoding=utf-8 CalendarDemo.java  // java11之后可以java直接运行源文件
多个参数
java -Dfile.encoding=utf-8 -Dsun.jnu.encoding=utf-8 MathDemo.java
```

* 重载：只看同名函数的参数列表
* 重写：子父类方法要一模一样

final 关键字
final:最终。作为一个修饰符，可以修饰 类，函数，变量。
被 final 修饰的类不可以被继承。
类为了避免被继承，被子类重写，就把类用 final 修饰。
被 final 修饰的方法不可以被重写。
被 final 修饰的变量是一个常量只能赋值一次，即可以修饰成员变量，又可以修饰局部变量。

abstract class Person
{
}

抽象类特点
1. 抽象方法一定定义在抽象类中
2. 抽象方法和抽象类都必须被 abstract 关键字修饰
3. 抽象类不可以用 new 创建对象，因为调用抽象方法没有意义。
4. 抽象类中的方法要被使用，必须由子类复写所有的抽象方法后，建立子类对象调用。
   如果子类只覆盖了部分抽象方法，那么该子类还是一个抽象类。


class 定义类
interface 定义接口

interface A 
{
}

接口定义时，格式特点：
1、接口常见定义：常量、抽象方法
2、接口中的成员都是有固定修饰符
    常量：public static final
    方法：public abstract

切记：接口中的成员都是 public

接口是不可以创建对象的，因为有抽象方法。需要被子类实现，子类对接口中的抽象方法全部覆盖(重写)后，子类才可以实例化，否则子类是一个抽象类。

接口可以被类多实现，也是对多继承不支持的转换形式，Java支持多实现。

多态：可以理解为事物存在的多种体现形态。
例如：人》男人，女人   动物》猫，狗

1.多态的体现 DuotaiDemo1.java
    父类的引用指向了自己的子类对象。即：父类的引用也可以接受自己的子类对象。
2.多态的前提
    必须是类与类之间有关系，要么继承，要么实现。
    通常还有一个前提是存在覆盖(重写)。
3.多态的好处
    多态的出现大大的提高了程序的扩展性
4.多态的弊端
    提高了扩展性，但是只能使用父类的引用访问父类中的成员。
5.多态的应用

多态中成员函数(非静态)的特点：
在编译时期：参阅引用型变量所属的类中是否有调用的方法，如果有，编译通过，如果没有编译失败。
在运行时期：参与对象所属的类中是否有调用的方法。
简单总结就是：成员函数在多态调用时，编译看左边，运行看右边。

多态中成员函数(静态)的特点：
无论编译和运行，都参考左边。

多态中成员变量的特点：
无论编译和运行，都参考左边(引用型变量所属的类)。


内部类

访问格式
当内部类定义在外部类的成员位置上且为非私有，可以在外部其他类中，直接建立内部类对象。
格式： 外部类名.内部类名 变量名= 外部类对象.内部类对象 如：Outer.Inner in = new Outer().new Inner();
当内部类定义在外部类的成员位置上就可以被成员修饰符所修饰。
    比如，private:将内部类在外部类中进行封装
         static:内部类就具有了static的特性。
         当内部类被static修饰后，只能直接访问外部类中的static成员，出现了访问局限。

         在外部其他类中，如何直接访问static内部类的非静态成员呢？
         new Outer.Inner().function()

         在外部其他类中，如何直接访问static内部类的静态成员呢？
         Outer.Inner.function()

    注意：当内部类中定义了静态成员，该内部类必须是static的。


内部类访问特点：
1. 内部类可以直接访问外部类的成员，包括私有。
    内部类之所以可以直接访问外部类的成员，是因为内部类中持有了一个外部类的引用，格式：外部类.this
2. 外部类要访问内部类，必须建立内部类对象。

内部类可以用 private 进行修饰


# 压缩生成 jar 包
sdqhw@airvip MINGW64 /e/workspace/javas/demo/day2 (master)
$ jar -cf jarm.jar pack packa

# 查看 jar 包内容
sdqhw@airvip MINGW64 /e/workspace/javas/demo/day2 (master)
$ jar -tf jarm.jar


会报警告 int num = new Integer(o2.length()).compareTo(new Integer(o1.length()));
推荐使用 int num = Integer.valueOf(o2.length()).compareTo(Integer.valueOf(o1.length()));