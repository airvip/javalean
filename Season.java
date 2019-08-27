
public class Season
{
    public static void main(String[] args) {
        
        int n = 2;

        switch (n)
        {
            case 3:
            case 4:
            case 5:
                System.out.println(n + "春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(n + "夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println( n + "秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println( n + "冬季");
                break;
            default:
                System.out.println( n + "未知季节");
        }
    }
}