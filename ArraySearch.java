import java.util.Arrays;

class ArraySearch
{
    public static void main(String[] args) {
        int[] arr = {3,7,1,4,2,5,6,0,9,8};

        int index = getIndex(arr, 5);
        System.out.println("index of 5 in arr is "+index);


        int index1 = getIndex(arr, 20);
        System.out.println("index of 20 in arr is "+index1);

        int index2 = getIndex(arr, 0);
        System.out.println("index of 0 in arr is "+index2);

    }


    public static int halfSearchIndex2(int[] arr, int key)
    {
        int min=0,max=arr.length-1,mid;
        Arrays.sort(arr);
        while(min <= max)
        {
            mid = (min + max)>>1;
            if(key > arr[mid])
            {
                min = mid + 1;
            }
            else if(key < arr[mid])
            {
                max = mid -1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }


    public static int halfSearchIndex(int[] arr, int key)
    {
        int min,max,mid;
        min = 0;
        max = arr.length - 1;
        mid = (min + max) / 2;

        Arrays.sort(arr);

        while(arr[mid] != key)
        {
            if(key > arr[mid])
            {
                min = mid + 1;
                
            }
            else
            {
                max = mid - 1;
            }
            if(min > max)
                return -1;
            mid = (min + max)/2;

        }
        return mid;
    }

    
    /**
     * 获取key在数组中第一次出现的位置，如果不存在，返回-1
     * @param arr 待查询的数组
     * @param key 比较查询的数值
     * @return
     */
    public static int getIndex(int[] arr, int key)
    {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == key)
                return i;
        }
        return -1;
    }
}