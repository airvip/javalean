import java.util.Arrays;

class ArraySort
{
    public static void main(String[] args) {
        
        int[] arr1 = {3,6,1,9,2,7,4,8,5,0};
        System.out.println(Arrays.toString(arr1));
        selectSort(arr1);
        System.out.println(Arrays.toString(arr1));



        int[] arr2 = {3,6,1,9,2,7,4,8,5,0};
        System.out.println(Arrays.toString(arr2));
        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {3,6,1,9,2,7,4,8,5,0};
        System.out.println(Arrays.toString(arr3));
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));

    }


    public static void bubbleSort(int[] arr)
    {
        for(int i=0; i<arr.length-1; i++)
        {
            for(int j=0; j<arr.length-i-1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    /* int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp; */
                    swap(arr, i, j);
                }
            }
        }
    }


    public static void selectSort(int[] arr)
    {
        for(int i=0; i<arr.length-1; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[i] > arr[j])
                {
                    /* int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp; */
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int x, int y) // 一个数 异或 另一个数两次 还是该数
    {
        arr[x] = arr[x] ^ arr[y];
        arr[y] = arr[x] ^ arr[y];
        arr[x] = arr[x] ^ arr[y];
    }

}