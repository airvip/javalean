import java.util.Arrays;
import static java.util.Arrays.*; // 导入的是Arrays这个类中的所有静态成员

/**
 * StaticImport 静态导入
 * 
 * 当类名重名时，要指定具体的包名。
 * 当方法重名时，要指定具备所属的对象或者类。
 */

public class StaticImport
{

    public static void main(String[] args) {
        int[] arr = {1,6,3,8};

        sort(arr);
        sop(Arrays.toString(arr));

        int index = binarySearch(arr, 6);
        sop(index);

        
    }


    public static void sop(Object obj)
     {
         System.out.println(obj);
     }

}