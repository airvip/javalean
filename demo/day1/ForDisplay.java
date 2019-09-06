public class ForDisplay
{
    public static void main(String[] args) {
        int sum = 0;

        for(int i = 1; i < 6; i++)
        {
            sum += i;
        }

        System.out.println("sum = " + sum);


        // while 实现

        /* int sum1 = 0 , i = 1;
        
        while(i < 6)
        {
            sum1 += i;
            i++;
        }

        System.out.println("sum1 = " + sum1); */


        for(int x = 1; x <= 9; x++)
        {
            for(int y = 1; y <= x; y++)
            {
                System.out.print( y + "*" + x + "=" + x * y + "\t");
            }
            System.out.println();
        }


        for(int x = 1; x <= 9; x++)
        {
            for(int y = 1; y <= x; )
            {
                System.out.print( y + "*" + x + "=" + x * y + "\t");
                break ;
            }
            System.out.println();
        }

        w:for(int x = 1; x <= 9; x++)
        {
            for(int y = 1; y <= x; )
            {
                System.out.print( y + "*" + x + "=" + x * y + "\t");
                break w;
            }
            System.out.println();
        }



    }
}