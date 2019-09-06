interface Inter
{
    public static final int NUM = 3;
    public abstract void show();
    public abstract int getNum();
}

interface Inter2
{
    public abstract void meth();
}


class Test implements Inter,Inter2
{
    public void show()
    {

    }

    public void meth()
    {

    }

    public int getNum(){
        return NUM;
    }
}

class InterfaceDemo
{
    public static void main(String[] args) {
        Test t = new Test();
        // System.out.println(t.NUM);
        System.out.println(t.getNum());
        System.out.println(Test.NUM);
        System.out.println(Inter.NUM);
    }
}


interface A 
{
    void methodA();
}

interface B extends A
{
    void methodB();
}

interface C extends B
{
    void methodC();
}

class D implements C 
{
    public void methodA(){}
    public void methodB(){}
    public void methodC(){}
}



interface F 
{
    void methodF();
}

interface G
{
    void methodG();
}

interface H extends F,G
{
    void methodC();
}