class Fu
{
    int num = 5;
    void speak(){
        System.out.println("C");
    }
}

class Zi extends Fu
{
    int num = 1;

    void show(){
        System.out.println(super.num);
    }

    void speak(){
        System.out.println("JAVA");
    }
}

class ExtendsDemo
{
    public static void main(String[] args) {
        Zi z = new Zi();
        z.show();
        z.speak();
    }
}