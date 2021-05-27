

public class HelloWorld
{
    public static void main(String[] args) {

        for(String arg:args) {
            if ("-version".equals(arg)){
                System.out.println("v 1.0" );
                        break;
            } else if ("test".equals(arg)) {
                String s = "Hello";
                System.out.println(s);
                s = s.toUpperCase();
                System.out.println(s);
            }
        }
        if(args == null || args.length == 0) {
            int a = 12;
            Integer b = new Integer(12);
            System.out.println(a == b);


            int c = 1222;
            Integer d = new Integer(1222);
            System.out.println(c == d);
            System.out.println("Hello world");
        }
    }
}

