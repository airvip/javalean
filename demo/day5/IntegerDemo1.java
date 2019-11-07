
/**
 * 
 */


class IntegerDemo1
{

    public static void sop(Object obj)
    {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        Integer x = Integer.parseInt("128");
        Integer y = Integer.valueOf(128);
        Integer z = 128;

        sop("x==y:"+(x==y));//结果为 false
        sop("x.equals(y):"+x.equals(y));

        sop("x==z:"+(x==z));
        sop("x.equals(z):"+x.equals(z));

        sop("y==z:"+(y==z));
        sop("y.equals(z):"+y.equals(z));


        Integer a = Integer.parseInt("127");
        Integer b = Integer.valueOf(127);
        Integer c = 127;

        sop("a==b:"+(a==b)); // 结果为 true,因为a和b指向了同一个Integer对象。如果数值在byte范围内，对于新特性，如果该数值已存在，则不会开辟新空间
        sop("a.equals(b):"+a.equals(b));

        sop("a==z:"+(a==c));
        sop("a.equals(c):"+a.equals(c));

        sop("b==c:"+(b==c));
        sop("b.equals(c):"+b.equals(c));
        
    }
}