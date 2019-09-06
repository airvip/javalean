/**
 * 
 */


 interface Inter 
 {
    void method();
 }

class Test
{

    /* static class Inner implements Inter
    {
        public void method()
        {
            System.out.println("method run");
        }
    } */

    static Inter function()
    {
        return new Inter()
        {
            public void method()
            {
                System.out.println("method run");
            }
        };
    }
}


class InnerClassTest
{
    public static void main(String[] args) {

        // Test.function() 说明 Test 类中有一个静态的方法 function
        // .method() function这个方法返回的结果是一个 Inter 类型的对象
        // 因为只有是 Inter 类型的对象才能 调用 method 方法
        Test.function().method();
    }
}