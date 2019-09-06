class FunDemo
{
    public static void main(String[] args) 
    {
        System.out.println("3 + 4 = " + getSum(3, 4));
        System.out.println("3 与 4 相等是 " + compare(3, 4));
    }


    public static int getSum(int x, int y)
    {
        return x + y;
    }

    public static boolean compare(int a, int b)
    {
        return a == b ;
    }
}