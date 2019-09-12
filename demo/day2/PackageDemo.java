package pack;

class PackageDemo
{
    public static void main(String[] args) {
        packa.DemoA d = new packa.DemoA();
        d.show();
    }
}



/**
 * 
 * PackageDemo.java:6: 错误: 找不到符号
        DemoA d = new DemoA();
        ^
  符号:   类 DemoA
  位置: 类 PackageDemo
PackageDemo.java:6: 错误: 找不到符号
        DemoA d = new DemoA();
                      ^
  符号:   类 DemoA
  位置: 类 PackageDemo
2 个错误

错误原因：类名写错
因为类名的全名是：包名.类名
 * 
 * 
 * 
 * 总结：
 *     包与包之间进行访问，被访问的包中的类以及类中的成员需要public修饰。
 *     不同包中的子类还可以直接访问父类中被protected权限修饰的成员。
 * 
 * 包与包之间可以使用的权限只有两种 public protected
 * 
 * 
 * 
 *              public    protected    default    private
 * 同一类中      ok        ok           ok         ok
 * 同一包中      ok        ok           ok         
 * 子类         ok        ok                  
 * 不同包中      ok  
 * 
 */